package com.fr.function;

import com.fr.log.FRLoggerFactory;
import com.fr.script.AbstractFunction;

import java.time.LocalDate;

/**
 * 构建累计项 的公式
 * @author : dengxuelong
 * @date : 2018/12/10 11:15
 */
public class AccumulativeFormula extends AbstractFunction {
    /**
     * 公式中的分割符
     */
    private final String SPLIT_CHAR = ":";
    /**
     * 公式中的加权平均  前缀  avg:10010:10011
     */
    private final String avg = "avg";
    /**
     * 公式中的月加权平均  前缀  权是根据一个月有多少天计算而来的   avgMonth:10010
     */
    private final String avgMonth = "avgMonth";
    /** 累计*/
    private final String accumulative = "sum";
    /** 取最后一月*/
    private final String lastMonth = "lastMonth";
    /** 取其他项的累计值进行计算*/
    private final String total = "total";

    /**
     * 0 formula    数据库中存储的累计公式  比如avgMonth:10010   <br/>
     * 1 startCol   月数据开始的列   <br/>
     * 2 row        月数据所在的行   <br/>
     * 3 count      统计几个月的数据   <br/>
     * 4 year       数据所在的年   <br/>
     * 5 startMonth 从哪个月开始计算   <br/>
     * 6 index_id_grid   所在的行列  比如:B2   <br/>
     * 7 current_grid  本项所在的列   <br/>
     * @param objects
     * @return
     */
    @Override
    public Object run(Object[] objects) {
        try{
            //累计列存储在数据库中的公式
            String formula = String.valueOf(objects[0]);

            //根据':'分割公式
            String[] formulaArr = formula.split(SPLIT_CHAR);
            //公式类型
            String formulaType = formulaArr[0];

            if (avg.equals(formulaType)) {
                //加权平均
                return calculateWeightedAvg(formula,(String)objects[1],(Integer)objects[2],(Integer)objects[3],(String)objects[6]);
            }else if(avgMonth.equals(formulaType)){
                //月加权平均
                return calculateMonthWeightedAvg(formula,(String)objects[1],(Integer)objects[2],(Integer)objects[3],Integer.parseInt(objects[4]+""),(Integer)objects[5],(String)objects[6]);
            }else if(accumulative.equals(formulaType)){
                //累计
                return calculateAccumulate((String)objects[1],(Integer)objects[2],(Integer)objects[3]);
            }else if(lastMonth.equals(formulaType)){
                //最后一月
                return calculateLastMonth((String)objects[1],(Integer)objects[2],(Integer)objects[3]);
            }else if(total.equals(formulaType)){
                //根据其他项的累计值进行计算
                return caculateTotal(formula,(String)objects[6],(String)objects[7]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            FRLoggerFactory.getLogger().error("ArrayIndexOutOfBoundsException",e);
        }catch (Exception e){
            e.printStackTrace();
            FRLoggerFactory.getLogger().error("方法入参:  "+arrayToString(objects),e);
        }
        return null;
    }

    /**
     * 构建加权平均计算公式
     *
     * @param formula  数据库中存储的加权平均公式  avg:10010:10011
     * @param startCol 月数据开始的列
     * @param row      月数据所在的行
     * @param count    统计几月数据的加权平均
     * @param indexIdPath index_id所在的行列  比如B2
     * @return 加权平均计算公式
     */
    public String calculateWeightedAvg(String formula, String startCol, Integer row, Integer count, String indexIdPath) {
        //计算加权平均的公式 应该包含3部分
        int formulaLen = 3;

        //使用：分割公式
        String[] formulaArr = formula.split(SPLIT_CHAR);

        if (formulaArr.length != formulaLen) {
            //公式不合法  直接返回
            return "";
        }

        //通过这2个index_id构建公式
        String index_id1 = formulaArr[1];
        String index_id2 = formulaArr[2];

        //构建公式的第一部分
        StringBuilder result = new StringBuilder("if(")
                .append(buildRowFormulaWithIndexId(index_id1, row, startCol,indexIdPath))
                .append(" = 0, 0, (");
        //构建公式的第二部分  (求累计值)
        for (int i = 0; i < count; i++) {
            String newCol = rowAdd(startCol, i);
            result.append(buildRowFormulaWithIndexId(index_id1, row, newCol,indexIdPath))
                    .append(" * ")
                    .append(buildRowFormulaWithIndexId(index_id2, row, newCol,indexIdPath));
            if (i != count - 1) {
                result.append(" + ");
            }
        }
        result.append(") / (");

        //计算公式的第三部分  权累计
        for (int i = 0; i < count; i++) {
            String newCol = rowAdd(startCol, i);
            result.append(buildRowFormulaWithIndexId(index_id1, row, newCol,indexIdPath));
            if (i != count - 1) {
                result.append(" + ");
            }
        }
        result.append("))");
        return result.toString();
    }

    /**
     * 构建【月加权平均】计算公式
     *
     * @param formula    数据库中存储的月加权平均公式  avgMonth:10010
     * @param startCol   月数据开始的列
     * @param row        月数据所在的行
     * @param count      统计几月数据的加权平均
     * @param year       数据所在的年
     * @param startMonth 从哪个月开始计算
     * @param indexIdPath  index_id所在的行列 比如B2
     * @return 月加权平均计算公式
     */
    public String calculateMonthWeightedAvg(String formula, String startCol, Integer row, Integer count, Integer year, Integer startMonth,String indexIdPath) {
        //月加权平均的公式 应该包含2部分
        int formulaLen = 2;

        //使用：分割公式
        String[] formulaArr = formula.split(SPLIT_CHAR);

        if (formulaArr.length != formulaLen) {
            //公式不合法  直接返回
            return "";
        }

        //通过这个index_id构建公式
        String index_id1 = formulaArr[1];

        StringBuilder result = new StringBuilder("(");
        //要统计的数据总共有多少天
        int dayTotal = 0;
        for (int i = 0; i < count; i++) {
            LocalDate localDate =LocalDate.of(year,startMonth + i,1);
            String newCol = rowAdd(startCol, i);
            result.append(buildRowFormulaWithIndexId(index_id1, row, newCol,indexIdPath))
                    .append(" * ")
                    .append(localDate.lengthOfMonth());

            dayTotal += localDate.lengthOfMonth();

            if (i != count - 1) {
                result.append(" + ");
            }
        }
        result.append(") / ").append(dayTotal);
        return result.toString();
    }

    /**
     * 构建【累计值】计算公式
     *
     * @param startCol   月数据开始的列
     * @param row        月数据所在的行
     * @param count      统计几月数据的累计
     * @return 累计值计算公式
     */
    public String calculateAccumulate(String startCol, Integer row, Integer count) {

        StringBuilder result = new StringBuilder();
        //要统计的数据总共有多少天
        for (int i = 0; i < count; i++) {
            String newCol = rowAdd(startCol, i);
            result.append("eval(")
                    .append(newCol)
                    .append(row)
                    .append(")");

            if (i != count - 1) {
                result.append(" + ");
            }
        }
        return result.toString();
    }

    /**
     * lastMonth
     * 构建【最后一月】计算公式
     *
     * @param startCol   月数据开始的列
     * @param row        月数据所在的行
     * @param count      统计几月数据的累计
     * @return 累计值计算公式
     */
    public String calculateLastMonth(String startCol, Integer row, Integer count) {
        return new StringBuilder("eval(").append(rowAdd(startCol,count-1)).append(row).append(")").toString();
    }


    /**
     * 构建帆软计算公式（根据其他项的累计值来计算）
     * <p>替换掉【数据库中存储的公式】中的占位符</p>
     * @param formula 数据库中存储的累计公式  eg： total:IF(currentGrid[!0]{indexIdGrid=10100}=0, 0, currentGrid[!0]{indexIdGrid=11200} * 100 /( currentGrid[!0]{indexIdGrid=10100} + currentGrid[!0]{indexIdGrid=10900}))
     * @param indexIdGrid 帆软页面index_id所在的单元格  比如B2
     * @param currentGrid 帆软页面本项所在的单元格  比如H2
     * @return 计算公式
     */
    public String caculateTotal(String formula, String indexIdGrid,String currentGrid){
        //数据库公式中indexIdGrid占位符
        String indexIdGridPlaceHolder = "indexIdGrid";
        //数据库公式中currentGrid占位符
        String currentGridPlaceHolder = "currentGrid";
        //total IF(Q5=0,0,Q31*100/(Q5+Q24))
        //total:IF(currentGrid[!0]{indexIdGrid=10100}=0, 0, currentGrid[!0]{indexIdGrid=11200} * 100 /( currentGrid[!0]{indexIdGrid=10100} + currentGrid[!0]{indexIdGrid=10900}))
        String result = formula.split(SPLIT_CHAR)[1];
        result = result.replace(indexIdGridPlaceHolder,indexIdGrid);
        result = result.replace(currentGridPlaceHolder,currentGrid);
        return result;
    }


    /**
     * 构建访问某行的公式
     *
     * @param indexId index_id
     * @param row      行
     * @param col      列  比如A/B/C
     * @param indexPath index_id所在的行列  比如B2
     * @return buildRowFormulaWithIndexId(10010, 2, C) 返回  C2[!0]{index_id=10010}
     */
    private String buildRowFormulaWithIndexId(String indexId, Integer row, String col,String indexPath) {
        return new StringBuilder("eval(")
                .append(col)
                .append(row)
                .append("[!0]{")
                .append(indexPath)
                .append("=")
                .append(indexId)
                .append("})")
                .toString();
    }

    /**
     * 列相加
     * <p>约定参数row不为空 且列加上一个数后还是一个英文字母  比如 Z+1=[ 不是一个字母</p>
     *
     * @param col   列  A、B、C
     * @param count
     * @return eg:rowAdd("A",2)将返回C
     */
    private String rowAdd(String col, Integer count) {
        char c = col.charAt(0);
        char c1 = (char) (c + count);
        return c1 + "";
    }

    /** array ==> String */
    private String arrayToString(Object o[]){
        StringBuilder sb = new StringBuilder();
        for (Object o1 : o) {
            sb.append(o1.toString()).append("   ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new AccumulativeFormula().buildRowFormulaWithIndexId("10010",2,"C"));
//        System.out.println(new AccumulativeFormula().calculateWeightedAvg("avg:13200:13000", "F", 2, 5));
//        System.out.println(new AccumulativeFormula().calculateMonthWeightedAvg("avgMonth:10010", "F", 2, 5,2018,1));
//        R2, "M", 2, 1, 2018, 1,"B2"
        System.out.println(new AccumulativeFormula().run(new Object[]{"avg:13200:13000", "M", 2, 1,2018,1,"B2"}));
        //R2, "F", 2, 8, $year, 1, "B2","Z2"
        System.out.println(new AccumulativeFormula().run(new Object[]{"avgMonth:50100", "F", 2, 8,"2018",1,"B2","Z2"}));
        System.out.println(new AccumulativeFormula().run(new Object[]{"sum", "F", 2, 5,2018,1,"B2"}));
        System.out.println(new AccumulativeFormula().run(new Object[]{"lastMonth", "F", 2, 5,2018,1,"B2"}));
        System.out.println(new AccumulativeFormula().run(new Object[]{"total:IF(currentGrid[!0]{indexIdGrid=10100}=0, 0, currentGrid[!0]{indexIdGrid=11200} * " +
                "100 /( currentGrid[!0]{indexIdGrid=10100} + currentGrid[!0]{indexIdGrid=10900}))", "F", 2, 5,2018,1,"B2","J2"}));


    }
}
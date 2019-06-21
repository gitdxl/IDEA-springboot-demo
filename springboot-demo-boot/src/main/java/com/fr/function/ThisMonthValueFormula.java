package com.fr.function;

import com.fr.log.FRLoggerFactory;
import com.fr.script.AbstractFunction;

/**
 * 构建本月数据公式
 * @author : dengxuelong
 * @date : 2018/12/13 17:28
 */
public class ThisMonthValueFormula extends AbstractFunction {
    /**
     * 公式中的分割符
     */
    private final String SPLIT_CHAR = ":";
    /** 取其他项的累计值进行计算*/
    private final String total = "total";

    /**
     * 构建本月数据公式
     * 0  数据库中存储的【本月数据计算公式】
     * 1  帆软页面【index_id】所在的单元格  比如B2
     * 2  帆软页面【本月累计值】所在的单元格  比如H2
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

            if (total.equals(formulaType)) {
                //根据【其他项的累计值】构建【本月数据计算公式】
                return cacullateTotal(formula,(String)objects[1],(String) objects[2]);
            }
            return formula;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            FRLoggerFactory.getLogger().error("ArrayIndexOutOfBoundsException",e);
        }catch (Exception e){
            e.printStackTrace();
            FRLoggerFactory.getLogger().error("",e);
        }
        return null;
    }

    /**
     * 构建帆软本月数据计算公式（根据其他项的累计值来计算）
     * <p>替换掉【数据库中存储的公式】中的占位符</p>
     * @param formula 数据库中存储的累计公式  eg： total:IF(totalGrid[!0]{indexIdGrid=20700}, 0, totalGrid[!0]{indexIdGrid=20100} / totalGrid[!0]{indexIdGrid=20700} * 100)
     * @param indexIdGrid 帆软页面index_id所在的单元格  比如B2
     * @param totalGrid 帆软页面本月累计值所在的单元格  比如H2
     * @return 计算公式
     */
    public String cacullateTotal(String formula, String indexIdGrid,String totalGrid){
        //数据库公式中indexIdGrid占位符
        String indexIdGridPlaceHolder = "indexIdGrid";
        //数据库公式中currentGrid占位符
        String totalGridPlaceHolder = "totalGrid";
        // IF(G71=0,0,G65/G71*100)   IF(20700=0,0,20100/20700*100)
        // total:IF(totalGrid[!0]{indexIdGrid=20700}, 0, totalGrid[!0]{indexIdGrid=20100} / totalGrid[!0]{indexIdGrid=20700} * 100)
        String result = formula.split(SPLIT_CHAR)[1];
        result = result.replace(indexIdGridPlaceHolder,indexIdGrid);
        result = result.replace(totalGridPlaceHolder,totalGrid);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThisMonthValueFormula().run(new Object[]{"total:IF(totalGrid[!0]{indexIdGrid=20700}, 0, totalGrid[!0]{indexIdGrid=20100} / " +
                "totalGrid[!0]{indexIdGrid=20700} * 100)","F2","G2"}));
        //IF(B2=41800 || B2 = 41900, monthValueFormula($$$,"B2",""),eval($$$))
        // IF(Z2[!0]{B2=20700}, 0, Z2[!0]{B2=20100} / Z2[!0]{B2=20700} * 100)
    }
}
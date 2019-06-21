package com.jdrx.springboot.roleTest;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.RoleApiHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by dengxuelong on 2017/11/9.
 */
public class QueryRoleListByUserIds {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(GetRoleTest.class);
        RoleApiHelper roleHelper = RetrofitUtils.getHelperInstance(RoleApiHelper.class
                , UrlEnums.baseUrl.getValue());

        HashMap map = new HashMap();
        long time = System.currentTimeMillis();
        ArrayList<Long> timeList = new ArrayList();

        try {
            for (int i = 0; i < 2000; i++) {
                //随机生成ids的个数以及随机的id值
                int num = new Random().nextInt(10)+1;
                ArrayList<Integer> ids = new ArrayList<>();
                for (int i1 = 0; i1 < num; i1++) {
                    int id = new Random().nextInt(1000000);
                    ids.add(id);
                }
                map.put("ids",arrayToString(ids));

                long startTime = System.currentTimeMillis();

                Call<ResposeVO> call = roleHelper.queryRoleListByUserIds(UrlEnums.TOKEN.getValue(),map);
                ResposeVO response = call.execute().body();

                long endTime = System.currentTimeMillis();
                long expend = endTime- startTime;
                timeList.add(expend);

                if ("0".equals(response.getStatus())){
                    if (expend < 2000){
                        logger.info("api/0/permission/role/queryRoleListByUserIds" + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response+"]");
                    }else{
                        logger.info("api/0/permission/role/queryRoleListByUserIds" + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response+"]");
                        logger.error("api/0/permission/role/queryRoleListByUserIds" + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response+"]");
                    }
                }else{
                    logger.error("api/0/permission/role/queryRoleListByUserIds" + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response+"]");
                }

            }
        }catch (SocketTimeoutException e){
            logger.error("api/0/permission/role/queryRoleListByUserIds" + "  [request:" + map + "]  [exception:" + e + "]");
        }catch (SocketException e){
            logger.error("api/0/permission/role/queryRoleListByUserIds" + "  [request:" + map + "]  [exception:" + e + "]");
        }catch (Exception e){
            logger.error("api/0/permission/role/queryRoleListByUserIds" + "  [request:" + map + "]  [exception:" + e + "]");
        }

        long sum = 0;
        long avg = 0;
        for (Long t : timeList) {
            sum += t;
        }
        avg = sum / timeList.size();

        logger.info("-------------------------------------------------------------------");
        logger.info("查询了" + timeList.size() + "次  " + "平均时间为：" + avg + "毫秒");
        logger.info("-------------------------------------------------------------------");
    }
    public static String arrayToString(ArrayList<Integer> arr){
        if (arr != null && arr.size()!=0) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : arr) {
                sb.append(i+",");
            }
            return sb.substring(0,sb.length()-1);
        }
        return "";
    }
}

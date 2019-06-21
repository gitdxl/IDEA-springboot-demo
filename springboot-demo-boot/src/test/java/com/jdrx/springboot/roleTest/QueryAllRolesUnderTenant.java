package com.jdrx.springboot.roleTest;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.RoleApiHelper;
import com.sun.javafx.fxml.expression.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by dengxuelong on 2017/11/9.
 */
public class QueryAllRolesUnderTenant {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(GetRoleTest.class);
        RoleApiHelper roleHelper = RetrofitUtils.getHelperInstance(RoleApiHelper.class
                , UrlEnums.baseUrl.getValue());

        ArrayList<Long> timeList = new ArrayList();
        String token = "";
        try {
            for (int i = 0; i < 2000; i++) {
                //随机生成token
                HashMap map = new HashMap();
                map.put("userName","admin");
                map.put("password","1");
                Call<ResposeVO> call1 = roleHelper.login(map);
                ResposeVO r = call1.execute().body();
                Map map1 = (Map)r.getData();
                token = (String) map1.get("token");

                long startTime = System.currentTimeMillis();

                Call<ResposeVO> call = roleHelper.queryAllRolesUnderTenant(token);
                ResposeVO response = call.execute().body();

                long endTime = System.currentTimeMillis();
                long expend = endTime- startTime;
                timeList.add(expend);

                if ("0".equals(response.getStatus())){
                    if (expend < 2000){
                        logger.info("api/0/permission/role/queryAllRolesUnderTenant" + " 执行时间:" + expend + "毫秒  [request:token + ]" + token + "  [response:" + response+"]");
                    }else{
                        logger.info("api/0/permission/role/queryAllRolesUnderTenant" + " 执行时间:" + expend + "毫秒  [request:token + ]" + token + "]  [response:" + response+"]");
                        logger.error("api/0/permission/role/queryAllRolesUnderTenant" + " 执行时间:" + expend + "毫秒  [request:token + ]" + token + "]  [response:" + response+"]");
                    }
                }else{
                    logger.error("api/0/permission/role/queryAllRolesUnderTenant" + " 执行时间:" + expend + "毫秒  [request:token + ]" + token + "]  [response:" + response+"]");
                }

            }
        }catch (SocketTimeoutException e){
            logger.error("api/0/permission/role/queryAllRolesUnderTenant" + "  [request:token + ]" + token + "]  [exception:" + e + "]");
        }catch (SocketException e){
            logger.error("api/0/permission/role/queryAllRolesUnderTenant" + "  [request:token + ]" + token + "]  [exception:" + e + "]");
        }catch (Exception e){
            logger.error("api/0/permission/role/queryAllRolesUnderTenant" + "  [request:token + ]" + token + "]  [exception:" + e + "]");
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
}

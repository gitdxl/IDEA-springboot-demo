package com.jdrx.springboot.roleTest;


import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.commons.utils.MapUtils;
import com.jdrx.springboot.demo.beans.commons.utils.ParamUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.RoleApiHelper;
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
public class QueryRoleByPage {
    private static String api = "api/0/permission/role/queryRoleByPage";
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(GetRoleTest.class);
        RoleApiHelper roleHelper = RetrofitUtils.getHelperInstance(RoleApiHelper.class
                , UrlEnums.baseUrl.getValue());

        HashMap map = new HashMap();
        ArrayList<Long> timeList = new ArrayList();
        String token = "";
        for (int i = 0; i < 3000; i++) {
            try {
                // 随机生成token
                HashMap m = new HashMap();
                m.put("userName","admin");
                m.put("password","1");
                Call<ResposeVO> call1 = roleHelper.login(m);
                ResposeVO r = call1.execute().body();
                Map map1 = (Map)r.getData();
                token = (String) map1.get("token");
                // 为此接口随机生成参数列表
                map = ParamUtils.createQueryRoleByPage();
                System.out.println(MapUtils.mapToString(map));

                long startTime = System.currentTimeMillis();

                Call<ResposeVO> call = roleHelper.queryRoleByPage(token, map);
                ResposeVO response = call.execute().body();

                long endTime = System.currentTimeMillis();
                long expend = endTime - startTime;
                timeList.add(expend);

                if ("0".equals(response.getStatus())) {
                    if (expend < 2000) {
                        logger.info(api + " 执行时间:" + expend + "毫秒  [request:" + map  + "  token + ]" + token + "]  |||||[response:" + response + "]");
                    } else {
                        logger.info(api + " 执行时间:" + expend + "毫秒  [request:" + map + "  token + ]" + token +"]  [response:" + response + "]");
                        logger.error(api + " 执行时间:" + expend + "毫秒  [request:" + map + "  token + ]" + token +"]  [response:" + response + "]");
                    }
                } else {
                    logger.error(api + " 执行时间:" + expend + "毫秒  [request:" + map + "  token + ]" + token + "]  [response:" + response + "]");
                }
            } catch (SocketTimeoutException e) {
                    logger.error(api + "  [request:" + map + "  token + ]" + token + "]  [exception:" + e + "]");
            } catch (SocketException e) {
                    logger.error(api + "  [request:" + map + "  token + ]" + token + "]  [exception:" + e + "]");
            } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(api + "  [request:"  + map + "  token + ]" + token + "]  [exception:" + e.getMessage() + "]");
            }
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
//    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(GetRoleTest.class);
//        RoleApiHelper roleHelper = RetrofitUtils.getHelperInstance(RoleApiHelper.class
//                , UrlEnums.baseUrl.getValue());
//
//        HashMap map = new HashMap();//TODO
//        long time = System.currentTimeMillis();
//        ArrayList<Long> timeList = new ArrayList();
//
//        try {
//            for (int i = 0; i < 7000; i++) {
//                int tenant = new Random().nextInt(100000);//随机生成租户id
//                map = ParamUtils.createQueryRoleByPage();//为此接口随机生成参数列表
//
//                long startTime = System.currentTimeMillis();
//
//                Call<ResposeVO> call = roleHelper.queryRoleByPage(UrlEnums.TOKEN.getValue(), map);
//                ResposeVO response = call.execute().body();
//
//                long endTime = System.currentTimeMillis();
//                long expend = endTime - startTime;
//                timeList.add(expend);
//
//                if ("0".equals(response.getStatus())) {
//                    if (expend < 2000) {
//                        logger.info("api/0/permission/role/queryRoleByPage" + " 执行时间:" + expend + "毫秒  [request:" + map  + "  tenate=" + tenant + "]  |||||[response:" + response + "]");
//                    } else {
//                        logger.info("api/0/permission/role/queryRoleByPage" + " 执行时间:" + expend + "毫秒  [request:" + map + "  tenate=" + tenant +"]  [response:" + response + "]");
//                        logger.error("api/0/permission/role/queryRoleByPage" + " 执行时间:" + expend + "毫秒  [request:" + map + "  tenate=" + tenant +"]  [response:" + response + "]");
//                    }
//                } else {
//                    logger.error("api/0/permission/role/queryRoleByPage" + " 执行时间:" + expend + "毫秒  [request:" + map + "  tenate=" + tenant + "]  [response:" + response + "]");
//                }
//
//            }
//        } catch (SocketTimeoutException e) {
//            logger.error("api/0/permission/role/queryRoleByPage" + "  [request:" + map + "]  [exception:" + e + "]");
//        } catch (SocketException e) {
//            logger.error("api/0/permission/role/queryRoleByPage" + "  [request:" + map + "]  [exception:" + e + "]");
//        } catch (Exception e) {
//            logger.error("api/0/permission/role/queryRoleByPage" + "  [request:" + map + "]  [exception:" + e + "]");
//        }
//
//        long sum = 0;
//        long avg = 0;
//        for (Long t : timeList) {
//            sum += t;
//        }
//        avg = sum / timeList.size();
//
//        logger.info("-------------------------------------------------------------------");
//        logger.info("查询了" + timeList.size() + "次  " + "平均时间为：" + avg + "毫秒");
//        logger.info("-------------------------------------------------------------------");
//    }
}


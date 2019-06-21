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
 * Created by dengxuelong on 2017/11/8.
 */
public class GetRoleTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(GetRoleTest.class);
        RoleApiHelper roleHelper = RetrofitUtils.getHelperInstance(RoleApiHelper.class
                , UrlEnums.baseUrl.getValue());
        HashMap map = new HashMap();
        ArrayList<Long> timeList = new ArrayList();

        logger.info("-------------------------------------------------------------------");
        logger.info("api/0/permission/role/getRole 根据id查询角色信息");
        logger.info("-------------------------------------------------------------------");

        try {
            for (int i = 0; i < 4000; i++) {
                long startTime = System.currentTimeMillis();
                int roleId = new Random().nextInt(100000);
                map = new HashMap();
                map.put("ids",roleId);

                Call<ResposeVO> call = roleHelper.getRole(UrlEnums.TOKEN.getValue(),map);
                ResposeVO response = call.execute().body();

                long endTime = System.currentTimeMillis();
                long expend = endTime- startTime;
                timeList.add(expend);

                if ("0".equals(response.getStatus())){
                    if (expend < 2000){
                        logger.info("api/0/permission/role/getRole" + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response+"]");
                    }else{
                        logger.info("api/0/permission/role/getRole" + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response+"]");
                        logger.error("api/0/permission/role/getRole" + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response+"]");
                    }
                }else{
                    logger.error("api/0/permission/role/getRole" + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response+"]");
                }

            }
        }catch (SocketTimeoutException e){
            logger.error("api/0/permission/role/getRole" + "  [request:" + map + "]  [exception:" + e + "]");
        }catch (SocketException e){
            logger.error("api/0/permission/role/getRole" + "  [request:" + map + "]  [exception:" + e + "]");
        }catch (Exception e){
            logger.error("api/0/permission/role/getRole" + "  [request:" + map + "]  [exception:" + e + "]");
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

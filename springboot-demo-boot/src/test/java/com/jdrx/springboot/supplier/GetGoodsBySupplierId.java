package com.jdrx.springboot.supplier;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.commons.utils.CommonsUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.SupplierHelper;
import com.jdrx.springboot.roleTest.UrlEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by dengxuelong on 2017/11/13.
 */
public class GetGoodsBySupplierId {
    private static String api = "api/0/supplier/getGoodsBySupplierId";

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(GetGoodsBySupplierId.class);
        SupplierHelper helper = RetrofitUtils.getHelperInstance(SupplierHelper.class
                , UrlEnums.SUPPLIER_BASE_URL.getValue());

        HashMap map = new HashMap();
        ArrayList<Long> timeList = new ArrayList();
        String token = UrlEnums.TOKEN.getValue();
        for (int i = 0; i < 1000; i++) {
            try {
                //
                map.put("suppiler", new Random().nextInt(100000)+256);
                map.put("pageNum",10);

                long startTime = System.currentTimeMillis();

                Call<ResposeVO> call = helper.getGoodsBySupplierId(token, map);
                Response<ResposeVO> execute = call.execute();
                ResposeVO response = execute.body();

                long endTime = System.currentTimeMillis();
                long expend = endTime - startTime;

                if ("0".equals(response.getStatus())) {
                    timeList.add(expend);
                    if (expend < 2000) {
                        logger.info(api + " 执行时间:" + expend + "毫秒  [request:" + map   + "]  |||||[response:" + response + "]");
                    } else {
                        logger.info(api + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response + "]");
                        logger.error(api + " 执行时间:" + expend + "毫秒  [request:" + map + "]  [response:" + response + "]");
                    }
                } else {
                    logger.error(api + " 执行时间:" + expend + "毫秒  [request:" + map +  "]  [response:" + response + "]");
                }
            } catch (SocketTimeoutException e) {
                logger.error(api + "  [request:" + map +  "]  [exception:" + e + "]");
            } catch (SocketException e) {
                logger.error(api + "  [request:" + map +  "]  [exception:" + e + "]");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(api + "  [request:"  + map +  "]  [exception:" + e.getMessage() + "]");
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
}

package com.jdrx.springboot.msg;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.commons.utils.CommonsUtils;
import com.jdrx.springboot.demo.beans.commons.utils.MapUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.MsgHelper;
import com.jdrx.springboot.demo.helper.PortalLinksApiHelper;
import com.jdrx.springboot.roleTest.UrlEnums;
import com.jdrx.springboot.supplier.CreateSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/20.
 */
public class Test {
    private static String api = "api/0/overallMsg/send";

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CreateSupplier.class);
        MsgHelper helper = RetrofitUtils.getHelperInstance(MsgHelper.class
                , "http://192.168.40.55:10108/msg/");

        HashMap map = new HashMap();
        ArrayList<Long> timeList = new ArrayList();
        String token = UrlEnums.TOKEN.getValue();
        for (int i = 0; i < 10; i++) {
            try {
                map.put("message","tm");
                map.put("platformPrefix","INNERMSG");
                map.put("recIds","202058,202061,202062,202063");
                map.put("title","title???");
                map.put("warningType","MAIL");
                map.put("receiver","zhangtest,无1");

                long startTime = System.currentTimeMillis();

                Call<ResposeVO> call = helper.send1("202057","1",UrlEnums.PORTAL_TOKEN.getValue(),map);
                Response<ResposeVO> execute = call.execute();
                ResposeVO response = execute.body();

                long endTime = System.currentTimeMillis();
                long expend = endTime - startTime;
                timeList.add(expend);

                if ("0".equals(response.getStatus())) {
                    if (expend < 10) {
                        logger.info(api + " 执行时间:" + expend + "毫秒  [request:" + MapUtils.mapToString(map)   + "]  |||||[response:" + response + "]");
                    } else {
                        logger.info(api + " 执行时间:" + expend + "毫秒  [request:" + MapUtils.mapToString(map) + "]  [response:" + response + "]");
                        logger.error(api + " 执行时间:" + expend + "毫秒  [request:" + MapUtils.mapToString(map) + "]  [response:" + response + "]");
                    }
                } else {
                    logger.error(api + " 执行时间:" + expend + "毫秒  [request:" + MapUtils.mapToString(map) +  "]  [response:" + response + "]");
                }
            } catch (SocketTimeoutException e) {
                logger.error(api + "  [request:" + MapUtils.mapToString(map) +  "]  [exception:" + e + "]");
            } catch (SocketException e) {
                logger.error(api + "  [request:" + MapUtils.mapToString(map) +  "]  [exception:" + e + "]");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(api + "  [request:"  + MapUtils.mapToString(map) +  "]  [exception:" + e.getMessage() + "]");
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

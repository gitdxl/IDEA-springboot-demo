package com.jdrx.springboot.portalNews;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.commons.utils.CommonsUtils;
import com.jdrx.springboot.demo.beans.commons.utils.MapUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.PortalLinksApiHelper;
import com.jdrx.springboot.demo.helper.PortalNewsApiHelper;
import com.jdrx.springboot.roleTest.UrlEnums;
import com.jdrx.springboot.supplier.CreateSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/15.
 */
public class Create {
    private static String api = "api/0/portal/portalNewsApi/create";

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CreateSupplier.class);
        PortalNewsApiHelper helper = RetrofitUtils.getHelperInstance(PortalNewsApiHelper.class
                , UrlEnums.PORTAL_BASE_URL.getValue());

        HashMap map = new HashMap();
        ArrayList<Long> timeList = new ArrayList();
        for (int i = 0; i < 1; i++) {
            try {

//                map.put("files","[{\"fileName\":\"290957.jpg\",\"filePath\":\"jpg/1711/15/697981846352433152.jpg\",\"fileSize\":189251}]");
//                map.put("portalTitle","dengxuelong" + new Date().getTime());
//                map.put("indexImgPath","png/1709/26/679879475877515264.png");
//                map.put("portalContent","<p >顶替土地枯你34aaaaaa</p>");
//                map.put("portalType",0);
//                map.put("noticeStatus",0);
                map.put("files"," ");
                map.put("portalTitle"," ");
                map.put("indexImgPath"," ");
                map.put("portalContent","1");
                map.put("portalType",0);
                map.put("noticeStatus"," ");

                long startTime = System.currentTimeMillis();

                Call<ResposeVO> call = helper.create("eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IiIsIm5hbWUiOiJ5ZjAwMSIsInVzZXJGdWxsTmFtZSI6InlmMDAxIiwidGVuYW50SWQiOiIyMDA1MzYiLCJ0ZW5hbnRTeW1ib2wiOiJ4eHgiLCJpZCI6IjIwMjA2MCIsImV4cCI6MTUxMzAzNzkwMiwiZW1haWwiOiIifQ.UrS6oTXpLgqQ_3Vl-GhquAWDTJSMRT7EqhQCGNrjtvk",map);
                Response<ResposeVO> execute = call.execute();
                ResposeVO response = execute.body();

                long endTime = System.currentTimeMillis();
                long expend = endTime - startTime;


                if ("0".equals(response.getStatus())) {
                    timeList.add(expend);
                    if (expend < 2000) {
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

package com.jdrx.springboot.portalLinks;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.commons.utils.CommonsUtils;
import com.jdrx.springboot.demo.beans.commons.utils.MapUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.PortalLinksApiHelper;
import com.jdrx.springboot.demo.helper.PortalWebsiteConfigHelper;
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
    private static String api = "api/0/portal/portalLinksApi/create";

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CreateSupplier.class);
        PortalLinksApiHelper helper = RetrofitUtils.getHelperInstance(PortalLinksApiHelper.class
                , UrlEnums.PORTAL_BASE_URL.getValue());

        HashMap map = new HashMap();
        ArrayList<Long> timeList = new ArrayList();
        String token = UrlEnums.TOKEN.getValue();
        for (int i = 0; i < 1; i++) {
            try {

//                map.put("websiteAddress",new StringBuilder("www.").append(CommonsUtils.createRanomString(4)).append(".com").toString());
//
//                map.put("websiteName","dengxuelong" + new Date().getTime());
                map.put("websiteAddress",CommonsUtils.createRanomString(256));

                map.put("websiteName",CommonsUtils.createRanomString(256));

                long startTime = System.currentTimeMillis();

                Call<ResposeVO> call = helper.create("eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE2MDA1MiIsIm5hbWUiOiJqZHJ4IiwidXNlckZ1bGxOYW1lIjoi5bCP5piOZmFpdGhfYmlhbjE0MCIsInRlbmFudElkIjoiMTQxIiwidGVuYW50U3ltYm9sIjoiamRyeF9kYiIsImlkIjoiMTc5IiwiZXhwIjoxNTEzMDI0OTA1LCJlbWFpbCI6IjE4NkBxcS5jb20ifQ.ws2ACuMnzR8_Wwwk7ADrzI3-XflWcJ3bcFneJux762o",map);
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

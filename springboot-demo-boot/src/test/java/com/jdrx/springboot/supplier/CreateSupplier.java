package com.jdrx.springboot.supplier;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.commons.utils.CommonsUtils;
import com.jdrx.springboot.demo.beans.commons.utils.MapUtils;
import com.jdrx.springboot.demo.beans.commons.utils.ParamUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.RoleApiHelper;
import com.jdrx.springboot.demo.helper.SupplierHelper;
import com.jdrx.springboot.roleTest.GetRoleTest;
import com.jdrx.springboot.roleTest.UrlEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.*;

/**
 * Created by dengxuelong on 2017/11/13.
 */
public class CreateSupplier {
    private static String api = "api/0/supplier/addSupplier";

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CreateSupplier.class);
        SupplierHelper helper = RetrofitUtils.getHelperInstance(SupplierHelper.class
                , UrlEnums.SUPPLIER_BASE_URL.getValue());

        HashMap map = new HashMap();
        ArrayList<Long> timeList = new ArrayList();
        String token = UrlEnums.TOKEN.getValue();
        for (int i = 0; i < 1; i++) {
            try {
//                map.put("zip", CommonsUtils.randomDigit(6));
//                map.put("address",new StringBuilder("四川省成都市高新区天府新谷9号楼6层").append(new Date().getTime()));
//                map.put("cooperationType",new String[]{"临时供应商","合作供应商"}[new Random().nextInt(2)]);
//                map.put("contact","dengxuelong"+CommonsUtils.createRanomString(6));
//                map.put("company",CommonsUtils.createRanomString(6));
//                map.put("tel",CommonsUtils.randomDigit(11));
//                map.put("supplierType",new String[]{"民营企业","国有企业"}[new Random().nextInt(2)]);

                map.put("zip", "");
                map.put("address"," ");
                map.put("cooperationType","");
                map.put("contact"," ");
                map.put("company"," ");
                map.put("tel"," ");
                map.put("supplierType",CommonsUtils.createRanomString(256));

                long startTime = System.currentTimeMillis();

                Call<ResposeVO> call = helper.addSupplier(token, map);
                Response<ResposeVO> execute = call.execute();
                ResposeVO response = execute.body();

                long endTime = System.currentTimeMillis();
                long expend = endTime - startTime;
                timeList.add(expend);

                if ("0".equals(response.getStatus())) {
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

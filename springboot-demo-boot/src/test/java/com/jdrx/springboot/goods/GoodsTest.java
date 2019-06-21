package com.jdrx.springboot.goods;

import com.jdrx.springboot.demo.helper.GoodsHelper;
import com.jdrx.springboot.demo.helper.MsgHelper;
import com.jdrx.springboot.roleTest.UrlEnums;
import com.jdrx.springboot.utils.TestUtils;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/24.
 */
public class GoodsTest {
    @Test
    public void get(){
        HashMap queryMap = new HashMap();
        queryMap.put("name", "脉动");
        queryMap.put("supplier", 266);
        queryMap.put("startPrice", 10);
        queryMap.put("endPrice", 1000);
        queryMap.put("pageNum", 1);

        TestUtils.apiTest(UrlEnums.SUPPLIER_BASE_URL.getValue(),"api/0/goods/query/list"
                , GoodsHelper.class,"list",UrlEnums.TOKEN.getValue(),queryMap,1000);
    }

    @Test
    public void queryGoodsAdmin(){
        HashMap queryMap = new HashMap();
        queryMap.put("goodsName", "脉动");
        queryMap.put("supplier", 269);
        queryMap.put("pageNum", 1);

        TestUtils.apiTest(UrlEnums.SUPPLIER_BASE_URL.getValue(),"api/0/goods/queryGoodsAdmin"
                , GoodsHelper.class,"queryGoodsAdmin",UrlEnums.TOKEN.getValue(),queryMap,1000);
    }

}

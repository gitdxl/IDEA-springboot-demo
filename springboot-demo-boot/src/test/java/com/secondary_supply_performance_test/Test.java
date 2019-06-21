package com.secondary_supply_performance_test;

import com.jdrx.springboot.demo.helper.PortalLinksApiHelper;
import com.jdrx.springboot.roleTest.UrlEnums;
import com.jdrx.springboot.utils.TestUtils;

import java.util.HashMap;
import java.util.Random;

/**
 * @author : dengxuelong
 * @date : 2018/10/17 10:23
 */
public class Test {
    String baseUrl= "http://192.168.10.165:12334/report/";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IiIsIm5hbWUiOiJqZHJ4QWRtaW4iLCJ1c2VyRnVsbE5hbWUiOiJqZHJ4QWRtaW4iLCJ0ZW5hbnRJZCI6IjE1NyIsInRlbmFudFN5bWJvbCI6ImpkcnhfdGVzdCIsImlkIjoiMTE1IiwiZXhwIjoxNTM5ODI5NTA4LCJlbWFpbCI6IjcxOTIwNzc2NUBxcS5jb20ifQ.kS7WEYepaR8k1_y-OlBFm59c3CmEI5kDldCeijrOtfM";
    @org.junit.Test
    public void queryByPage(){
        HashMap map = new HashMap();
        map.put("modId","28");
//        map.put("pageNum",1);
//        map.put("serverName","www.yf100204.yf.com");
        TestUtils.apiTest(baseUrl,"api/0/writeReport/queryWriteDesignFile"
                , SecondarySupplyApiHelper.class,"queryWriteDesignFile",token,map,100);

    }

    @org.junit.Test
    public void queryAuditSuccessList(){
        HashMap map = new HashMap();
        map.put("modId","28");
//        map.put("pageNum",1);
//        map.put("serverName","www.yf100204.yf.com");
        TestUtils.apiTest(baseUrl,"api/0/writeReport/queryEfficientList"
                , SecondarySupplyApiHelper.class,"queryEfficientList",token,map,100);

    }

    @org.junit.Test
    public void queryDraftList(){
        HashMap map = new HashMap();
        map.put("modId","28");
//        map.put("pageNum",1);
//        map.put("serverName","www.yf100204.yf.com");
        TestUtils.apiTest(baseUrl,"api/0/writeReport/queryDraftList"
                , SecondarySupplyApiHelper.class,"queryDraftList",token,map,100);

    }

    @org.junit.Test
    public void loadData(){
        HashMap map = new HashMap();
        map.put("fileName","测试");
        map.put("id",28);
//        map.put("serverName","www.yf100204.yf.com");
        TestUtils.apiTest(baseUrl,"api/0/ReportView/loadData"
                , SecondarySupplyApiHelper.class,"loadData",token,map,100);

    }

}
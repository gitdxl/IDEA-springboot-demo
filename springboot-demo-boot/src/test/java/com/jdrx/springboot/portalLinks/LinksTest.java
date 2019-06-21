package com.jdrx.springboot.portalLinks;

import com.jdrx.springboot.demo.helper.PortalLinksApiHelper;
import com.jdrx.springboot.roleTest.UrlEnums;
import com.jdrx.springboot.utils.TestUtils;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by dengxuelong on 2017/11/16.
 */
public class LinksTest {
    @Test
    public void queryByPage(){
        HashMap map = new HashMap();
        map.put("serverName",new StringBuilder("www.yf").append(new Random().nextInt(10000)).append(".yf.com"));
        map.put("pageNum",1);
        map.put("serverName","www.yf100204.yf.com");
        TestUtils.apiTest(UrlEnums.PORTAL_BASE_URL.getValue(),"website/0/homePortalLinksApi/queryByPage"
                , PortalLinksApiHelper.class,"queryByPage",UrlEnums.PORTAL_TOKEN.getValue(),map,20);

    }

    @Test
    public void getById(){
        HashMap map = new HashMap();
        map.put("id",new Random().nextInt(100000));
        TestUtils.apiTest(UrlEnums.PORTAL_BASE_URL.getValue(),"website/0/homePortalLinksApi/getById"
                , PortalLinksApiHelper.class,"getById",UrlEnums.PORTAL_TOKEN.getValue(),map,200);

    }

    @Test
    public void query(){
        HashMap map = new HashMap();
        map.put("serverName","www.yf100204.yf.com");
        TestUtils.apiTest(UrlEnums.PORTAL_BASE_URL.getValue(),"website/0/homePortalLinksApi/query"
                , PortalLinksApiHelper.class,"query",UrlEnums.PORTAL_TOKEN.getValue(),map,2);

    }

    @Test
    public void t2(){
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
    }

    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
    }
}

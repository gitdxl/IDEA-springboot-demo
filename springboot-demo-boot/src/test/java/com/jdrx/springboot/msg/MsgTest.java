package com.jdrx.springboot.msg;

import com.jdrx.springboot.demo.beans.commons.utils.CommonsUtils;
import com.jdrx.springboot.demo.helper.MsgHelper;
import com.jdrx.springboot.roleTest.UrlEnums;
import com.jdrx.springboot.utils.TestUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by dengxuelong on 2017/11/20.
 */
public class MsgTest {
    @Test
    public void send(){
        HashMap map = new HashMap();
        map.put("message","message" + CommonsUtils.createRanomString(6));
        map.put("platformPrefix","INNERMSG");
        map.put("recIds","202058,202061");
        map.put("title","1title" + CommonsUtils.createRanomString(6));
        map.put("warningType","MAIL");
        map.put("receiver","zhangtest,无1");

        TestUtils.apiTest(UrlEnums.MSG_BASE_URL.getValue(),"api/0/overallMsg/send"
                , MsgHelper.class,"send",UrlEnums.MSG_TOKEN.getValue(),map,1000);
    }

    @Test
    public void get(){
        HashMap map = new HashMap();
        map.put("id","450129424151482368");

        TestUtils.apiTest(UrlEnums.MSG_BASE_URL.getValue(),"api/0/message/get"
                , MsgHelper.class,"get",UrlEnums.MSG_TOKEN.getValue(),map,1);
    }

    @Test
    public void query(){
        TestUtils.apiTestWithRandomParam(UrlEnums.MSG_BASE_URL.getValue(),"api/0/message/query"
                , MsgHelper.class,"query",UrlEnums.MSG_TOKEN.getValue(),1000);
    }

    @Test
    public void queryAllPage(){
        TestUtils.apiTestWithRandomParam(UrlEnums.MSG_BASE_URL.getValue(),"api/0/message/queryAllPage"
                , MsgHelper.class,"queryAllPage",UrlEnums.MSG_TOKEN.getValue(),300);
    }

    @Test
    public void queryPage(){
        TestUtils.apiTestWithRandomParam(UrlEnums.MSG_BASE_URL.getValue(),"api/0/message/queryPage"
                , MsgHelper.class,"queryPage",UrlEnums.MSG_TOKEN.getValue(),1000);
    }

    @Test
    public void queryReceivedMessagePage(){
        TestUtils.apiTestWithRandomParam(UrlEnums.MSG_BASE_URL.getValue(),"api/0/overallMsg/queryReceivedMessagePage"
                , MsgHelper.class,"queryReceivedMessagePage",UrlEnums.MSG_TOKEN.getValue(),1000);
    }

    @Test
    public void topInfo(){
        TestUtils.apiTestWithRandomParam(UrlEnums.MSG_BASE_URL.getValue(),"api/0/overallMsg/topInfo"
                , MsgHelper.class,"topInfo",UrlEnums.MSG_TOKEN.getValue(),1000);
    }

    @Test
    public void sentRecordPage(){
        TestUtils.apiTestWithRandomParam(UrlEnums.MSG_BASE_URL.getValue(),"api/0/overallMsg/sentRecordPage"
                , MsgHelper.class,"sentRecordPage",UrlEnums.MSG_TOKEN.getValue(),300);
    }


    @Test
    public void t () throws IOException {
        ArrayList list = new ArrayList();
        list.add("123");
        list.add("zzz");
        list.add("dfdf");
        for (Object o : list) {
            list.remove(0);
//            list.add("dfdfd");
        }
        System.out.println(list);
    }
}

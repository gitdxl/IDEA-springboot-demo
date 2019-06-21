package com.jdrx.springboot.roleTest;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.RoleApiHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/9.
 */
public class LoginTest {
    public static void main(String[] args) throws  Exception{
        Logger logger = LoggerFactory.getLogger(GetRoleTest.class);
        RoleApiHelper roleHelper = RetrofitUtils.getHelperInstance(RoleApiHelper.class
                , "http://192.168.40.250:8989/permission/");
        HashMap map = new HashMap();
        map.put("pageNum",1);
        map.put("pageSize",1);

        Call<ResposeVO> cal = roleHelper.queryRoleRoleDTO("eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE1MDE5NDI5MTcwIiwibmFtZSI6ImFkbWluIiwidXNlckZ1bGxOYW1lIjoic3RyaW5nIiwidGVuYW50SWQiOiIwIiwidGVuYW50U3ltYm9sIjoiU1lTVEVNIiwiaWQiOiIxIiwiZXhwIjoxNTExMzc1NjYxLCJlbWFpbCI6ImNoZW5hbmh1aUBldmVyY3JlYXRpdmUuY29tLmNuIn0.gp4OZtw8kNLCqQ9cLRCYG0FbsXIUsbcexQxsi7P36Ig",map);
        ResposeVO resp = cal.execute().body();
        System.out.println(resp);
    }
}






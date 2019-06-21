package com.jdrx.springboot.roleTest;

import com.jdrx.springboot.demo.beans.commons.utils.CommonsUtils;
import com.jdrx.springboot.demo.beans.entity.Role;
import com.jdrx.springboot.demo.helper.MsgHelper;
import com.jdrx.springboot.demo.helper.RoleApiHelper;
import com.jdrx.springboot.utils.TestUtils;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/23.
 */
public class RoleTest {
    @Test
    public void createRole(){
        HashMap map = new HashMap();
        map.put("nameCn","adminn"+ new Date().getTime());
        map.put("nameEn","");
        map.put("organizationId","111");
        map.put("createAt",new Date());
        map.put("remark","111");
        map.put("roleType","111");
        map.put("createBy"," ");
        map.put("createUserName"," ");
        map.put("resourceAllIds"," ");
        map.put("resourceIds",CommonsUtils.createRanomString(1));

//        map.put("NameCn","admin" + new Date().getTime());
//        map.put("NameEn","admin");
//        map.put("OrganizationId",1);
//        map.put("CreateAt",new Date());
//        map.put("Remark","");
//        map.put("RoleType","");
//        map.put("CreateBy","");
//        map.put("CreateUserName","");
//        map.put("ResourceAllIds","");
//        map.put("ResourceIds","");
        TestUtils.apiTest(UrlEnums.baseUrl.getValue(),"api/0/permission/role/createRole"
                , RoleApiHelper.class,"createRole",UrlEnums.TOKEN.getValue(),map,100);

        Role role = new Role();
        role.setNameCn("admin" + new Date().getTime());
        role.setNameEn("admin");
        role.setOrganizationId(1);
        role.setCreateAt(new Date());
        role.setRemark("user2222334411");
        role.setRoleStatus(0);
        role.setRoleType(0);
        role.setCreateBy(1);
        role.setCreateUserName("admin");
        role.setResourceAllIds("515,516,633,634");
        role.setResourceIds("516,633,634,515");
    }

    @Test
    public void create(){
        HashMap map = new HashMap();
        map.put("email","");
        map.put("officeId",CommonsUtils.createRanomString(501));
        map.put("orgOrOfficeId"," ");
        map.put("organizationId"," ");
        map.put("phone"," ");
        map.put("serviceProviderId"," ");
        map.put("userFullName","admindfdzzz");
        map.put("userName","admindfdzzz");
        map.put("userPwd","dfd");
        map.put("userType","1");

        TestUtils.apiTest(UrlEnums.baseUrl.getValue(),"api/0/permission/user/create"
                , RoleApiHelper.class,"create",UrlEnums.TOKEN.getValue(),map,1);

    }
}

package com.jdrx.springboot.roleTest;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.commons.utils.DateUtils;
import com.jdrx.springboot.demo.beans.entity.Role;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import com.jdrx.springboot.demo.helper.RoleApiHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dengxuelong on 2017/11/8.
 */
public class CreateRoleTest {
    static Logger logger = LoggerFactory.getLogger(CreateRoleTest.class);
    public static void main(String[] args) throws Exception{
//        RoleApiHelper roleHelper = RetrofitUtils.getHelperInstance(RoleApiHelper.class
//                , UrlEnums.baseUrl.getValue());
//        long startTime = System.currentTimeMillis();
//        ArrayList<Long> timeList = new ArrayList();
//
//        Role role = new Role();
//        role.setNameCn("admin" + new Date().getTime());
//        role.setNameEn("admin");
//        role.setOrganizationId(1);
//        role.setCreateAt(new Date());
//        role.setRemark("user2222334411");
//        role.setRoleStatus(0);
//        role.setRoleType(0);
//        role.setCreateBy(1);
//        role.setCreateUserName("admin");
//        role.setResourceAllIds("515,516,633,634");
//        role.setResourceIds("516,633,634,515");
//        role.setDeleteFlag(0);
//        for (int i = 0; i < 20000; i++) {
//            role.setNameCn("admin" + new Date().getTime());
//            try {
//                long stime = System.currentTimeMillis();
//
//                Call<ResposeVO> call = roleHelper.createUser(UrlEnums.TOKEN.getValue(), role);
//                ResposeVO resposeVO = call.execute().body();
//
//                long etime = System.currentTimeMillis();
//                long expend = etime - stime;
//                timeList.add(expend);
//
//                if ("0".equals(resposeVO.getStatus())) {
//                    logger.info("api/0/permission/role/createRole" + " 执行时间:" + expend + "  [request:"+role+"]  [response:"+resposeVO+"]");
//                }else{
//                    logger.error("api/0/permission/role/createRole"+" 执行时间:" + expend + "  [request:"+role+"]  [response:"+resposeVO+"]");
//                }
//            }catch (SocketTimeoutException e){
//                logger.error("api/0/permission/role/createRole"+"  [request:"+role+"]  [exception:"+e+"]");
//            }catch (SocketException e){
//                logger.error("api/0/permission/role/createRole"+"  [request:"+role+"]  [exception:"+e+"]");
//            }catch (Exception e){
//                logger.error("api/0/permission/role/createRole"+"  [request:"+role+"]  [exception:"+e+"]");
//            }
//        }
//
//        long sum = 0;
//        long avg = 0;
//        for (Long t : timeList) {
//            sum += t;
//        }
//        avg = sum / timeList.size();
//
//        logger.info("查询了" + timeList.size() + "次  " + "平均时间为：" + avg + "毫秒");
//        logger.info("执行时间为:" + DateUtils.TimeDifference(System.currentTimeMillis(),startTime));
//        logger.info("----------------------------------------------------------------------------");
//        logger.info("----------------------------------------------------------------------------");
    }
}

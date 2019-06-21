package com.jdrx.springboot.demo.helper;

import com.jdrx.springboot.demo.beans.entity.Role;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/8.
 */
public interface RoleApiHelper {
    @POST("api/0/permission/role/createRole")
    Call<ResposeVO> createRole(@Header("authorization") String  auth ,@Body HashMap map);

    /**
     * 根据roleID查询
     * @param map
     * @return
     */
    @POST("api/0/permission/role/getRole")
    Call<ResposeVO> getRole(@Header("authorization") String  auth ,@Body HashMap map);

    @POST("system/0/admin/backstage/login")
    Call<ResposeVO> login(@Body HashMap map);

    @POST("api/0/permission/role/queryAllRolesUnderTenant")
    Call<ResposeVO> queryAllRolesUnderTenant(@Header("authorization") String  auth );

    @POST("api/0/permission/role/queryRoleListByUserIds")
    Call<ResposeVO> queryRoleListByUserIds(@Header("authorization") String  auth ,@Body HashMap map);

    /**
     * 根据RoleDTO查询role信息
     * 自带pageNum和pageSize参数
     */
    @POST("api/0/permission/role/queryRoleByPage")
    Call<ResposeVO> queryRoleByPage(@Header("authorization") String  auth ,@Body HashMap map);

    /**
     * 根据RoleDTO查询role信息
     *
     */
    @POST("api/0/permission/role/queryRoleRoleDTO")
    Call<ResposeVO> queryRoleRoleDTO(@Header("authorization") String  auth ,@Body HashMap map);

    /**
     * 根据RoleDTO查询role信息
     *  去除了id为2的role
     */
    @POST("api/0/permission/role/queryRoleRolesCanBeAssignedToSaasAdminPlatformUsers")
    Call<ResposeVO> queryRoleRolesCanBeAssignedToSaasAdminPlatformUsers(@Header("authorization") String  auth ,@Body HashMap map);

    @POST("api/0/permission/user/create")
    Call<ResposeVO> create(@Header("authorization") String  auth ,@Body HashMap map);

}

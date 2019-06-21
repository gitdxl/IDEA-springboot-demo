package com.jdrx.springboot.demo.helper;

import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/13.
 */
public interface SupplierHelper {
    @POST("api/0/supplier/addSupplier")
    Call<ResposeVO> addSupplier(@Header("authorization") String  auth , @Body HashMap map);

    /**
     * 根据供应商id获取供应商信息
     * @param auth
     * @param map
     * @return
     */
    @POST("api/0/supplier/getById")
    Call<ResposeVO> getById(@Header("authorization") String  auth , @Body HashMap map);

    /**
     * 根据供应商id获取商品信息
     * @param auth
     * @param map
     * @return
     */
    @POST("api/0/supplier/getGoodsBySupplierId")
    Call<ResposeVO> getGoodsBySupplierId(@Header("authorization") String  auth , @Body HashMap map);

    /**
     * select DISTINCT profession,company from supplier where del_flag=0 and tenant_id = #{parameter};
     * @param auth
     * @return
     */
    @POST("api/0/supplier/getSupplierList")
    Call<ResposeVO> getSupplierList(@Header("authorization") String  auth , @Body HashMap map);


    /**
     *        map.put("company", supplierQueryDTO.getCompany());
        map.put("contact", supplierQueryDTO.getContact());
        map.put("supplierType", supplierQueryDTO.getSupplierType());
        map.put("tenantId", Integer.valueOf(tid));
        PageHelper.startPage(supplierQueryDTO.getPageNum(), IPageConstants.PAGE_SIZE);
     * @param auth
     * @return
     */
    @POST("api/0/supplier/querySupplierList")
    Call<ResposeVO> querySupplierList(@Header("authorization") String  auth,@Body HashMap map);

    /**
     *  查询供货商后台管理数据
     *    select  *
     from supplier
     where 1=1
     <if test="createAt !=null and createAt!=''">
     and create_at like CONCAT('%', #{createAt}, '%')
     </if>
     <if test="createName !=null and createName!=''">
     and create_name like CONCAT('%', #{createName}, '%')
     </if>
     and tenant_id=#{tenantId}
     and del_flag =0
     order by create_at desc
     * @param auth
     * @param map
     * @return
     */
    @POST("api/0/supplier/supplierQuery/admin")
    Call<ResposeVO> admin(@Header("authorization") String  auth , @Body HashMap map);

}

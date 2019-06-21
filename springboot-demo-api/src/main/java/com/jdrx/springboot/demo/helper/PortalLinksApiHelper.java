package com.jdrx.springboot.demo.helper;

import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/15.
 */
public interface PortalLinksApiHelper {
    @POST("api/0/portal/portalLinksApi/create")
    Call<ResposeVO> create(@Header("authorization") String  auth , @Body HashMap map);

    @POST("website/0/homePortalLinksApi/getById")
    Call<ResposeVO> getById(@Header("authorization") String  auth , @Body HashMap map);

    @POST("website/0/homePortalLinksApi/query")
    Call<ResposeVO> query(@Header("authorization") String  auth , @Body HashMap map);

    @POST("website/0/homePortalLinksApi/queryByPage")
    Call<ResposeVO> queryByPage(@Header("authorization") String  auth , @Body HashMap map);


}

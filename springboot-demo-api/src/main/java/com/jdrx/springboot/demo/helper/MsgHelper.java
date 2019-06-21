package com.jdrx.springboot.demo.helper;

import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/20.
 */
public interface MsgHelper {
    @POST("api/0/overallMsg/send")
    Call<ResposeVO> send(@Header("authorization") String  auth , @Body HashMap map);

    /**
     * 根据id查询message
     * @param auth
     * @param map
     * @return
     */
    @POST("api/0/message/get")
    Call<ResposeVO> get(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/message/query")
    Call<ResposeVO> query(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/message/query")
    Call<ResposeVO> queryAll(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/message/queryAllPage")
    Call<ResposeVO> queryAllPage(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/message/queryPage")
    Call<ResposeVO> queryPage(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/overallMsg/queryReceivedMessagePage")
    Call<ResposeVO> queryReceivedMessagePage(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/overallMsg/topInfo")
    Call<ResposeVO> topInfo(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/overallMsg/sentRecordPage")
    Call<ResposeVO> sentRecordPage(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/overallMsg/send")
    Call<ResposeVO> send1(@Header("X-UID") String  uid,@Header("X-TID") String  tid
            ,@Header("X-TOKE") String  token , @Body HashMap map);

}

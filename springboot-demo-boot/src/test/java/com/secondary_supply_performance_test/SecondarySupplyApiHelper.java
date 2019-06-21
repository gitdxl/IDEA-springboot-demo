package com.secondary_supply_performance_test;

import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.util.HashMap;

public interface SecondarySupplyApiHelper {
    @POST("api/0/writeReport/queryWriteDesignFile")
    Call<ResposeVO> queryWriteDesignFile(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/writeReport/queryEfficientList")
    Call<ResposeVO> queryEfficientList(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/writeReport/queryDraftList")
    Call<ResposeVO> queryDraftList(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/ReportView/loadData")
    Call<ResposeVO> loadData(@Header("authorization") String  auth , @Body HashMap map);
}

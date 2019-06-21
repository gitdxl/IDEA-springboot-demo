package com.jdrx.springboot.demo.helper;

import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.util.HashMap;

/**
 * Created by dengxuelong on 2017/11/24.
 */
public interface GoodsHelper {
    @POST("api/0/goods/query/list")
    Call<ResposeVO> list(@Header("authorization") String  auth , @Body HashMap map);

    @POST("api/0/goods/queryGoodsAdmin")
    Call<ResposeVO> queryGoodsAdmin(@Header("authorization") String  auth , @Body HashMap map);
}

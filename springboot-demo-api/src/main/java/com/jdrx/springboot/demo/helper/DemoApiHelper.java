package com.jdrx.springboot.demo.helper;

import com.jdrx.springboot.demo.beans.entity.UserPO;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by dengxuelong on 2017/10/31.
 */
public interface DemoApiHelper {
    //接口方法的设计规则:返回值为Call<T>
    @POST("api/0/demo/getUserInfo")
    Call<UserPO> getUserInfo(@Query("id") Integer id);
}

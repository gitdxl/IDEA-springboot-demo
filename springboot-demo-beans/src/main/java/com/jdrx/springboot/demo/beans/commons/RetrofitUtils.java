package com.jdrx.springboot.demo.beans.commons;

import okhttp3.OkHttpClient;
import org.apache.ibatis.executor.ReuseExecutor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by dengxuelong on 2017/11/8.
 */
public class RetrofitUtils {
    /**
     * 为接口构建Retrofit实例
     *
     * @param c       接口
     * @param baseUrl
     * @return
     */
    public static <T> T getHelperInstance(Class<T> c, String baseUrl) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        T t = retrofit.create(c);
        return t;
    }
}

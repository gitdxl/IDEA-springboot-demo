package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : dengxuelong
 * @date : 2018/10/24 13:31
 * 把计算结果缓存起来
 */
public class CacheCalculateResult2 {
    //<要计算的数据,计算结果>
    private Map<String,Integer> cache = new ConcurrentHashMap<>();
    /** 计算*/
    public Integer compute(String arg){
        Integer result = cache.get(arg);
        if (result == null) {
            result = this.realCompute(arg);
            cache.put(arg,result);
            return result;
        }else {
            return result;
        }
    }

    /** 实际的计算*/
    public Integer realCompute(String arg){
        //省略复杂耗时的计算操作
        return arg.hashCode();
    }
}
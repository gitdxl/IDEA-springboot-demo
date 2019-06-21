package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.HashMap;

/**
 * @author : dengxuelong
 * @date : 2018/10/24 13:31
 * 把计算结果缓存起来
 */
public class CacheCalculateResult1 {
    //<要计算的数据,计算结果>
    private HashMap<String,Integer> cache = new HashMap<>();
    /** 计算*/
    public synchronized Integer compute(String arg){
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

    public static void main(String[] args) {
        String a1 = new String("1");
        String a4 = String.valueOf("a");
        String a2 = new String(new String("a"));
        String a3 = "1";
    }
}
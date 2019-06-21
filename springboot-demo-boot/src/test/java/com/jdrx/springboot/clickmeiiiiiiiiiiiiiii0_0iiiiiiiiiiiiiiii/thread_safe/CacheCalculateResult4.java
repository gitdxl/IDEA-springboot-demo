package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : dengxuelong
 * @date : 2018/10/24 15:32
 */
public class CacheCalculateResult4 {
    //<要计算的数据,计算结果>
    private Map<String,Integer> cache = new ConcurrentHashMap<>();
    /** 计算*/
    public Integer compute(String arg){
        //错误用法  因为
        String lock = String.valueOf(arg);
        synchronized (lock){
            Integer result = cache.get(arg);
            if (result == null) {
                result = this.realCompute(arg);
                cache.put(arg,result);
                return result;
            }else {
                return result;
            }
        }
    }

    /** 实际的计算*/
    public Integer realCompute(String arg){
        //省略复杂耗时的计算操作
        System.out.println(arg + "--------------------执行计算-----------------------");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arg.hashCode();
    }
    public static void main(String[] args) throws Exception {
        CacheCalculateResult4 cacheCalculateResult4 = new CacheCalculateResult4();
        List<String> list = Arrays.asList("a", "a", "a", "a", "a", "a", "a");
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    System.out.println(list.get(finalI) + ":  " + new Date().toString() + cacheCalculateResult4.compute(list.get(finalI) ));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("a:  " + new Date().toString() + cacheCalculateResult4.compute("a"));
        System.out.println("d:  " + new Date().toString() + cacheCalculateResult4.compute("d"));
        System.out.println("a:  " + new Date().toString() + cacheCalculateResult4.compute("a"));
    }
}
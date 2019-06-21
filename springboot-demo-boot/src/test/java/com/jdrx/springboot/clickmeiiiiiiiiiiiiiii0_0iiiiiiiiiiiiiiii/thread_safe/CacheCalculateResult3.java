package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author : dengxuelong
 * @date : 2018/10/24 14:07
 */
public class CacheCalculateResult3 {
    //<要计算的数据,计算结果>
    private Map<String,FutureTask<Integer>> cache = new ConcurrentHashMap<>();
    /** 计算*/
    public Integer compute(String arg) throws Exception {
        FutureTask<Integer> future = cache.get(arg);
        if (future == null) {
            future = new FutureTask<>(() -> {
                return realCompute(arg);
            });
            cache.put(arg,future);
            //另外起一个线程真正进行运算
            future.run();
        }
        try {
            //获取运算结果
            return future.get();
        } catch (Exception e) {
            //当运算抛出异常时，删除对应的缓存
            e.printStackTrace();
            cache.remove(arg);
            throw new Exception("计算失败");
        }
    }

    /** 实际的计算*/
    public Integer realCompute(String arg){
        //省略复杂耗时的计算操作
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arg.hashCode();
    }

    public static void main(String[] args) throws Exception {
        CacheCalculateResult3 cacheCalculateResult3 = new CacheCalculateResult3();
        List<String> list = Arrays.asList("a", "b", "c", "d", "a", "a", "a");
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    System.out.println(list.get(finalI) + ":  " + new Date().toString() + cacheCalculateResult3.compute(list.get(finalI) ));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("a:  " + new Date().toString() + cacheCalculateResult3.compute("a"));
        System.out.println("d:  " + new Date().toString() + cacheCalculateResult3.compute("d"));
        System.out.println("a:  " + new Date().toString() + cacheCalculateResult3.compute("a"));
    }
}
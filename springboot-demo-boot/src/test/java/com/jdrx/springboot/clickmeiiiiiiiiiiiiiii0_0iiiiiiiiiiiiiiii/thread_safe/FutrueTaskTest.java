package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author : dengxuelong
 * @date : 2018/10/18 15:07
 */
public class FutrueTaskTest {
    static FutureTask<String> futureTask = new FutureTask<>(() -> {
        Thread.sleep(5000);
        throw new Exception("fu**ou!");
    });



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        futureTask.run();
        System.out.println(futureTask.get());
    }
}
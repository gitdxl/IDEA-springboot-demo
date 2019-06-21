package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.concurrent.*;

/**
 * 并行处理任务
 * @author : dengxuelong
 * @date : 2018/11/01 14:59
 */
public class ConcurrentExecuteTask {
    ExecutorService es = Executors.newFixedThreadPool(10);
    public String calculate() throws ExecutionException, InterruptedException {
        Future<String> futureA = es.submit(() -> computeA());
        Future<String> futureB = es.submit(() -> computeB());
        String a = futureA.get();
        String b = futureB.get();
        return a + b;
    }
    public String computeA() throws InterruptedException {
        Thread.sleep(100);
        return "aaa";
    }
    public String computeB() throws InterruptedException {
        Thread.sleep(1000);
        return "bbb";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(new ConcurrentExecuteTask().calculate());
    }
}
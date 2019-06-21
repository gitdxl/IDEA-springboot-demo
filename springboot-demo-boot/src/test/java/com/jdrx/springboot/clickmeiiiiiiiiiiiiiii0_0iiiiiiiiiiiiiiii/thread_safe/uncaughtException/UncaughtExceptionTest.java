package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe.uncaughtException;

import java.util.concurrent.*;

/**
 * @author : dengxuelong
 * @date : 2019/01/28 17:03
 */
public class UncaughtExceptionTest  {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            int i = 1/0;
        });
        //1、为线程设置UncaughtExceptionHandler，只有线程的所有者能改变的线程的UncaughtExceptionHandler
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        t.start();

        //2、未线程池设置UncaughtExceptionHandler。
        // 自行猜想，并非书上代码。
        ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100),
                //threadFactory，构建一个新的线程实例用来执行参数Runnable的代码
                r -> {
                    Thread tt = new Thread(r);
                    //设置UncaughtExceptionHandler
                    tt.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
                    return tt;
                });

        tp.execute(new Thread(() ->{
            System.out.println("thread pool work thread");
            int i = 1/0;
        }));

    }

}
package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author : dengxuelong
 * @date : 2018/11/20 17:33)
 */
public class CancelThread2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Object> zzz = es.submit(() -> {
            while (true) {
                System.out.println("zzz");
            }
        });
        Thread.sleep(1000);
        zzz.cancel(true);
    }

}
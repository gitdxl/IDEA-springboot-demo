package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.Task;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * @Author DengXueLong
 * @Date 2018/4/9 10:31
 */
public class TaskTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            task();
        }).start();
        System.out.println("task end");
    }

    private static void task() {
        Date now = new Date();
        CountDownLatch cdl = new CountDownLatch(1);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("runing...");
                cdl.countDown();
            }
        },2000);
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }
}

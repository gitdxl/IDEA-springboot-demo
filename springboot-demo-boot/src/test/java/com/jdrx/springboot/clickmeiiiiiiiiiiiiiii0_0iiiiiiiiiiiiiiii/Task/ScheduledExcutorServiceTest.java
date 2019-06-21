package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.Task;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author DengXueLong
 * @Date 2018/4/9 11:46
 */
public class ScheduledExcutorServiceTest {
    public static void main(String[] args) throws InterruptedException {
//        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("running1...");
            }
        },-1, TimeUnit.MILLISECONDS);
        ses.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("running2...");
            }
        },1, TimeUnit.MILLISECONDS);
        System.out.println("end...");
    }
}

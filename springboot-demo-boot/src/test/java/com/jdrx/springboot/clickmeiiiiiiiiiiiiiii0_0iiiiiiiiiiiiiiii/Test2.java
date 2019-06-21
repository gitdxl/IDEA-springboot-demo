package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : dengxuelong
 * @date : 2019/02/26 15:45
 */
public class Test2 {
    static boolean b;
    public static void main(String[] args) throws ParseException, BrokenBarrierException, InterruptedException {
//        run();
        System.out.println("持有锁10毫秒   公平锁    耗时：" + testFairPerformance(true, 10) + "毫秒");
        System.out.println("持有锁10毫秒   公平锁    耗时：" + testFairPerformance(true, 10) + "毫秒");
        System.out.println("持有锁10毫秒   非公平锁  耗时：" + testFairPerformance(false, 10) + "毫秒");
        System.out.println("持有锁100毫秒  公平锁    耗时：" + testFairPerformance(true, 100) + "毫秒");
        System.out.println("持有锁100毫秒  非公平锁  耗时：" + testFairPerformance(false, 100) + "毫秒");
    }

    public static void run() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(false);
        new Thread(() -> {
            try {
                lock.lock();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("释放锁");
                lock.unlock();

                for (int i = 0; i < 10; i++) {
                    new Thread(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName() + "============启动");
                            lock.lock();
                            System.out.println(Thread.currentThread().getName() + "============获取锁");
                        } finally {
                            lock.unlock();
                        }
                    }).start();
                }

            }
        }).start();

        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "启动");
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "获取锁");
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
            Thread.sleep(100);
        }
    }



    public static long testFairPerformance(boolean isFair, long lockTimme) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(isFair);
        CountDownLatch countdown = new CountDownLatch(50);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
//                    Thread.sleep(lockTimme);
                    countdown.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }
        countdown.await();

        return System.currentTimeMillis() - startTime;
    }
}
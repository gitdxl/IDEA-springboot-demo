package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序调用方法
 * 一个实例传递给3个线程，但是必须方法的执行顺序必须是 first() -> second() -> third()
 * @author : dengxuelong
 * @date : 2019/05/24 14:18
 */
public class _0_OrderInvoke {
    Semaphore sem1 = new Semaphore(1);
    Semaphore sem2 = new Semaphore(1);
    Semaphore sem3 = new Semaphore(1);

    public _0_OrderInvoke() throws InterruptedException {
        sem1.acquire();
        sem2.acquire();
    }

    public void first(){
        try{
            sem3.acquire();
            System.out.println("first()...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //唤醒一个正在等待执行second()的线程
            sem1.release();
        }
    }

    public void second(){
        try{
            sem1.acquire();
            System.out.println("second()...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //唤醒一个正在等待执行third()的线程
            sem2.release();
        }
    }

    public void third(){
        try {
            sem2.acquire();
            System.out.println("third()....。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            sem3.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        _0_OrderInvoke o = new _0_OrderInvoke();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{o.first();}).start();
//            Thread.sleep(1000);
            new Thread(()->{o.third();}).start();
//            Thread.sleep(550);
            new Thread(()->{o.second();}).start();
        }
    }
}
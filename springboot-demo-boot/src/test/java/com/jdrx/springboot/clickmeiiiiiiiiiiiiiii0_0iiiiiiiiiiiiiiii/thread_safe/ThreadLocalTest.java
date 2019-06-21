package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author : dengxuelong
 * @date : 2018/09/17 14:57
 */
public class ThreadLocalTest {
    public static void main(String[] args){
        SynchronousQueue sq = new SynchronousQueue();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sq.put(i);
                    System.out.println("数据开始被消费:" + i);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                while (true){
                    try {
                        Object t = sq.take();
                        System.out.println(Thread.currentThread().getName()+"  数据已经被消费:" + t);
                        Thread.sleep(10000);
                    } catch (Exception e) {
                    }
                }
            }).start();
        }

    }
}
class AA{
    @Override
    public int hashCode() {
        return 11;
    }
}
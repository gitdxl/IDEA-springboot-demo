package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : dengxuelong
 * @date : 2019/07/17 15:54
 */
public class ReentrantLockFairTest {
    public static void main(String[] args) {
        //创建了3个线程，模拟三个窗口卖票
        MyThread t = new MyThread("线程一");

        Thread mt1 = new Thread(t);
        Thread mt2 = new Thread(t);
        Thread mt3 = new Thread(t);

        //启动线程
        mt1.start();
        mt2.start();
        mt3.start();
    }
}

class T1 extends Thread {

}

class T2 implements Runnable {

    @Override
    public void run() {

    }
}


class MyThread extends Thread {
    private int num = 5;//模拟还剩余5张票
    private String name;//用来表示线程名称

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (num > 0) {
            num--;
            System.out.println(name + "卖出了一张票，剩余票数为" + num);
        }
    }
}
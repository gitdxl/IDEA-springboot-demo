package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

/**
 * @author : dengxuelong
 * @date : 2018/11/05 11:19
 */
public class InterruptTest {
    public static void main(String[] args) {
        InterruptThread it = new InterruptThread();
        it.start();
        it.interrupt();
    }
}

class InterruptThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(this.isInterrupted());
            e.printStackTrace();
        }
    }
}
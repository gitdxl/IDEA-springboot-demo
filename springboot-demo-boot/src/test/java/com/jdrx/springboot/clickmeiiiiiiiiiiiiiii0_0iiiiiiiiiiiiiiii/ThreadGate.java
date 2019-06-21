package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

/**
 * @author : dengxuelong
 * @date : 2019/03/15 13:53
 */
public class ThreadGate {
    int count;
    int realCount;

    public ThreadGate(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        this.wait();
    }

    public synchronized void countDown() throws InterruptedException {
        if (++realCount == count) {
            notify();
        }
    }

    public synchronized void reset(){
        realCount = 0;
    }
}
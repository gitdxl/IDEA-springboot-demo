package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : dengxuelong
 * @date : 2018/09/12 15:51
 */
public class Test {
    public static void sellTicket(A a) throws InterruptedException {
        int t = a.getTicket();
        if(a.getTicket() > 0){
//            Thread.sleep(1);
            a.ticket--;
            System.out.println("卖票成功,剩余票:"+a.getTicket());
        }
        Thread.currentThread().stop();
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(10000);
        A a = new A(1);
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                try {
                    cb.await();
                    sellTicket(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
class A {
    int ticket;

    public A(int ticket) {
        this.ticket = ticket;
    }

    public synchronized int getTicket() {
        return ticket;
    }
}
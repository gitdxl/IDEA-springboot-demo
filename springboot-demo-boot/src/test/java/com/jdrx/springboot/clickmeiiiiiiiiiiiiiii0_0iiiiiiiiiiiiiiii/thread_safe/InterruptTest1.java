package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;


import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用 中断 取消线程
 * @author : dengxuelong
 * @date : 2018/11/05 13:58
 */
public class InterruptTest1 {
    public static void main(String[] args) throws InterruptedException {
        try {
            int i = 1/0;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(1111);
    }

}
class InterruptThread1 extends Thread{
    LinkedBlockingQueue queue = new LinkedBlockingQueue(1);
    @Override
    public void run() {
        while (!this.isInterrupted()){
            try {
                System.out.println("put() start...");
                queue.put(2222);
                System.out.println("put() end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("退出...");
                break;
            }
        }
    }
    public void cancel(){
        this.interrupt();
    }
}
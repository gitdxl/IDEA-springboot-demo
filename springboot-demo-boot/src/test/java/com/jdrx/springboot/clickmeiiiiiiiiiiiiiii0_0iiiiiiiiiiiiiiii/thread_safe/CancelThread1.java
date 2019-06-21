package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用 线程池 取消任务
 * 一个不合理的取消的方法：不符合中断策略
 */
public class CancelThread1 {
    static ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
    /**
     * 执行一个任务，在指定时间后取消任务
     * 不合理的原因：任意线程都能执行此方法，而这些调用线程可能会被中断，此方法肯定是不知道
     *              调用线程的中断策略的，所以处理不了中断策略
     * 调用此方法的线程何时回被中断：比如任务很快就运行完成了，方法返回。此时线程池执行
     *               currentThread.interrupt()，调用线程就被中断了。我们本意只不是想
     *               中断调用线程的
     * 优点：调用线程能够知道任务执行过程中是否出现了异常
     * @param task 任务
     * @param seconds 在多少秒后取消任务
     */
    static public void execute(Runnable task,int seconds){
        Thread currentThread = Thread.currentThread();
        ses.schedule(() -> currentThread.interrupt(), seconds, TimeUnit.SECONDS);
        task.run();
    }

    public static void main(String[] args) {
        execute(new CancelThread11(),1);
    }
}

class CancelThread11 extends Thread {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("111");
        }
        Thread.currentThread().interrupted();
    }
}









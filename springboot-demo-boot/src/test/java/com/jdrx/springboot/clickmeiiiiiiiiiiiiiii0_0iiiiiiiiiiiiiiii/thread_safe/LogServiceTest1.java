package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 取消日志服务【生产者消费者模型】
 * @author : dengxuelong
 * @date : 2018/11/28 11:14
 */
public class LogServiceTest1 {
    public static void main(String[] args) throws InterruptedException {
        MyLogger logger = new MyLogger();
        logger.start();
        new Thread(()->{
                try {
                    logger.log(Thread.currentThread().getName() + "   i-----------");
                } catch (Exception e) {
                    System.out.println("日志服务已被关闭");
            }
        }).start();
        Thread.sleep(50);
        logger.stop();
    }

}
class MyLogger{
    /** 消息队列*/
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
    /**日志服务是否被取消*/
    private volatile boolean isShutdown = false;
    /** 未处理的消息记录数 */
    private volatile int count = 0;

    /** 日志记录 */
    public void log(String msg) throws Exception {
        synchronized (this){
            if (isShutdown) {
                throw new Exception("日志服务已被关闭");
            }
            count ++;
        }
        queue.put(msg);
    }
    /** 处理日志信息的线程*/
    Thread loggerThread = new Thread(()->{
        while(true){
            try {
                synchronized (MyLogger.this){
                    if(isShutdown && count ==0){
                        //退出
                        break;
                    }
                }
                //输出日志信息
                System.out.println("输出日志信息："+queue.take());
                synchronized (MyLogger.this){
                    count --;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    /**关闭日志服务*/
    public void stop(){
        synchronized (this){
            isShutdown = true;
        }
    }
    public void start(){
        loggerThread.start();
    }
}
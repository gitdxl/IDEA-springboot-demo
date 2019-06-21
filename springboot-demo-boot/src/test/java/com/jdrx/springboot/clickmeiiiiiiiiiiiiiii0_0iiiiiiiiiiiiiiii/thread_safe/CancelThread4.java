package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 取消【生产者消费者任务】
 * <
 * @author : dengxuelong
 * @date : 2018/11/28 16:05
 */
public class CancelThread4 {
    private BlockingQueue<Data> queue = new LinkedBlockingQueue<>(10);
    Thread producer = new Producer();
    Thread consumer = new Consumer();
    /** 开始*/
    public void start(){
        producer.start();
        consumer.start();
    }
    /** 取消生产者/消费者*/
    public void stop(){
        //中断生产者
        producer.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        CancelThread4 ct = new CancelThread4();
        ct.start();
        Thread.sleep(3000);
        ct.stop();
    }


    /** 生产者线程*/
    class Producer extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    queue.put(produce());
                } catch (InterruptedException e) {
                    //处理中断
                    try {
                        System.out.println("收到中断 向队列中添加一个毒药(poison pill)");
                        //向队列中添加一个毒药(poison pill)
                        queue.put(Data.buildPoison());
                        //取消生产者线程
                        break;
                    } catch (InterruptedException e1) {
                        System.out.println("添加poison pill失败");
                    }
                }
            }
        }
        /** 生产数据*/
        public Data produce() throws InterruptedException {
            //用sleep来模拟 生产数据时能响应中断
            Thread.sleep(100);
            return Data.buildData(new Random().nextInt(100));
        }
    }

    /** 消费者线程*/
    class Consumer extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(200);
                    Data data = queue.take();
                    if (data.isPoison) {
                        //数据是毒药  取消消费者线程
                        System.out.println("数据是毒药  取消消费者线程");
                        break;
                    }else{
                        //消费数据
                        consume(data);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        /** 消费数据*/
        public void consume(Data data){
            System.out.println("消费数据： "+ data.value);
        }
    }

}
/** 生产者产生的数据 消费者要消费的数据*/
class Data{
    boolean isPoison;
    int value;
    public static Data buildData(int value){
        Data data = new Data();
        data.value = value;
        data.isPoison = false;
        return data;
    }

    public static Data buildPoison(){
        Data data = new Data();
        data.isPoison = true;
        return data;
    }

}
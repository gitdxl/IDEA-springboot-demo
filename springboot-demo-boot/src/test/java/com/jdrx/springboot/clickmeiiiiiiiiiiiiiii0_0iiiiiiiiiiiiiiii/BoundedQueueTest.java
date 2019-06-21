package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.util.Random;

/**
 * 有界队列
 * @author : dengxuelong
 * @date : 2019/03/13 15:43
 */
public class BoundedQueueTest {
    //头  从头部删除元素
    private int head = 0;
    //尾部  从尾部添加元素
    private int tail = 0;
    //队列大小
    private int size = 10;
    //队列实际元素个数
    private int count = 0;
    private Integer[] queue = new Integer[size];

    public synchronized void put(Integer value) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        queue[tail] = value;
        tail = ++tail % size;
        count++;
        notifyAll();
    }

    public synchronized Integer take() throws InterruptedException {
        while (isEmpty()) {
            //必须使用while()继续检查先验条件，因为调用的是notifyAll。
            //它会唤醒所有等待者(写者和读者)，但不是所有读者都能取到数据。
            this.wait();
        }
        Integer result = queue[head];
        queue[head] = null;
        head = ++head % size;
        count --;
        this.notifyAll();
        return result;
    }

    /** 是否已满 */
    public boolean isFull(){
        return size == count;
    }

    /** 是否为空 */
    public boolean isEmpty(){
        return count == 0;
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedQueueTest queue = new BoundedQueueTest();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    System.out.println("获取到了元素：" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        Thread.sleep(2000);
        for (int i = 0; i < 10; i++) {
            queue.put(i);
        }
//        new Thread(()->{
//            try {
//                while (true) {
//                    Thread.sleep(1000);
//                    int value = new Random().nextInt(100);
//                    queue.put(value);
//                    System.out.println("添加了元素：" + value);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();
//        new Thread(()->{
//            try {
//                Thread.sleep(5000);
//                while (true) {
//                    System.out.println("获取到了元素：" + queue.take());
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();
    }
}
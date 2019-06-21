package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : dengxuelong
 * @date : 2019/03/15 16:48
 */
public class BoundedQueueWithConditionTest {
    //头  从头部删除元素
    private int head = 0;
    //尾部  从尾部添加元素
    private int tail = 0;
    //队列大小
    private int size = 10;
    //队列实际元素个数
    private int count = 0;
    private Integer[] queue = new Integer[size];
    private ReentrantLock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition takeCondition = lock.newCondition();

    public void put(Integer value) throws InterruptedException {
        try {
            lock.lock();
            while (isFull()) {
                putCondition.await();
            }
            queue[tail] = value;
            tail = ++tail % size;
            count++;
            takeCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    public Integer take() throws InterruptedException {
        try {
            lock.lock();
            while (isEmpty()) {
                takeCondition.await();
            }
            Integer result = queue[head];
            queue[head] = null;
            head = ++head % size;
            count--;
            putCondition.signal();
            return result;
        } finally {
            lock.unlock();
        }
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
        BoundedQueueWithConditionTest queue = new BoundedQueueWithConditionTest();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
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
    }
}
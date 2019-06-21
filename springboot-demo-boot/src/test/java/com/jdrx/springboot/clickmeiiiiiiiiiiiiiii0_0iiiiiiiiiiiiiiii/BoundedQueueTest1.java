package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

/**
 * @author : dengxuelong
 * @date : 2019/04/01 17:10
 */
public class BoundedQueueTest1 {
    //头  从头部删除元素
    private int head = 0;
    //尾部  从尾部添加元素
    private int tail = 0;
    //队列大小
    private int size = 10;
    //队列实际元素个数
    private int count = 0;
    private Integer[] queue = new Integer[size];
    //read condition
    private Object readLock = new Object();
    //write condition
    private Object writeLock = new Object();

    public void put(Integer value) throws InterruptedException {
        //同时获取2个锁
        synchronized (readLock){
            synchronized (writeLock){
                while (isFull()) {
                    //在写锁上等待
                    writeLock.wait();
                }
                queue[tail] = value;
                tail = ++tail % size;
                count++;
                //唤醒一个在读上等待的一个线程
                readLock.notifyAll();
            }
        }

    }

    public synchronized Integer take() throws InterruptedException {
        //同时获取2个锁
        synchronized (readLock){
            synchronized (writeLock){
                while (isEmpty()) {
                    //在读锁上等待
                    readLock.wait();
                }
                Integer result = queue[head];
                queue[head] = null;
                head = ++head % size;
                count --;
                writeLock.notifyAll();
                return result;
            }
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
}
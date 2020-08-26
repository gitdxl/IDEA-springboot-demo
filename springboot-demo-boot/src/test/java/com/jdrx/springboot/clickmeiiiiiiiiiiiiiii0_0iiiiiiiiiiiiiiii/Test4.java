package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : dengxuelong
 * @date : 2019/04/01 13:53
 */
public class Test4 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("t1  end...");
        });
        t1.start();

        Thread.sleep(1111);

        Thread t2= new Thread(() -> {
            System.out.println("t2.start");
            try {
                lock.tryLock(1,TimeUnit.DAYS);
//                lock.lock();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("t2");
        });
        t2.start();

        Thread.sleep(1111);
        System.out.println("interrupt...");
        t1.interrupt();
        t2.interrupt();

    }

    public static int GetNumberOfK(int [] array , int k) {
        int index = search(array, k);
        if(index == -1){
            return 0;
        }
        int len = array.length;
        int count = 1;

        for (int i = index-1; i >= 0; i--) {
            if(array[i] == k){
                count ++;
            }

        }

        for (int i = index+1;i != len; i++) {
            if( array[i] == k){
                count ++;
            }
        }

        return count;
    }

    //二分查找，找到目标值的索引
    public static int search(int [] array, int k){
        if(array == null){
            return -1;
        }

        int len = array.length;

        int i = 0;
        int j = len - 1;

        while(i <= j){
            int middleIndex = (i + j) / 2;
            int middle = array[middleIndex];

            if(middle == k){
                return middleIndex;
            }

            if(k > middle){
                i = middleIndex + 1;
            } else {
                j = middleIndex - 1 ;
            }
        }

        return -1;
    }
}










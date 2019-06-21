package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.concurrent.Semaphore;

/**
 * 一个固定长度
 * @author : dengxuelong
 * @date : 2019/02/27 10:27
 */
public class FixSizeList {
    int size = 10;
    //可用元素
    private Semaphore availableElement = new Semaphore(0);
    //可用空间
    private Semaphore availableSpace = new Semaphore(size);
    private Object[] arr = new Object[size];
    private int putPosition,takePosition = 0;

    public void put(Object e) throws InterruptedException {
        //可用空间-1
        availableSpace.acquire();
        //添加元素
        doInsert(e);
        //可用元素+1
        availableElement.release();
    }
    public Object take() throws InterruptedException {
        //可用元素-1
        availableElement.acquire();
        //删除元素
        Object o = doTake();
        //可用空间+1
        availableSpace.release();
        return o;
    }
    private synchronized void doInsert(Object e){
        arr[putPosition] = e;
        putPosition = (++putPosition == size) ? 0 : putPosition;
    }
    private synchronized Object doTake(){
        Object o = arr[takePosition];
        takePosition = (++takePosition == size) ? 0 : takePosition;
        return o;
    }

    public static void main(String[] args) throws InterruptedException {
//        FixSizeList list = new FixSizeList();
//        for (int i = 0; i < 11; i++) {
//            list.put(new Object());
//        }
//        System.out.println(111);
        LocalDate localDate = LocalDate.of(2018,2,1);
        YearMonth yearMonth = YearMonth.of(2018,2);
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(localDate);
    }

}









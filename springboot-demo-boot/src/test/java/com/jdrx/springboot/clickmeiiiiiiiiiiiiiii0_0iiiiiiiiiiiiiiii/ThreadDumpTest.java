package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

/**
 * @author : dengxuelong
 * @date : 2019/02/20 14:54
 */
public class ThreadDumpTest {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {
          synchronized (lock1){
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              synchronized (lock2){

              }
          }
        }).start();

        new Thread(() -> {
            synchronized (lock2){
                synchronized (lock1){

                }
            }
        }).start();


    }
}
package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

/**
 * @author : dengxuelong
 * @date : 2018/09/14 15:45
 */
public class VolatileTest {
      static boolean flag = true;
    public static void say(){
        while(flag){
            System.out.println("fuc**ou...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            say();
        }).start();
        Thread.sleep(1);
        flag = false;
    }
}
package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.Date;

/**
 * @author : dengxuelong
 * @date : 2018/10/24 11:23
 */
public class IntegerSynchronizedTest {
    public void say(Integer arg ) {
        Integer i = Integer.valueOf(arg);
        synchronized (i){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date().toString() + i);
        }
    }

    public static void main(String[] args) {
        IntegerSynchronizedTest ist = new IntegerSynchronizedTest();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                    ist.say(finalI %4);
            }).start();
        }
    }
}
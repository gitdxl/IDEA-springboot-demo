package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.concurrent.Semaphore;

public class SamephreTest {
    public static void main(String[] args) {
        //10个许可
        Semaphore semaphore = new Semaphore(10);
        //直接凭空增加一个许可
        semaphore.release();

        //11个线程请求许可
        for (int i = 11; i > 0; i--) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("thread:" + finalI);

                    //获取许可后不释放
//                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();

        }
    }
}

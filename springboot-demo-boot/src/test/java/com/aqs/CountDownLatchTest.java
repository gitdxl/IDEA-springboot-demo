package com.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3);

        for (int i = 3; i > 0; i--) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(10000 * finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cdl.countDown();
            }).start();
        }

        System.out.println("coundownlatch await");
        cdl.await();
        System.out.println("main end...");

    }
}

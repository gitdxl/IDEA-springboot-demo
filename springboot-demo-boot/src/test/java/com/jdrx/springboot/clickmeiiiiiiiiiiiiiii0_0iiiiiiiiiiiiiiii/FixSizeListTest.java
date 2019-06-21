package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : dengxuelong
 * @date : 2019/02/27 14:16
 */
public class FixSizeListTest {

    @Test
    public void blickingTest() throws InterruptedException {
        FixSizeList list = new FixSizeList();
        Thread take = new Thread(() -> {
            try {
                //从一个空集合中取元素预期会阻塞
                list.take();
                System.out.println("测试失败");
            } catch (InterruptedException e) {
                System.out.println("测试成功 在take()方法处被阻塞!");
            }
        });
        take.start();

        Thread.sleep(2000);
        System.out.println(take.getState());
        //中断目标线程
        take.interrupt();

        take.join(2000);
        Assert.assertFalse(take.isAlive());
    }

    @Test
    public void t1(){
        byte b = 100;
        byte[] b1 = new byte[]{b};
        String s = new String(b1);
        byte[] byte2 = s.getBytes();
        System.out.println(byte2[0]);
    }
}







package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.jdk_proxy;

import java.lang.reflect.Proxy;
import java.util.concurrent.Semaphore;

public class JDKProxyTest {
    public static void main(String[] args) {


        //b=15：0000 1111
        byte b = (1 << 4) - 1;
        System.out.println(b); //15
        int c = ~b;
        System.out.println(c); //-16  1111 0000(补码)  ---除去符号位取反再加1--> 1001 0000(原码) = -16
        System.out.println(c >> 1);
        System.out.println(c >>> 1);
        System.out.println(-1 >>> 3);

        BlockCar car = new BlockCar();
        TimeProxy timeProxy = new TimeProxy(car);
        IMove timeCar = (IMove) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), timeProxy);
        timeCar.move();
        System.out.println(timeCar.getClass());


        BlockCar car1 = new BlockCar();
        TimeProxy timeProxy1 = new TimeProxy(car1);
        IMove timeCar1 = (IMove) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), timeProxy1);
        timeCar1.move();
        System.out.println(timeCar1.getClass());


        new Thread(() -> {
            while(true){}
        }).start();
    }
}

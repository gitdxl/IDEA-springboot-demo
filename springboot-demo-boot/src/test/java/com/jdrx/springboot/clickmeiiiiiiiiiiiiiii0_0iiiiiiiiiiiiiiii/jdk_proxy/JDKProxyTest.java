package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.jdk_proxy;

import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) {
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

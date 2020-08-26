package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeProxy implements InvocationHandler {
    IMove car;

    public TimeProxy(IMove car) {
       this.car =  car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("time proxy... start");
        method.invoke(car ,args);
        System.out.println("time proxy... end");
        return null;
    }
}

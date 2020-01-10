package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : dengxuelong
 * @date : 2020/01/07 16:59
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();

    }
}

class DynamicProxy implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy...");
        method.invoke(proxy, args);
        return null;
    }

}
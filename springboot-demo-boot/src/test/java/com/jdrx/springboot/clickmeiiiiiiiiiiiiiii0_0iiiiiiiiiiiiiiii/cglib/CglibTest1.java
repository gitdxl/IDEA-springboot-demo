package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.cglib;

import com.A;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest1 {
    public CglibTest1() {
        System.out.println("constructor");
    }

    public final String say(){
        System.out.println("say()...");
        return "say()";
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
                Object result = methodProxy.invokeSuper(o, arg);
                System.out.println("after...");
                System.out.println("say() 的返回值为" + result);
                return "proxy after return value is fu**ou";
            }
        });
        enhancer.setSuperclass(CglibTest1.class);
        Class t[] = {Integer.class};
        Object arg[] = {"2"};
        CglibTest1 test = (CglibTest1) enhancer.create(t,arg);
        System.out.println(test.say());
    }
}

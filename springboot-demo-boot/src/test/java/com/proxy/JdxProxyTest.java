package com.proxy;

import java.lang.reflect.Proxy;

public class JdxProxyTest {
    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Move proxy = (Move) Proxy.newProxyInstance(JdxProxyTest.class.getClassLoader(), new Class[]{Move.class}, new TimeInvocationHandler(new MoveImpl()));
        proxy.move();
    }
}

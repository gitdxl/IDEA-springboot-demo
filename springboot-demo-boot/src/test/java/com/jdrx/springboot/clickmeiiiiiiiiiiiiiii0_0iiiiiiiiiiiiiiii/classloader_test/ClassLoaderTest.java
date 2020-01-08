package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.classloader_test;

import com.A;

/**
 * @author : dengxuelong
 * @date : 2020/01/02 11:27
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader();
        MyObject myObject = new MyObject();

        Class<?> myObjectClass = classLoader.loadClass("com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.classloader_test.MyObject");
        System.out.println(myObject.getClass().equals(myObjectClass));
        Object o = new Object();


        Class<?> c = classLoader.loadClass("java.lang.Object");
        Class<?> c1 = o.getClass();
        classLoader.s();

    }
}
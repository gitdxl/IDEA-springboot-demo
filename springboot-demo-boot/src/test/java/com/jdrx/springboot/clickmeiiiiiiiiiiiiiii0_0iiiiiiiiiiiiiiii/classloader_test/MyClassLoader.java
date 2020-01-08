package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.classloader_test;

/**
 * @author : dengxuelong
 * @date : 2020/01/06 16:53
 */
public class MyClassLoader extends ClassLoader {
    public void s(){
        Class<?> loadedClass = findLoadedClass("java.lang.Object");
    }
}
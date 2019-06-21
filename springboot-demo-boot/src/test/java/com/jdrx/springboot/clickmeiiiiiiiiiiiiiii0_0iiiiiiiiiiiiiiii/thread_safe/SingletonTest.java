package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

/**
 * @author : dengxuelong
 * @date : 2018/11/09 16:24
 */
public class SingletonTest {
    private static SingletonTest st = null;
    public SingletonTest getInstance(){
        if (st == null) {
            synchronized (SingletonTest.class){
                if (st == null) {
                    st = new SingletonTest();
                }
                return st;
            }
        }
        return st;
    }

    public SingletonTest getInstance1(){
        if (st == null) {
            synchronized (SingletonTest.class){
                if (st == null) {
                    st = new SingletonTest();
                }
            }
        }
        return st;
    }

    public static void main(String[] args) {
        Object o = null;
        double d = Double.valueOf(String.valueOf(o));
    }
}
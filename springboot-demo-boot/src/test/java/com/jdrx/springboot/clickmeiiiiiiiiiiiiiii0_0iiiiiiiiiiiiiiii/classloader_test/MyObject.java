package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.classloader_test;

/**
 * @author : dengxuelong
 * @date : 2020/01/02 11:28
 */
public class MyObject {
    static String s = "java";
    static{
        System.out.println("static block .....");
    }

    public void say(){
        System.out.println("parent say()...");
    }

    static class SubClass extends MyObject{
        @Override
        public void say(){
            System.out.println("SubClass say()...");
        }
    }

    public static void main(String[] args) {
        MyObject p = new SubClass();
        p.say();
        p = new MyObject();
        p.say();
    }

}


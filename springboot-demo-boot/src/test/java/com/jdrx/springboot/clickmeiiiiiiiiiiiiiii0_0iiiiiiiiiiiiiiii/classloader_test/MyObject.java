package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.classloader_test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : dengxuelong
 * @date : 2020/01/02 11:28
 */
public class MyObject {
    static String s = "java";

    static {
        System.out.println("static block .....");
    }

    public void say() {
        System.out.println("parent say()...");
    }

    static class SubClass extends MyObject {
        @Override
        public void say() {
            System.out.println("SubClass say()...");
        }
    }

    public static int say1(List<Integer> list) {
        return 1;
    }

    public static String say(List<String> list) {
        return "";
    }

    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(new MyObject());
        //jdk1.5- 通过类型转换来实现,代码不方便，而且容易出现ClassCastException
        MyObject o = (MyObject) list.get(0);

        //jdk1.5+ 泛型的写法
        List<MyObject> list1 = new LinkedList();
        list1.add(new MyObject());
        MyObject o1 = list1.get(0);

        MyObject p = new SubClass();
        p.say();
        p = new MyObject();
        p.say();
    }

}


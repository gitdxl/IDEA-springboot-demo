package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.treemap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeSet<A> set = new TreeSet<>();
//        HashSet<A> set = new HashSet<>();
        set.add(new A(11));
        set.add(new A(13));
        set.add(new A(1));
        set.add(new A(81));
        set.add(new A(12));
        set.add(new A(123));
        set.add(new A(51));
        set.add(new A(21));
        set.add(new A(31));
        for (A a : set) {
            System.out.println(a.i);
        }
    }
}
class A implements Comparable{
    int i;

    public A(int i) {
        this.i = i;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof A) {
            A a = (A) o;
            return i - a.i;
        }
        return i ;
    }
}
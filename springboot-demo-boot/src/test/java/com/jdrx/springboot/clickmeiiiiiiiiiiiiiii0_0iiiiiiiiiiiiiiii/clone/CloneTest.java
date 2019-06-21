package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.clone;

public class CloneTest implements Cloneable {
    Object[] o ;
    final String zz = "aaaa";
    A a = new A();
    @Override
    public CloneTest clone() {
        try {
            CloneTest clone = (CloneTest) super.clone();
            clone.a = a.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CloneTest c = new CloneTest();
        CloneTest clone = c.clone();
        System.out.println(clone.a);
    }
}
class A{
    @Override
    public A clone(){
        try {
            return (A) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

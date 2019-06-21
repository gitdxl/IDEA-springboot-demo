package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

/**
 * @author : dengxuelong
 * @date : 2019/02/13 10:21
 */
public class CloneTest implements Cloneable {
    {
        System.out.println("constructor block");
    }
    CloneTest(){
        System.out.println("constructor");
    }
    @Override
    protected CloneTest clone() throws CloneNotSupportedException {
        return (CloneTest) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest c = new CloneTest();
        CloneTest clone = c.clone();
        System.out.println(clone == c);
    }
}
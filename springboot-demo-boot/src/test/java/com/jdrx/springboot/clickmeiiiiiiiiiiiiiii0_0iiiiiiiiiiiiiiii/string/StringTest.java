package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.string;

/**
 * @author : dengxuelong
 * @date : 2020/04/27 17:41
 */
public class StringTest {
    public static void main(String[] args) {
        //a、b、c均在常量池中
        String a = "hello";
        String b = "world";
        String c = "helloworld";

        //常量：常量池中的String； 变量：堆中的String。当然'变量'会指向'常量'

        //字符串相加,如果都是'常量'相加，是先加，再从常量池中进行查找，返回的对象始终都是常量池中的String。
        System.out.println(c == "hello" + "world");// true
        System.out.println("hello" + "world" == "hello" + "world");// true

        // 字符串相加 如果包含'变量'相加，那么会先在堆中分配空间，然后再从常量池中进行查找，如果找到了，
        //                                          就指向它。返回的对象始终是在堆中新创建的String。
        System.out.println(c == a + b); // false
        System.out.println(c == a + "world"); // false

        //dev branch vv
    }

}
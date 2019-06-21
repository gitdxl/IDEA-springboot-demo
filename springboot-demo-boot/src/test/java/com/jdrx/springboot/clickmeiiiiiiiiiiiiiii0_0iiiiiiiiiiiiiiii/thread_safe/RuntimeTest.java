package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

/**
 * @author : dengxuelong
 * @date : 2019/01/29 13:25
 */
public class RuntimeTest {
    public static void main(String[] args) {
        System.out.println(t(5));
    }

    public static int t(int n){
        for (int i = n; i > 0; i--) {
            System.out.println(i);
            if(i > 2){
                continue;
            }
            return 10000;
        }
        return 1000;
    }

}
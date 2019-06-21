package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

/**
 * 不使用中间变量交换2个数的值
 * @author : dengxuelong
 * @date : 2019/05/27 14:26
 */
public class _0_ExchangeNumber {
    public static void exchange(int i, int j){
        System.out.printf("i=%d j=%d%n", i, j);
        //i_value + j_value
        i = j + i;
        //（i_value + j_value）- j_value = i_value
        j = i - j; // i_value
        //（i_value + j_value）- i_value = j_value
        i = i - j;
        System.out.printf("i=%d j=%d%n", i, j);

    }

    public static void main(String[] args) {
        exchange(2,4);
    }
}
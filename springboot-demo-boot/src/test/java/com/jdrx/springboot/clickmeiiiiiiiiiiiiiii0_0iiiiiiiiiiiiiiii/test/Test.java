package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.test;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        int[] arr = new int[45 + 1];
        System.out.println(new Test().climbStairs(45, arr));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(new Test().climbStairs(45));
        System.out.println(new Test().climbStairs1(45));

    }



    public int climbStairs(int n, int[] arr) {
        if(arr[n] != 0){
            return arr[n];
        }
        if(n < 1){
            return 0;
        }
        if(n == 1) return 1;
        if(n == 2) return 2;

        arr[n] = climbStairs(n - 1, arr) + climbStairs(n - 2, arr);

        return arr[n];
    }


    public int climbStairs(int n){
        //使用数组来存储解法的数量
        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i -1] + arr[i - 2];
        }

        return arr[n - 1];
    }

    public int climbStairs1(int n){
        // 因为实际上只会有【前2个解法的数量】会被用到，所以没必要用O(n)的数组来存储

        int first = 1;
        int second = 2;
        int third = 0;

        for (int i = 2; i < n; i++) {
            third = first + second;

            first = second;
            second = third;
        }

        return third;
    }



}

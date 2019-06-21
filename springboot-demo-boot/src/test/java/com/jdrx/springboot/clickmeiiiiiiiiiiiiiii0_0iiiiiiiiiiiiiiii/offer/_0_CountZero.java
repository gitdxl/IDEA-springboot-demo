package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

/**
 * n!的结尾有多少个0
 * @author : dengxuelong
 * @date : 2019/05/27 15:34
 */
public class _0_CountZero {

    public static int countZero(int value){
        int count = 0;
        for (int i = value; i > 0; i--) {
            count += count(i, 5);
        }
        System.out.println(value + "  ===  " + count);
        return count;
    }

    public static int count(int value, int d){
        if (d == 0) {
            return 0;
        }
        int count = 0;
        while(value >= d && value % d == 0){
            count ++ ;
            value = value / d;
        }
        return count ;
    }

    public static void main(String[] args) {
        System.out.println("count(10,10)" + count(10,10));
        System.out.println("count(5*5,5)" + count(5*5,5));
        System.out.println("count(5*2*5*5,5)" + count(5*2*5*5,5));
        System.out.println("count(5*2,4)" + count(5*2,4));

        countZero(5);
        countZero(15);
        countZero(21);
        countZero(1135);
        countZero(145);
    }
}
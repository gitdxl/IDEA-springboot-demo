package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : dengxuelong
 * @date : 2019/04/01 13:53
 */
public class Test4 {
    static  ThreadLocal<String>   tl = new ThreadLocal<>();
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,4, 1, 1,4}));
    }

    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }

    public static void test(){
        retry:
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 3) {
                break retry;
            }
        }
        System.out.println("end...");
    }


    public static void compute() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int j = i % 100000;
            i = j = 2;
        }
        System.out.println((System.currentTimeMillis()) + "<----");
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        int rowIndex = 0;
        int colIndex = col - 1;
        while(rowIndex < row && colIndex >= 0){
            int currentValue = matrix[rowIndex][colIndex];
            if(currentValue == target){
                System.out.println("row = " + rowIndex + "   col=" + colIndex);
                return true;
            } else if(currentValue > target){
                colIndex --;
            }else{
                rowIndex ++;
            }

        }
        return false;
    }
}










package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

import java.util.Arrays;

/**
 * 从一个有正数和负数的数组中找到【和最大】的连续数列
 * @author : dengxuelong
 * @date : 2019/05/27 18:09
 */
public class _0_ContinuousMaxValue {

    public static void maxSum(int[] array){
        int maxSum = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int currentSum = 0;
        int currentStart = 0;
        for (int i = 0; i < array.length; i++) {
            //只要当前段的和大于0，那么加上下一个数就可能得到最大值，
            // 而不管当前加上的数是一个正数还是负数
            currentSum += array[i];
            if (currentSum < 0) {
                //只要当前段的和小于0，就重新开始一个新的段
                currentStart = i + 1;
                currentSum = 0;
            }else if(currentSum > maxSum){
                //【当前段的和】大于maxSum,把最大和保存下来
                maxStart = currentStart;
                maxEnd = i;
                maxSum = currentSum;
            }
        }
        System.out.printf("从%d~%d得到最大值：%d%n", maxStart, maxEnd, maxSum);
    }
    public static void main(String[] args) {
        maxSum(new int[]{1,2,-6,5,-12,4,4,-1,-1,-2,5,-9});
    }

}
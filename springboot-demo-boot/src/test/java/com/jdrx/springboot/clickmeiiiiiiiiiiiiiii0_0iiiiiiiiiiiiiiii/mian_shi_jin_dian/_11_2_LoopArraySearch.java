package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import com.fr.function.IF;

import java.util.Arrays;

/**
 * 有一个循环移动后的升序数组，在其中查找一个值
 * @author : dengxuelong
 * @date : 2019/06/20 15:31
 */
public class _11_2_LoopArraySearch {
    public static int loopArraySearch(int [] arr, int value){
        if (arr == null) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == value) {
                //找到值
                return middle;
            }
            //问题是如何判断目标值在middle的左边还是右边
            if (arr[middle + 1] <= arr[right]) {
                //说明右边是有序的
                if(value >= arr[middle + 1]){
                    //目标值在右边(目标值大于右边的最小值)
                    left = middle + 1;
                }else{
                    //目标值在左边
                    right = middle - 1;
                }
            } else{
                //左边是有序的，左右两边至少有一边是有序的，因为只要一个"拐点"
                if (value >= arr[left]) {
                    //目标值在左边（目标值大于左边的最小值)
                    right = middle - 1;
                }else{
                    //目标值在右边
                    left = middle + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(loopArraySearch(new int[]{1,2,3,4,5,7,10,11,22,33,55,100}, 5));
        System.out.println(loopArraySearch(new int[]{10,11,22,33,55,100,1,2,3,4,5,7}, 5));
        System.out.println(loopArraySearch(new int[]{10,11,22,33,55,100,1,2,3,4,7}, 5));
    }
}
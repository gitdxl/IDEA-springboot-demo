package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Test11 {

    public static void main(String[] args) {
        boolean[] b = new boolean[1];
        System.out.println(b);
        int[] arr = {1,2,2,3};
        System.out.println(searchInsert(arr, 0));

    }

    public static int searchInsert(int[] nums, int target) {
        if(nums == null){
            return -1;
        }

        int i = 0;
        int j = nums.length - 1;

        while(i <= j){
            int middleIndex = (i + j) / 2;

            int val = nums[middleIndex];

            if(val == target){
                return middleIndex;
            } else if(val < target){
                //目标值比中间值大
                i = middleIndex + 1;
            } else {
                j = middleIndex - 1;
            }



        }
        
        if(nums[j] < target){
            return j +1;
        }
        return j;
    }

    public static int removeElement(int[] nums, int val) {
        if(nums == null){
            return 0;
        }

        int i=0;//空位置
        int j = 0;
        int len = nums.length;
        int count = len;

        while(j < len){
            if(nums[j] == val){
                //删除元素
                len --;
                nums[j] = 0;

            } else{
                if(i != j){
                    nums[i]=nums[j];
                    nums[j] = 0;
                    i++;
                }

            }

            j++;

        }

        return count;
    }
}

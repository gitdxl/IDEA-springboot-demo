package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

/**
 * @author : dengxuelong
 * @date : 2019/04/04 17:31
 */
public class _3_RepeateElementCount3 {
    public static void main(String[] args) {
        int array[] = {1,4,2,6,6,2,5,6};
        repeatElementCount(array);
    }
    public static void repeatElementCount(int[] array) {
        if (array == null) {
            throw new RuntimeException("数组不能为空");
        }
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i){
                //元素值不等于下标值
                if(array[i] == array[array[i]]){
                    
                }
            }
        }
    }
}
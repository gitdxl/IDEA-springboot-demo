package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

/**
 * 数组中重复元素的个数
 * @author : dengxuelong
 * @date : 2019/04/04 13:52
 */
public class _3_RepeateElementCount1 {
    public static void main(String[] args) {
        int array[] = {3,2,144,5,11,2,2,144,5,5,99};
        repeateElementCount(array);
    }

    //

    /**
     * 数组中重复元素的个数
     * 首先对数组进行排序  对于有序的数组获取重复元素就很简单了
     */
    public static void repeateElementCount(int[] array){
        if(array == null){
            throw new RuntimeException("数组不能为空");
        }
        //排序
        sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            int currentElement = array[i];
            if (currentElement == array[i + 1]) {
                //重复次数
                int repeateCount = 2;
                //重复元素
                i++ ;
                while ((i < array.length - 1) && array[i] == array[i + 1]) {
                    i++ ;
                    repeateCount++;
                }
                System.out.println(String.format("发现重复元素：%d 重复次数：%d",
                        currentElement, repeateCount));
            }
        }
    }
    //选择排序
    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int middle = array[i];
                    array[i] = array[j];
                    array[j] = middle;
                }
            }
        }
    }
}
package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

/**
     * 对于一个长度为n的数组，且其中所有数字都在0~n-1范围内，求数组中重复元素的个数
 * 利用哈希表来解决
 * @author : dengxuelong
 * @date : 2019/04/04 15:29
 */
public class _3_RepeateElementCount2 {
    public static void main(String[] args) {
        int array[] = {1,4,2,6,6,2,5,6};
        repeatElementCount(array);
    }
    public static void repeatElementCount(int[] array){
        if (array == null) {
            throw new RuntimeException("数组不能为空");
        }
        Integer[] hashtable = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            if (currentElement < 0 || currentElement > array.length - 1) {
                //处理非法参数值
                throw new RuntimeException("元素值应该是从0~n-1");
            }
            if (hashtable[currentElement] == null) {
                //将元素保存到hashtable中
                hashtable[currentElement] = currentElement;
            }else{
                //对应位置上已经存在值了 那么就是重复元素
                System.out.println("发现重复元素：" + currentElement);
            }
        }
        for (int i = 0; i < hashtable.length; i++) {
            System.out.println(hashtable[i]);
        }
    }
}
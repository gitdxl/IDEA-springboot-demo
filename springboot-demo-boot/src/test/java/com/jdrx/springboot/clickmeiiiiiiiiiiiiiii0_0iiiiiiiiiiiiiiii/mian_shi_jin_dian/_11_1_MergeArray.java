package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * 两个排好序的数组A、B，A数组末尾有足够多的空间容纳B，试着将B复制到A中。
 * @author : dengxuelong
 * @date : 2019/06/19 16:16
 */
public class _11_1_MergeArray {

    public static void mergeArray(int[] a, int[] b, int aSize){
        if (a == null || b == null || a.length < b.length + aSize) {
            return ;
        }
        //指向a的末尾
        int i = aSize - 1;
        //指向b的末尾
        int j = b.length - 1;
        //指向合并后的新末尾
        int newLastIndex = i + b.length;

        while (j >= 0) {
            //将更大的元素放在a的末尾

            //i<0表示a中的元素全向后移动了，直接将b中的元素复制到a中
            if (i >= 0 && a[i] >= b[j]) {
                a[newLastIndex] = a[i];
                i -- ;
            }else{
                a[newLastIndex] = b[j];
                j --;
            }
            newLastIndex --;
        }
        printArr(a);
    }

    public static void main(String[] args) {
        //b数组插入到a的最前面
        mergeArray(new int[]{4,7,8,10,0,0,0,0,0,0},new int[]{1,2,3},4);
        //b数组插入到a的最末尾
        mergeArray(new int[]{4,7,8,10,0,0,0,0,0,0},new int[]{11,21,31},4);
        //正常
        mergeArray(new int[]{4,7,18,110,0,0,0,0,0,0},new int[]{11,21,31},4);
    }

    public static void printArr(int[] array){
        for (int i : array) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println();
    }
}





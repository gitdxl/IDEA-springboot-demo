package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

/**
 * 有2个排好序的数组A1,A2，要求把A2合并到A1中。合并后的A1还是有序的。
 * A1有足够的空间，【要求不能分配新的内存空间】
 *
 * @author : dengxuelong
 * @date : 2019/04/08 17:38
 */
public class _5_UnionSortedArray {

    public static void main(String[] args) {
        int[] a1 = {2, 4, 5, 11, 0, 0, 0};
        int[] a2 = {0, 1, 8};
        int a1Size = 4;
        union(a1, a2, a1Size);
    }

    /**
     * @param a1
     * @param a2
     * @param a1Size a1中实际元素个数
     */
    private static void union(int[] a1, int[] a2, int a1Size) {
        if (a1 == null || a2 == null || a1.length < a2.length + a1Size) {
            throw new RuntimeException("非法参数");
        }
        //原a1数组的末尾index
        int oldLastIndex = a1Size - 1;
        //合并后的新数组的末尾指针
        int newLastIndex = a1Size + a2.length - 1;
        //i指向a2的最后一个元素  依次递减
        int i = a2.length - 1;
        while (i >= 0) {
            if (oldLastIndex < 0) {
                //此时原a1中的所有元素都移动到了末尾，a2的值直接复制到a1的newLastIndex处
                a1[newLastIndex] = a2[i];
                newLastIndex--;
                i--;
            } else if (a2[i] >= a1[oldLastIndex]) {
                //a2的值更大，将a2的值移到a1的"末尾"（newLastIndex位置）,newLastIndex--
                a1[newLastIndex] = a2[i];
                newLastIndex--;
                i--;
            } else {
                //a2的值更小，将a1中oldLastIndex的值移动到newLastIndex,
                //              newLastIndex-- oldLastIndex--
                a1[newLastIndex] = a1[oldLastIndex];
                oldLastIndex--;
                newLastIndex--;
            }
        }

        for (int i1 : a1) {
            System.out.println(i1);
        }

    }
}









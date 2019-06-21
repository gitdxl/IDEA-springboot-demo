package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : dengxuelong
 * @date : 2019/06/18 14:44
 */
public class _11_Sort {

    /**
     * 冒泡排序
     */
    public static List<Integer> bubblingSort(Integer[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            //让相邻的2个元素比较
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //当前元素大于下一个元素  交换位置
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return new ArrayList<Integer>(Arrays.asList(array));
    }

    /**
     * 选择排序，就是在[未排序部分中]找到最小的元素，与[未排序部分]的第一个元素交换
     *
     * @param list
     * @return
     */
    public static List<Integer> chooseSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            //[未排序部分]中最小的元素的索引,默认是第一个元素
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                //找到[未排序部分]中最小的元素
                if (list.get(minIndex) > list.get(j)) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                //交换
                int temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
        return list;
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] array) {
        if (array == null) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }


    /**
     * 对[leftIndex,rightIndex]区间的数组元素分成两部分排序并合并 闭区间
     */
    public static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            //也就是[要排序的区间]中的元素大于1

            //区间的中间位置
            int middleIndex = (leftIndex + rightIndex) / 2;

            //对区间左边部分进行归并排序 middleIndex属于左边部分
            mergeSort(array, leftIndex, middleIndex);
            //对区间右边部分进行归并排序
            mergeSort(array, middleIndex + 1, rightIndex);

            //对[左右两部分的归并排序结果]进行合并
            //merge会执行log n次，而merge的时间复杂度是O(n),所以归并排序
            // 的时间复杂度是O(nlogn)
            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

    /**
     * 把[排序好的左右部分]合并 middleIndex属于左部分
     */
    private static void merge(int[] array, int leftIndex, int middleIndex,
                              int rightIndex) {

        //左边部分
        int[] leftArr = Arrays.copyOfRange(array, leftIndex, middleIndex + 1);
        //右边部分
        int[] rightArr = Arrays.copyOfRange(array, middleIndex + 1,
                rightIndex + 1);

        //将左右两部分合并
        int current = leftIndex;
        int left = 0;
        int right = 0;
        //左右2边部分都完成后就退出
        while (left < leftArr.length || right < rightArr.length) {
            //将最小的元素保存到array的current位置上
            if (left != leftArr.length &&
                    (right == rightArr.length || leftArr[left] < rightArr[right])) {
                //右边部分已经完成合并或者左边的元素更小，并且左边部分未完成合并，
                // 就把左边的元素保存到current位置
                array[current] = leftArr[left];
                left++;
            } else {
                array[current] = rightArr[right];
                right++;
            }
            current++;
        }
    }
    /** 快速排序 */
    public static void quickSort(int[] arr){
        if (arr == null) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }



    /** 快速排序 闭区间*/
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        //区间之间的元素个数大于1
        if(leftIndex < rightIndex){
            //对区间的元素进行"分割",基准值左边的都小于等于基准值，
            // 基准值右边的都大于基准值。
            int index = partition(arr, leftIndex, rightIndex);

            //对基准值左边部分进行快速排序
            quickSort(arr, leftIndex, index - 1);
            //对基准值右边部分进行快速排序
            quickSort(arr, index + 1, rightIndex);
        }
    }

    /** "分割":选择一个基准值，使基准值左边的元素都小于等于基准值，基准值右
     * 边的元素都大于基准值
     * 返回基准值的索引" */
    public static int partition(int[] arr, int leftIndex, int rightIndex) {
        //基准值为第一个元素
        int pivotIndex = leftIndex;
        //基准值
        int pivot = arr[leftIndex];

        while (leftIndex != rightIndex) {
            //一定要先移动右边指针,比如某一轮结果是：[2,1,5]，leftIndex=1,rightIndex=2。
            // 如果先移动leftIndex，leftIndex++=2。leftIndex=rightIndex结束循环。那么
            // leftIndex指向的元素就不是比[基准值]小了，不符实现逻辑

            //右边指针[想左移动]至[小于等于基准值]停下来
            while (leftIndex < rightIndex && arr[rightIndex] > pivot)
                rightIndex--;
            //左边指针[向右移动]至[大于基准值]停下来
            while (leftIndex < rightIndex && arr[leftIndex] <= pivot)
                leftIndex++;

            if (leftIndex <rightIndex) {
                //对leftIndex和rightIndex进行交换，那么每一轮结束时[leftIndex指
                // 向的值]一定[小于等于]基准值
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
        }

        //结束时让[基准指针]和[leftIndex]值交换
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        return leftIndex;
    }


    public static int binarySearch(int[] arr, int destinationValue){
        int left = 0;
        int right = arr.length;

        while (left <= right){
            int middle = (left + right) / 2;
            int middleValue = arr[middle];
            if (middleValue == destinationValue) {
                //找到目标结果
                return middle;
            }else if (middleValue > destinationValue) {
                //在右边部分查询
                left = middle + 1;
            }else{
                //在左边查询
                right = middle - 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] array = new int[]{12, 21, 35, 44, 42, 25, 11, 551, 11, 22, 22, 1, 44};
        int[] array1 = new int[]{4,7,6,5,3,2,8,1};
        quickSort(array, 0, array.length - 1);
        quickSort(array1, 0, array1.length - 1);
        for (int i : array) {
            System.out.print(i);
            System.out.print(",");
        }
    }
}
package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * @author : dengxuelong
 * @date : 2019/06/20 17:18
 */
public class _11_3_SearchInContainsNullArr {

    public static int searchInContainsNullArr(String[] arr, String value){
        if (arr == null) {
            return -1;
        }
        return searchInContainsNullArr(arr, value, 0, arr.length - 1);
    }

    private static int searchInContainsNullArr(String[] arr, String value,
                                               int left, int right){
        //要查询的区间至少有1个元素
        if (left <= right) {
            int middle = (left +right) / 2;
            if (value.equals(arr[middle])) {
                //查找到值
                return middle;
            }
            if (arr[middle].isEmpty()) {
                //中间位置的元素为空，两边都进行查找
                int i = searchInContainsNullArr(arr, value, left, middle - 1);
                int j = searchInContainsNullArr(arr, value, middle + 1, right);
                return Math.max(i, j);
            }
            if(arr[middle].compareTo(value) > 0){
                //目标值在左边
                return searchInContainsNullArr(arr, value, left, middle - 1);
            } else {
                //目标值在右边
                return searchInContainsNullArr(arr, value, middle + 1, right);
            }
        }
        return -1;
    }

    /** 值在数组中最后一次出现的位置*/
    private static int last(int[] a, int key) {
        int min = 0, max = a.length - 1;
        int mid = 0;
        while (min <= max) {
            //+1是为了避免区间只包含2个元素时，(min+max)/2=min
            // 如果取右边部分的话while循环不能退出
            mid = (max + min + 1) / 2;
            if (key >= a[mid]) {
                //相当于key>a[mid] | key=a[mid]，即使找到了值，还是会从右边部分继续查找。
                //注意右边部分是包含mid的
                min = mid;
            } else {
                max = mid - 1;
            }
            if (max == min) {
                break;
            }
        }
        if (a[max] != key) {//当查找元素不存在时，返回-1
            return -1;
        } else {
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(last(new int[]{5,5,7},5));
        System.out.println(last(new int[]{1,2,2,5,7},5));
        System.out.println(searchInContainsNullArr(new String[]{"aaa","","","ba","","bc","","","c","","","d"}, "aaa"));
        System.out.println(searchInContainsNullArr(new String[]{"aaa","","","ba","","bc","","","c","","","d"}, "d"));
        System.out.println(searchInContainsNullArr(new String[]{"aaa","","","ba","","bc","","","c","","","d"}, "bc"));
        System.out.println(searchInContainsNullArr(new String[]{"aaa","","","ba","","bc","","","c","","","d"}, "aa1"));
    }
}









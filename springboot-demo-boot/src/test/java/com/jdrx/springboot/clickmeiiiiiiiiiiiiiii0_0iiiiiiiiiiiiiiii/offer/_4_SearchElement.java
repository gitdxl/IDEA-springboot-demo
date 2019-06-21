package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

/**
 * 在一个二维数组中查找一个值是否存在
 * 二维数组中每行、每列都是顺序的
 * @author : dengxuelong
 * @date : 2019/04/08 11:22
 */
public class _4_SearchElement {

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        //查询最大值
        search(array,15);
        //查询最小值
        search(array,1);
        //查询中间某个值
        search(array,10);
        //查询某个不存在的值
        search(array,5);
        //非法参数
        search(null,11);
    }

    private static void search(int[][] array, int destinationValue){
        if (array == null || array.length == 0
                || array[0] == null || array[0].length == 0) {
            throw new RuntimeException("数组不能为空");
        }
        int rows = array.length;
        int cols = array[0].length;

        /*
        *   从右上角节点开始
        *       1  如果要查询的值大于节点值，那么就可以排除当前行,row++
        *       2  如果要查询的值小于节点值，那么就可以排除当前列,col--
        *       3  如果要查询的值等于节点值，查询成功
        */
        int col = cols - 1;
        int row = 0;
        while(row < rows && col >= 0 ){
            if(destinationValue == array[row][col]){
                //如果要查询的值等于节点值，查询成功
                System.out.printf("%d 查询成功 array[%d][%d]%n", destinationValue, row,col);
                return;
            }else if (destinationValue > array[row][col]){
                //要查询的值大于节点值，那么就可以排除当前行,row++
                row++;
            }else{
                //要查询的值小于节点值，那么就可以排除当前列,col--
                col--;
            }
        }
        System.out.println("数组中不存在该值");
    }
}










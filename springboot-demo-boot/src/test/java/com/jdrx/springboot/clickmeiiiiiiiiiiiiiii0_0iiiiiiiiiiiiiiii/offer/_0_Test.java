package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

import com.fr.function.IF;

import java.util.Iterator;

/**
 * @author : dengxuelong
 * @date : 2019/05/30 15:02
 */
public class _0_Test {
    public static void main(String[] args) {
        matchStr("112ab1","ab");
        matchStr("112ab1","dd");
        matchStr("112ab1","aa");
        matchStr("112aaacab1","aac");
        int[][] array = new int[5][7];
        test(array,0,0,0,array[0].length - 1, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void test(int[][] array, int startValue, int minCol, int minRow, int maxCol, int maxRow){
        if(minCol > maxCol || minRow >maxRow){
            return ;
        }
        //第一行
        for (int currentCol = minCol; currentCol <= maxCol; currentCol++) {
            array[minRow][currentCol] = startValue++;
        }
        //最后一列  不要重写右上角
        for (int currentRow = minRow + 1; currentRow <= maxRow; currentRow++) {
            array[currentRow][maxCol] = startValue++;
        }
        //最后一行 不要重写右下角 和 第一行
        for (int currentCol = maxCol - 1; currentCol >= minCol && minRow != maxRow; currentCol--) {
            array[maxRow][currentCol] = startValue++;
        }
        //第一列  不要重写左上角和左下角 和最后一列
        for (int currentRow = maxRow - 1; currentRow > minRow && minCol != maxCol; currentRow--) {
            array[currentRow][minCol] = startValue++;
        }
        test(array,startValue, ++minCol, ++minRow, --maxCol, --maxRow);
    }


    public static void matchStr(String srcStr, String pattern){
        //当前匹配到了pattern中的第几个字符
        int index = 0;
        for (int i = 0; i < srcStr.length(); i++) {
            if (srcStr.charAt(i) == pattern.charAt(index)){
                index++;
            } else {
                index = 0;
            }
            if (index == pattern.length()) {
                System.out.println("从 " + srcStr + " 查找到了字符串 " + pattern);
                return ;
            }
        }
        System.out.println("从 " + srcStr + " 未查找到字符串 " + pattern);
    }
}

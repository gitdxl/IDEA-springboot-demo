package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * @author : dengxuelong
 * @date : 2019/06/14 10:54
 */
public class _5_1_UnionNum {
    /** 将subNum复制到destinationNum第i位到第j位 并且j-1足够大*/
    public static int unionNum(int destinationNum, int subNum, int i, int j){
        //首先将destinationNum第i位到第j位置为0
        destinationNum = clearBits(destinationNum, i, j);
        //将subNum左移i位
        subNum = subNum << i;
        //destinationNum | subNum
        return destinationNum | subNum;
    }
    /** 清除第i位到到第j位*/
    public static int clearBits(int num, int i, int j){
        //比如清除第2位到第4位，只要得到0001 1100然后取反1110 0011，然后与num进行位与运算
        int m = 0;
        while (i <= j) {
            m = m | (1<<i);
            i++;
        }
        return num & (~m);
    }

    public static void main(String[] args) {
        System.out.println(clearBits(31, 2, 4));
        System.out.println(unionNum(31, 5, 2, 4));
    }

}
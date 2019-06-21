package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * @author : dengxuelong
 * @date : 2019/06/13 17:41
 */
public class _5_0 {

    /**
     * 获取第i位是0还是1
     * @param num
     * @param i 从右向左数，从0开是数
     * @return 0返回false  1返回true
     */
    public static boolean getBit(int num, int i){
        //错误实现：比如110 & 01 返回的是010=2 而不是1
        return (num & (1 << i)) == 1;
    }
    /** 将第i为置为1 */
    public static int setBit(int num, int i){
        return num | (1 << i);
    }

    /** 将第i位置为0 */
    public static int clearBit(int num, int i){
        //得到11101111
        int j = ~(1 << i);
        return num & j;
    }

    /** 将最高位到第i位都置为0 */
    public static int clearBits(int num, int i){
        //得到00001111
        int j = (1 << i) - 1;
        return num & j;
    }

    /** 将第i位到最低位都置为0 */
    public static int clearBits1(int num, int i){
        //得到00011111
        int j = (1 << (i + 1)) - 1;
        //得到11100000
        j = ~j;
        return num & j;
    }


    public static void main(String[] args) {
        System.out.println(1 << 1);
        System.out.println(6 & (1 << 1));
        System.out.println(getBit(6, 0));
        System.out.println(getBit(6, 1));
        System.out.println(getBit(6, 2));
        System.out.println(getBit(6, 3));
    }
}
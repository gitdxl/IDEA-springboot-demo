package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(compare(32, 321));
        System.out.println(compare(32, 323));
        System.out.println(compare(32, 329));
    }

    public static String PrintMinNumber(Integer [] numbers) {
        String getTb_name = "";
        String[] split = getTb_name.split(",");
        List<String> tbList = Arrays.asList(split);


        List<Integer> list1 = Arrays.asList(numbers);



        return "";
    }
    
    public static int compare(int i, int j){
        if(i == j){
            return 0;
        }

        int bitH1 = getBit(i);
        int bitH2 = getBit(j);

        int bit1 = bitH1;
        int bit2 = bitH2;

        //比较最高位
        while(bit1 > 0 || bit2 > 0){
            int heigh1 = bit1 <= 0 ? i % bitH1 : i % bit1;
            int heigh2 = bit2 <= 0 ? j % bitH2 : j % bit2;

            if(heigh1 < heigh2){
                return -1;
            } else if(heigh1 < heigh2){
                return 1;
            }else {
                // 相等
                bit1--;
                bit2--;



            }
        }


        return 1;
    }
    
    //获取十进制位数
    public static int getBit(int i){
        int bit = 10;
        
        while (i / bit  > 0){
            bit *= 10;
        }
        
        return bit / 10;
    }
}
package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * @author : dengxuelong
 * @date : 2019/06/14 13:34
 */
public class _5_2_DoubleToBinary {

    public static String doubleToBinary(double value){
        if (value <= 0 || value >= 1) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder("0.");

        while (value != 0){

            if (sb.length() >= 32) {
                return "ERROR";
            }


            value *= 2;

            if(value >= 1){
                sb.append("1");
                value -= 1;
            } else{
                sb.append("0");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println( "：" + doubleToBinary(0));
        System.out.println( "0.1：" + doubleToBinary(0.1));
        System.out.println( "0.375：" + doubleToBinary(0.375));
        System.out.println( "0.55：" + doubleToBinary(0.55));
    }
}
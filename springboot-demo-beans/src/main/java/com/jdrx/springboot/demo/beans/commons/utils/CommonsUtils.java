package com.jdrx.springboot.demo.beans.commons.utils;

import java.util.Random;

/**
 * Created by dengxuelong on 2017/11/13.
 */
public class CommonsUtils {
    private static String s = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    /**
     * 随机生成指定长度的数字
     * @param length
     * @return
     */
    public static String randomDigit(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 生成指定长度的字符串  (小小写混合字母)
     * @param length
     * @return
     */
    public static String createRanomString(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(s.charAt(new Random().nextInt(s.length())));
        }
        return sb.toString();
    }

    /**
     * @return 随机生成随机边界字符串  空串 空格 1个字符 256个字符
     */
    public static String createRandomBoundaryString(){
        int i = new Random().nextInt(4);
        switch (i){
            case 0:return "";
            case 1:return " ";
            case 2:return s.charAt(new Random().nextInt(s.length()))+"";
            default:
                StringBuilder sb = new StringBuilder();
                for (int i1 = 0; i1 < 256; i1++) {
                    sb.append(s.charAt(new Random().nextInt(s.length())));
                }
                return sb.toString();
        }
    }

    /**
     *  生成指定长度的字符串
     * @return
     */
    public static String createBoundaryString(int length){
        StringBuilder sb = new StringBuilder();
        for (int i1 = 0; i1 < length; i1++) {
            sb.append(s.charAt(new Random().nextInt(s.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(createBoundaryString(6));
        }
    }
}

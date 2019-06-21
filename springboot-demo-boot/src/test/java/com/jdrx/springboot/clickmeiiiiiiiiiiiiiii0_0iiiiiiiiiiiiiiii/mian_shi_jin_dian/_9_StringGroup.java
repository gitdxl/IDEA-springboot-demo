package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串，它有多少种不同组合
 * @author : dengxuelong
 * @date : 2019/06/17 16:32
 */
public class _9_StringGroup {

    public static List<String> stringGroup(String s){
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        } else {
            return stringGroup(s, s.length() - 1);
        }
    }

    private static List<String> stringGroup(String s, int n){
        if (n == 0) {
            return new ArrayList<String>(Arrays.asList(s.charAt(0)+""));
        }else {
            //当前字符(取当前末尾字符)(s.charAt(n)
            String currentStr = s.charAt(n) + "";

            //当前字符的前面字符串(s.subString(0,n)) 的排列组合
            List<String> subStringList = stringGroup(s, n - 1);

            //当前字符串的排列组合(s.subString(0,n+1))
            List<String> currentStringList = new ArrayList<>();

            //将当前字符 插入到 前面字符串的排列组合中
            for (String s1 : subStringList) {
                List<String> list = insertStr(currentStr, s1);
                currentStringList.addAll(list);
            }
            return currentStringList;
        }
    }

    /**
     * 将srcStr插入到destinationStr各个位置，所有所有插入可能
     * @param srcStr
     * @param destinationStr
     * @return
     */
    public static List<String> insertStr(String srcStr, String destinationStr){
        List<String> list = new ArrayList<>(destinationStr.length() + 1);

        for (int i = 0; i <= destinationStr.length(); i++) {
            StringBuilder s = new StringBuilder(destinationStr).insert(i, srcStr);
            list.add(s.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(stringGroup("a"));
        System.out.println(stringGroup("ab"));
        System.out.println(stringGroup("abc"));
        System.out.println(insertStr("a", "b"));
    }
}








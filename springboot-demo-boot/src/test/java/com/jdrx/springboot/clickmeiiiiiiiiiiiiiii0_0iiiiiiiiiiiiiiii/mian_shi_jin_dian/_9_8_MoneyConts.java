package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : dengxuelong
 * @date : 2019/06/18 11:33
 */
public class _9_8_MoneyConts {
    public static List<Integer> moneys = new ArrayList<>(Arrays.asList(1, 5, 10, 25));
    public static List<List<Integer>> kinds(int money){
        if (money <= 0) {
            //返回一个空数组
            return new ArrayList<>();
        } else {
            //获取money -1 有多少种可能
            List<List<Integer>> lastKinds = kinds(money - 1);
            //money 想对于money -1 就相差1，就把1加入到money-1的所有可能中
            for (List<Integer> kind : lastKinds) {
                kind.add(1);
            }
            //如果money是某个面值的整数倍
            for (Integer i : moneys) {
                if (i > 1){
                    if (money % i == 0) {
                        // money某个面值的整数倍
                        int j = money / i;
                        for (int m = 0; m < j; m++) {
                            lastKinds.add(new ArrayList<>(Arrays.asList(i)));
                        }
                    }
                }
            }
            return lastKinds;
        }
    }

    public static void main(String[] args) {
        System.out.println(kinds(5));
        System.out.println(kinds(10));
        System.out.println(kinds(15));
        System.out.println(kinds(20));
    }
}
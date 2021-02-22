package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jdrx.springboot.demo.api.User;
import org.omg.CORBA.SystemException;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by dengxuelong on 2017/11/15.
 */
 class Test {

    public int titleToNumber(String s) {
        if(s == null || s == ""){
            return 0;
        }

        int len = s.length();

        int value = 0;
        int place = 0;
        for(int i = len - 1; i >= 0; i--){
            char c = s.charAt(i);

            if(place == 0){
                value += getValue(c) ;
            }else{
//                value += getValue(c) * place * 26;
                value += getValue(c) * Math.pow(26, place);
            }

            place ++;

        }

        return value;
    }

    public int getValue(char c){
        return c - 64;
    }

    public boolean isNumberOrLetter(char c){
        return (c >= 48 && c <= 48 + 9) || (c >= 65 && c <= 65 + 25) || (c >= 97 && c <= 97 +25);
    }
    public static void main(String[] args) {
        System.out.println(new Test().titleToNumber("AAA"));
        System.out.println(new Test().getValue('A'));
    }
}
class T{
    static Integer i = 2;
    static T t = new T();
     private T(){
         i ++;
         System.out.println("instance T");
     }
}
class J{
    static J t = new J();
    static int i;
    private J(){
        i ++;
        System.out.println("instance J");
    }
}






















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
     public int i;

    /**
     * <img src="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2690594705,2277707452&fm=173&app=25&f=JPEG?w=218&h=146&s=77AA2FE31E70A1D64C4DE4020300E0D1"
     *   width="100" height="100"/>
     *   <form action="http://www.baidu.com" method="post"><p/>
     *      name:<input type="text" /> <p/>
     *      password:<input type="password"/><p/>
     *      <button type ="subbmit">提交</button>
     *   </form>
     * <ul><li style="color:red"><a href="http://www.baidu.com">a</a></li><li style="color:white">
     * @param args dfff</li><li>c</li></ul>
     * @param1 args
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println(T.i);
        System.out.println("-------");
        System.out.println(J.i);
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






















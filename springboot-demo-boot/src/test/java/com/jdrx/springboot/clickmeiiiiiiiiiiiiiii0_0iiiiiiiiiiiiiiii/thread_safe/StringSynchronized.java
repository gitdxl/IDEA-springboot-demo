package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : dengxuelong
 * @date : 2018/11/09 11:04
 */
public class StringSynchronized {

    public void say(String lock){
        synchronized (lock) {
            try {
                System.out.println("zz");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now());
        }
    }

    public static void main(String[] args) {
        class a{};
        Map<String,Object> map = new HashMap<>(4);
        map.put("a",1);
        map.put("b",1);
        map.put("c",1);
        map.put("d",1);
    }
}
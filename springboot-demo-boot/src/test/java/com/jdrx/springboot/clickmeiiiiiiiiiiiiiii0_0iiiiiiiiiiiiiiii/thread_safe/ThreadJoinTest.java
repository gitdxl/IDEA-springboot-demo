package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        MoreThanHalfNum_Solution(new int[]{1,2,2,33,1,22,2,2,2});
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i : array){
            int count = map.get(i) == null ? 0 : map.get(i);
            map.put(i, ++count  );
        }

        for(Integer key : map.keySet()){
            int count = map.get(key);
            if(count > array.length){
                return key;
            }
        }

        return 0;
    }
}

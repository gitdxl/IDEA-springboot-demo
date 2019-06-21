package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.HashSet;
import java.util.concurrent.Semaphore;

/**
 * 一个有边界的HashSet
 * @author : dengxuelong
 * @date : 2018/10/18 15:52
 */
public class BoundedHashSet {
    private HashSet<String> set = new HashSet<>();
    private Semaphore s = new Semaphore(20);

    public void add(String value) throws InterruptedException {
        s.acquire();
        set.add(value);
    }

    public void remove(String value){
        set.remove(value);
        s.release();
    }

}
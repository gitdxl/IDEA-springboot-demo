package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author : dengxuelong
 * @date : 2018/09/17 14:57
 */
public class ThreadLocalTest {
    private static final ThreadLocal threadLocal = new ThreadLocal();


    public static void main(String[] args){


    }
}
class AA{
    @Override
    public int hashCode() {
        return 11;
    }
}
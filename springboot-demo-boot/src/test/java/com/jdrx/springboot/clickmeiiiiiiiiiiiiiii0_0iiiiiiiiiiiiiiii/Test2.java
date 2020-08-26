package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : dengxuelong
 * @date : 2019/02/26 15:45
 */
public class Test2 {
    static boolean b;

    /**
     * Returns a power of two size for the given target capacity.
     * 无论cap的值为多少，把它转为2的指数幂(向上取一个最近的2的指数幂)
     */
    static final int tableSizeFor(int cap) {
        //1、cap -1  构造n个结尾1  到时再加1就得到了2的指数幂
        int n = cap - 1;
        //2、n | (n无符号右移1位)  这样【第i和第i+1个位置】上就都为1了（假设二进制表示中，第一个位置标记为i）
        n |= n >>> 1;
        //3、 n | (n无符号右移2位)  这样【第i+3和第i+4个位置】上就都为1了....以此类推 第i给位置后都将被置为1
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        //这样就得到了n个连续的结尾1，加1就得到了2的指数幂
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        return 1;
    }
    public static void main(String[] args) throws ParseException, BrokenBarrierException, InterruptedException {
        Map<String,String> map = new HashMap(2);
        map.put("","");
        map.put("a","b");

        int cap = 1;



        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2; n2.next = n3; n3.next = n4;

        ArrayList<Integer> list = printListFromTailToHead(n1);
        System.out.println();
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        reverse(listNode, arrayList);
        return arrayList;
    }

    public static void reverse (ListNode head, ArrayList<Integer> arrayList){
        if(head == null){
            return;
        }
        reverse(head.next, arrayList);

        arrayList.add(head.val);
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
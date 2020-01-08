package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.util.Map;

/**
 *
 * LRU  最近最久未使用
 * @author : dengxuelong
 * @date : 2019/07/16 16:51
 */
public class LRU<V> {
    private Map<String,LinkedNode<V>> hashMap;
    private int size;
    //双向链表的头节点
    private LinkedNode<V> head;
    //双向链表的尾节点
    private LinkedNode<V> tail;

    public V get(String key){
        if (hashMap.containsKey(key)) {
            //访问后的节点置于链表的首部
            LinkedNode<V> node = hashMap.get(key);
            node.last.next = node.next;
            node.next.last = node.last;
            node.last = null;
            node.next = head;
            return node.value;
        }else{
            return null;
        }
    }


    class LinkedNode<V>{
        private LinkedNode last;
        private LinkedNode next;
        private V value;
    }
}
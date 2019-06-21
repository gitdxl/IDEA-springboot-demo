package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 基于cas的链表
 * @author : dengxuelong
 * @date : 2019/03/25 9:53
 */
public class CasLinkedQueue<E> {
    //链表中置入一个虚拟节点(值和next都为null)，这样初始化的链表是一个稳定状态
    AtomicReference<Node<E>> tailReference =
            new AtomicReference<>(new Node<>(null, null));

    public void put(E value){
        //tail指向的节点
        Node<E> tailNode = tailReference.get();
        //如果链表是稳定状态(tail指向节点的next=null)
        if(tailNode.next == null){
            Node<E> newNode = new Node<>(value, null);
            /*
            *   1、插入新节点，链表进入中间状态
            *   这是检查再运行操作,不过cas操作能保证只会有一个线程成功。
            */
            if(tailReference.get().next.compareAndSet(null, newNode)){
                //2、让tail指向新插入的节点
                tailReference.compareAndSet(tailNode, newNode);
            }
        }
    }

    class Node<E>{
        E value;
        AtomicReference<Node<E>> next;
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = new AtomicReference<>(next);
        }
    }
}
package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * @author : dengxuelong
 * @date : 2019/06/06 15:57
 */
public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    /** 入队 */
    public void enqueue(T value){
        //新节点将添加至队尾
        Node newNode = new Node(value);
        if (head == null) {
            //如果head=null，则说明队列为空，让head和tail都指向新节点
            tail = newNode;
            head = newNode;
        } else {
            //否则让tail指向新节点
            tail = newNode;
        }
    }
    /** 出队 */
    public T dequeue(){
        //弹出队首节点
        if (head != null) {
            T value = head.value;
            head = head.next;
            return value;
        } else {
            return null;
        }
    }
}
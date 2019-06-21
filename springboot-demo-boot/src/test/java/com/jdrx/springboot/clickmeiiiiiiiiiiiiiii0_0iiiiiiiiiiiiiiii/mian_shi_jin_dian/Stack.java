package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * 栈
 * 栈和链表本质上是一样的，只是用户只能看到栈顶元素
 * @author : dengxuelong
 * @date : 2019/06/06 14:44
 */
public class Stack<T> {
    //栈顶节点
    private Node<T> top;

    /** 添加元素 */
    public void push(T value){
        Node node = new Node(value);
        //将新节点置于栈顶
        node.next = top;
        top = node;
    }

    /** 弹出元素 */
    public T pop(){
        //返回栈顶元素的值
        if (top != null) {
            T value = top.value;
            top = top.next;
            return value;
        }
        return null;
    }

    /** 返回栈顶元素的值 */
    public T peek(){
        //返回栈顶元素的值
        if (top != null) {
            T value = top.value;
            return value;
        }
        return null;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
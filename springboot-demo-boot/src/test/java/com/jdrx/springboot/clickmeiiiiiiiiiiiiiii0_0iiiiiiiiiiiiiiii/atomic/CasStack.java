package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.atomic;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 基于CAS的栈实现
 * @author : dengxuelong
 * @date : 2019/03/22 14:01
 */
public class CasStack<E> {
    //栈顶元素
    private AtomicReference<Node<E>> topNode;
    //入栈
    private void put(E value){
        //当前栈顶元素
        Node<E> oldTopNode = topNode.get();
        //新栈顶元素
        Node<E> newNode = new Node<>(value, oldTopNode);
        while (true) {
            if(topNode.compareAndSet(oldTopNode, newNode)){
                //修改成功  退出
                break;
            }else{
                //修改失败 获取最新的栈顶节点并重试
                oldTopNode = topNode.get();
                newNode = new Node<>(value, oldTopNode);
            }
        }
    }
    //出栈
    private Node<E> take(){
        //当前栈顶元素
        Node<E> oldTopNode = topNode.get();
        //新的栈顶元素
        Node<E> newNode = oldTopNode.next;
        while (true){
            if (topNode.compareAndSet(oldTopNode, newNode)) {
                //修改成功  退出
                oldTopNode.next = null;
                return oldTopNode;
            }else{
                //修改失败 获取最新的栈顶节点并重试
                oldTopNode = topNode.get();
                newNode = oldTopNode.next;
            }
        }
    }

    class Node<E>{
        private E value;
        private Node<E> next;
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public CasStack(AtomicReference<Node<E>> topNode) {
        this.topNode = topNode;
    }

}
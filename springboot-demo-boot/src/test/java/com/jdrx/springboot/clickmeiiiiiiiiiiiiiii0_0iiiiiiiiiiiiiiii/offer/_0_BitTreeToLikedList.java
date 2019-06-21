package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.TreeNode;

/**
 * 二叉树 -》 双向链表
 * @author : dengxuelong
 * @date : 2019/05/29 13:28
 */
public class _0_BitTreeToLikedList {
    public static void main(String[] args) throws CloneNotSupportedException {
        _0_BitTreeToLikedList o = new _0_BitTreeToLikedList();
        o.clone();
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r1.left = r2;
        r1.right = r3;
        r3.right = r5;
        r5.left = r4;

        LinkedListNode firstNode = bitTreeToLikedList(r1);
        while (firstNode != null) {
            System.out.println(firstNode.value);
            firstNode = firstNode.next;
        }
    }
    /** 二叉树 -》 双向链表*/
    public static LinkedListNode bitTreeToLikedList(TreeNode<Integer> root){
        if (root == null) {
            return null;
        }
        //链表当前节点
        LinkedListNode currentNode = new LinkedListNode(root.value);

        //链表上一个节点  左子树生成一个链表 （因为左子树的值都小于当前节点
        //          所以左子树生成的链表值都小于当前节点）
        LinkedListNode lastNode = bitTreeToLikedList(root.left);
        //链表下一个节点  右子树生成一个链表
        LinkedListNode nextNode = bitTreeToLikedList(root.right);

        currentNode.next = nextNode;
        currentNode.last = lastNode;
        if (nextNode != null) {
            nextNode.last = currentNode;
        }
        //优先返回lastNode(上一个节点)
        if (lastNode != null) {
            lastNode.next = currentNode;
            return lastNode;
        }else {
            return currentNode;
        }
    }
}

/** 双向链表节点 */
class LinkedListNode{
    /** 前一个节点*/
    LinkedListNode last;
    /** 后一个节点*/
    LinkedListNode next;
    int value;

    public LinkedListNode(int value) {
        this.value = value;
    }

    public LinkedListNode getLast() {
        return last;
    }

    public void setLast(LinkedListNode last) {
        this.last = last;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }


}
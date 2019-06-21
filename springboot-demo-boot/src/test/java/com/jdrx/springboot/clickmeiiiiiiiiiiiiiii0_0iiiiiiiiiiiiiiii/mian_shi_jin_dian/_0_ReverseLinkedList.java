package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * 反转链表
 * @author : dengxuelong
 * @date : 2019/06/04 13:59
 */
public class _0_ReverseLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node node = reverseLinkedList(node1);
        System.out.println(1);
    }

    public static Node reverseLinkedList(Node head){
        //前一个节点
        Node preNode = null;
        //当前节点
        Node currentNode = head;

        while (currentNode != null) {
            //当前节点的下一个节点
            Node next = currentNode.next;
            //让当前节点指向前一个节点
            currentNode.next = preNode;

            preNode = currentNode;
            currentNode = next;
        }
        return preNode;
    }
}


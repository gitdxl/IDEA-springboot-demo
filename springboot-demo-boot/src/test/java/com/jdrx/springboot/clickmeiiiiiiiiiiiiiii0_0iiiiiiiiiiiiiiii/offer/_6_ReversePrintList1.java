package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

/**
 * @author : dengxuelong
 * @date : 2019/04/09 17:21
 */
public class _6_ReversePrintList1 {
    public static void main(String[] args) {
        Node n1 = new Node(1,null);
        Node n2 = new Node(2,n1);
        Node n3 = new Node(3,n2);
        Node n4 = new Node(4,n3);
        Node n5 = new Node(5,n4);
        Node n6 = new Node(6,n5);
        reversePrintList(n6);
        reversePrintList(null);
    }


    private static void reversePrintList(Node headNode){
        if (headNode == null) {
            throw new RuntimeException("参数异常");
        }
        if(headNode.next != null){
            reversePrintList(headNode.next);
        }
        //打印节点值
        System.out.println(headNode.value);
    }
}

class Node{
    int value ;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
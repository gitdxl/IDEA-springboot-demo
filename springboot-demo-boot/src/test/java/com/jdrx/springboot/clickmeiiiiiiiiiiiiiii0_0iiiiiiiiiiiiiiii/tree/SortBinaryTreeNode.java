package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.tree;

/**
 * 二叉排序树 节点
 */
public class SortBinaryTreeNode {
    Integer value;
    SortBinaryTreeNode left;
    SortBinaryTreeNode right;

    public SortBinaryTreeNode(Integer value) {
        this.value = value;
    }

    /** insert*/
    public static void insert(SortBinaryTreeNode targetNode, SortBinaryTreeNode root){
        if (root == null) {
            root = targetNode;
        }else if (targetNode.value >= root.value) {
            if (root.right == null) {
                root.right = targetNode;
            }else{
                insert(targetNode,root.right);
            }
        }else{
            //targetNode.value < root.value
            if (root.left == null) {
                root.left = targetNode;
            }else{
                insert(targetNode,root.left);
            }
        }
    }

    /** 查找*/
    public static SortBinaryTreeNode search(Integer targetValue,SortBinaryTreeNode root){
        if (root.value.equals(targetValue)) {
            return root;
        }else if (targetValue < root.value){
            return root.left == null ? null : search(targetValue,root.left);
        }else{
            return root.right == null ? null : search(targetValue,root.right);
        }
    }

    /**删除*/
    public static SortBinaryTreeNode remove(Integer targetValue, SortBinaryTreeNode root){
        if (targetValue.equals(root.value)) {
            //删除当前节点
            if (root.left != null && root.right != null) {
                //具有2个子节点、用右子树的最小值
                SortBinaryTreeNode minNode = getMinNode(root.right);
                //删除右子树的最小节点，并返回删除最小节点后的根节点
                minNode.right = removeMinNode(root.right);
                minNode.left = root.left;
                root.left = null;
                root.right = null;
                return minNode;
            }
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null & root.right != null) {
                return root.right;
            }
            if (root.left != null & root.right == null) {
                return root.left;
            }
            return null;
        }else if(targetValue >= root.value){
            root.right = remove(targetValue,root.right);
            return root;
        }else if(targetValue < root.value) {
            root.left = remove(targetValue,root.left);
            return root;
        }else {
            return null;
        }
    }

    /**获取值最小的节点*/
    public static SortBinaryTreeNode getMinNode(SortBinaryTreeNode root){
        if (root.left == null) {
            return root;
        }else{
            return getMinNode(root.left);
        }
    }

    /** &&&&&*/
    /**删除最小节点 并返回删除最小节点后树的根节点*/
    public static SortBinaryTreeNode removeMinNode(SortBinaryTreeNode root){
        if (root.left == null) {
            //左子树为null，删除根节点，右节点为 新树 的根节点
            SortBinaryTreeNode newRoot = root.right;
            root.right = null;
            root = newRoot;
        }else {
            root.left = removeMinNode(root.left);
        }
        return root;
    }

    /**遍历*/
    public static void iterate(SortBinaryTreeNode root){
        if (root == null) {
            return;
        }else {
            System.out.println(root.value);
        }
        iterate(root.left);
        iterate(root.right);
    }

    public static void main(String[] args) {
        SortBinaryTreeNode root = new SortBinaryTreeNode(3);
        SortBinaryTreeNode n1 = new SortBinaryTreeNode(5);
        SortBinaryTreeNode n2 = new SortBinaryTreeNode(11);
        SortBinaryTreeNode n3 = new SortBinaryTreeNode(1);
        SortBinaryTreeNode n4 = new SortBinaryTreeNode(77);
        insert(n1,root);
        insert(n2,root);
        insert(n3,root);
        insert(n4,root);
        iterate(root);
        SortBinaryTreeNode result = search(717, root);
        SortBinaryTreeNode minNode = getMinNode(root);
        SortBinaryTreeNode result1 = remove(1,root);
    }
}

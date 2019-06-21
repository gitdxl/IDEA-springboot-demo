package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import sun.reflect.generics.tree.Tree;

/**
 * @author : dengxuelong
 * @date : 2019/06/13 16:24
 */
public class _4_9_FindSumPath {


    //树的高度
    public static int depth(TreeNode<Integer> root){
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }

    public static void findSum(TreeNode<Integer> node, int sum, int[] path, int level){
        if (node == null) {
            return;
        }
        path[level] = node.value;

        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += path[level];
            if(t == sum){
                System.out.println(path);
            }
        }

        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);

        path[level] = Integer.MIN_VALUE;
    }

    public static void findSum(TreeNode<Integer> node, int sum){
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }


    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(1);
        TreeNode<Integer> node3 = new TreeNode<>(2);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        node2.left = node1;
        node2.right = node3;
        node3.right = node5;
        node3.left = node4;

        findSum(node2, 11);
        findSum(node2, 6);


    }
}







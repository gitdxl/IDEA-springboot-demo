package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * @author : dengxuelong
 * @date : 2019/06/13 14:42
 */
public class _4_8_IsSameTree {
    public static boolean isSame(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if (root1 == null && root2 == null) {
            //节点都等于空
            return true;
        } else if (root1 == null || root2 == null){
            //有一个节点为空
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        //只要有1个节点返回了false，这个方法就会返回false
        return isSame(root1.left,root2.left) && isSame(root1.right, root2.right);
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
        System.out.println(isSame(node1, node1));
        System.out.println(isSame(node1, node2));
        System.out.println(isSame(node2, node2));
    }
}
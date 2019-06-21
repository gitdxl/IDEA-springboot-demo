package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * @author : dengxuelong
 * @date : 2019/06/10 16:23
 */
public class _4_1_BalanceTree {

    public static boolean isBalanceTree(TreeNode<Integer> root){
        if (root == null) {
            return true;
        }
        //左节点是否满
        boolean leftIsBalance = isBalanceTree(root.left);
        //右节点是否满
        boolean rightIsBalance = isBalanceTree(root.right);

        boolean currentNodeIsBalance = true;
        if ((root.left != null && root.right == null ) ||
                (root.left == null && root.right != null )) {
            //只存在左节点或右节点时【当前节点视为"不满"】
            currentNodeIsBalance = false;
        }
        if ((!currentNodeIsBalance && !leftIsBalance) ||
                (!currentNodeIsBalance && !rightIsBalance)) {
            //当前节点"不满"，并且左节点或右节点也"不满"时视作"二叉树为非平衡的"
            System.out.println("非平衡二叉树");
            throw new RuntimeException("非平衡二叉树");
        }
        return currentNodeIsBalance;
    }

    /** 节点的高度 */
    public static int getHeight(TreeNode<Integer> root){
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left),
                getHeight(root.right)) + 1;
    }

    public static boolean isBalance1(TreeNode<Integer> root){
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalance1(root.left) && isBalance1(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node5;
        System.out.println(getHeight(node1));
        isBalanceTree(node1);

        System.out.println(isBalance1(node1));
    }
}
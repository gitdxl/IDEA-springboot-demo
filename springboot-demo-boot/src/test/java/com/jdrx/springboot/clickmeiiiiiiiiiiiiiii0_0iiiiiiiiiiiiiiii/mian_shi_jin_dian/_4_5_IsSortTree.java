package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import com.fr.third.org.apache.poi.hssf.record.formula.functions.False;
import sun.reflect.generics.tree.Tree;

/**
 * 二叉树是否是 排序二叉树
 * @author : dengxuelong
 * @date : 2019/06/12 17:53
 */
public class _4_5_IsSortTree {
    public static boolean isSortTree(TreeNode<Integer> root){
        if (root == null) {
            return true;
        }
        TreeNode<Integer> leftNode = root.left;
        TreeNode<Integer> rightNode = root.right;
        //错误实现：错误理解了二叉排序树的定义，应该是左子树的所有节点均小
        //  于等于根节点，而不是只要左节点小于等于根节点就是二叉排序树
        if ((leftNode == null || leftNode.value <= root.value) &&
                (rightNode == null || root.value < rightNode.value) ) {
            //只要有1个节点返回了false，那么这个方法就会返回false;
            return isSortTree(leftNode) && isSortTree(rightNode);
        } else {
            //只要不满足 left <= middle < right就返回false
            return false;
        }
    }

    //上一个遍历结果
    private static Integer lastValue = Integer.MIN_VALUE;
    /** 二叉排序树中序遍历得到一个升序遍历，并且假设树中节点值各不相同 */
    public static void isSortTree1(TreeNode<Integer> root){
        if (root == null) {
            return ;
        }

        //遍历左子树
        isSortTree1(root.left);
        //当前节点的值
        Integer currentValue = root.value;

        //中序遍历 得到一个升序的结果，如果当前节点<上一个遍
        //    历结果说明不是升序的，即不是二叉排序树
        if(currentValue < lastValue){
            throw new RuntimeException("非二叉排序树");
        }
        //上一个遍历结果为当前节点值
        lastValue = currentValue;

        //开始遍历右子树
        isSortTree1(root.right);
    }
    // zzzzz
    public static Integer isSortTree3(TreeNode<Integer> root, boolean isMax){
        if (root == null) {
            return null;
        }
        Integer currentValue = root.value;

        //获取左子树的最大值
        Integer leftMaxValue = isSortTree3(root.left, true);

        if (leftMaxValue != null && leftMaxValue > currentValue) {
            //如果根节点小于左子树的最大值，说明不是二叉排序树
            throw new RuntimeException("非二叉排序树");
        }

        //获取右子树的最小值
        Integer rightMaxValue = isSortTree3(root.right, false);
        if (rightMaxValue != null && rightMaxValue <= currentValue) {
            //如果根节点大于等于右子树的最小值，说明不是二叉排序树
            throw new RuntimeException("非二叉排序树");
        }
        if (isMax) {
            //返回最大值，最大值优先取右节点
            return root.right == null ? currentValue : isSortTree3(root.right, true);
        } else{
            //返回最小值，最小值优先取左节点最小值
            return root.left == null ? currentValue : isSortTree3(root.left, false);
        }
    }

    public static boolean isSortTree4(TreeNode<Integer> root, int minValue, int maxValue){
        if (root == null) {
            return true;
        }
        Integer currentValue = root.value;
        if(currentValue < minValue || currentValue >= maxValue){
            return false;
        }
        return isSortTree4(root.left, minValue, currentValue) &&
                isSortTree4(root.right, currentValue, maxValue);
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

        System.out.println("" + isSortTree(node2));
        isSortTree3(node2, false);
    }



}
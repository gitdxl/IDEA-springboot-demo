package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer._7_TreeTraverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个排好序的数组，数组值唯一，使用它构建一个高度最小的二叉排序树
 * @author : dengxuelong
 * @date : 2019/06/12 15:27
 */
public class _4_3_MinSortTreeWithArray {

    public static TreeNode<Integer> arrayToSortTree(List<Integer> list){
        if (list == null || list.size() == 0) {
            return null;
        }
        int middleIndex = list.size() / 2;

        TreeNode<Integer> rootNode = new TreeNode<>(list.get(middleIndex));

        //左子数组
        List<Integer> leftList = list.subList(0, middleIndex);
        //构建左子树
        TreeNode<Integer> leftTreeNode = arrayToSortTree(leftList);

        //右子数组
        List<Integer> rightList = list.subList(middleIndex + 1, list.size());
        //构建右子树
        TreeNode<Integer> rightTreeNode = arrayToSortTree(rightList);

        rootNode.left = leftTreeNode;
        rootNode.right = rightTreeNode;

        return rootNode;
    }


    private static TreeNode<Integer> arrayToSortTree(int[] array, int startIndex, int endIndex){
        if (startIndex > endIndex) {
            return null;
        }
        int middleIndex = (startIndex + endIndex) / 2;

        TreeNode<Integer> rootNode = new TreeNode<>(array[middleIndex]);

        TreeNode<Integer> leftNode = arrayToSortTree(array, startIndex, middleIndex - 1);
        TreeNode<Integer> rightNode = arrayToSortTree(array, middleIndex + 1, endIndex);

        rootNode.left = leftNode;
        rootNode.right = rightNode;

        return rootNode;
    }
    public static TreeNode<Integer> arrayToSortTree(int[] array){
        if (array == null) {
            return null;
        }
        return arrayToSortTree(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        TreeNode<Integer> root = arrayToSortTree(list);
        _7_TreeTraverse.breadthTraverse(root);

        System.out.println("-----------");

        int[] array = new int[]{1,2,3,4,5};
        TreeNode<Integer> root1 = arrayToSortTree(array);
        _7_TreeTraverse.breadthTraverse(root1);
    }
}









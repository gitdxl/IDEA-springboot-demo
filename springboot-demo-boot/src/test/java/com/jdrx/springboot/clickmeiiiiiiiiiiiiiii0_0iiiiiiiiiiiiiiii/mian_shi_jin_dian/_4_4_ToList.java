package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer._7_TreeTraverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 创建 二叉树某一深度上 所有节点的链表
 * @author : dengxuelong
 * @date : 2019/06/12 16:36
 */
public class _4_4_ToList {
    private static void toList(TreeNode<Integer> root, List<Integer> returnList,
                               int destinationLevel, int currentLevel){

        if (root == null) {
            return ;
        }

        //如果目标层级等于当前节点的层级
        if (currentLevel == destinationLevel) {
            returnList.add(root.value);
        }
        ++currentLevel;
        toList(root.left, returnList, destinationLevel, currentLevel);
        toList(root.right, returnList, destinationLevel, currentLevel);
    }

    public static List<Integer> toList(TreeNode<Integer> root,
                                       int destinationLevel){

        List<Integer> returnList = new LinkedList<>();
        toList(root, returnList, destinationLevel, 1);
        return returnList;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        TreeNode<Integer> root = _4_3_MinSortTreeWithArray.arrayToSortTree(list);
        _7_TreeTraverse.breadthTraverse(root);

        System.out.println(toList(root, 1));
        System.out.println(toList(root, 2));
        System.out.println(toList(root, 3));
    }
}
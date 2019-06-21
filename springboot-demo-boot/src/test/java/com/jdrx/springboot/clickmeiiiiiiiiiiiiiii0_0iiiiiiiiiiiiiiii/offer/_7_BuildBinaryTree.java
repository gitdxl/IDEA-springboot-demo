package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据前序遍历和中序遍历 重构二叉树
 * @author : dengxuelong
 * @date : 2019/05/20 14:40
 */
public class _7_BuildBinaryTree {
    public static void main(String[] args) {
        //测试。。。
        System.out.println("正常二叉树---");
        _7_TreeTraverse.backTraverse1(buildBinaryTree(new ArrayList<>(Arrays.asList(1,2,4,7,3,5,6,8)),
                new ArrayList<>(Arrays.asList(4,7,2,1,5,3,8,6))));

        System.out.println("只有左子树---");
        _7_TreeTraverse.backTraverse1(buildBinaryTree(new ArrayList<>(Arrays.asList(1,2,4)),
                new ArrayList<>(Arrays.asList(4,2,1))));

        System.out.println("只有右子树---");
        _7_TreeTraverse.backTraverse1(buildBinaryTree(new ArrayList<>(Arrays.asList(1,3,6)),
                new ArrayList<>(Arrays.asList(1,3,6))));

        System.out.println("只有根节点---");
        _7_TreeTraverse.backTraverse1(buildBinaryTree(new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(1))));
    }

    /**
     * 根据前序遍历和中序遍历 重构二叉树
     * @param preorder  前序遍历
     * @param inorder  中序遍历
     * @return  根节点
     */
    public static TreeNode buildBinaryTree(List<Integer> preorder, List<Integer> inorder){
        if (preorder == null || preorder.size() == 0 || inorder == null ||
                inorder.size() == 0 || preorder.size() != inorder.size()) {
            return null;
        }
        //根节点值
        int rootValue = preorder.get(0);
        TreeNode rootNode = new TreeNode(rootValue);

        //根节点在中序遍历中的位置
        int rootValueIndex = inorder.indexOf(rootValue);

        //左子树前序遍历
        List<Integer> leftPreOrder = preorder.subList(1, rootValueIndex + 1);
        //右子树前序遍历
        List<Integer> rightPreOrder = preorder.subList(rootValueIndex + 1, preorder.size());

        //左子树中序遍历
        List<Integer> leftInOrder = inorder.subList(0, rootValueIndex);
        //右子树中序遍历
        List<Integer> rightInOrder = inorder.subList(rootValueIndex + 1, inorder.size());

        //构建左子树
        TreeNode leftRootNode = buildBinaryTree(leftPreOrder, leftInOrder);
        //构建右子树
        TreeNode rightRootNode = buildBinaryTree(rightPreOrder, rightInOrder);

        rootNode.left = leftRootNode;
        rootNode.right = rightRootNode;
        return rootNode;
    }
}








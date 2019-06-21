package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.TreeNode;

import java.util.*;

/**
 * 二叉树遍历
 *
 * @author : dengxuelong
 * @date : 2019/04/16 17:48
 */
public class _7_TreeTraverse {

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r1.left = r2;
        r1.right = r3;
        r3.right = r4;
        r4.left = r5;

        breadthTraverse(r1);
        System.out.println("-----------");
        breadthTraverse1(r1);
//        middleTraverse(r1);

    }

    /**
     * 后序遍历
     */
    public static void backTraverse(TreeNode root) {
        if (root != null) {
            backTraverse(root.left);
            backTraverse(root.right);
            System.out.println(root.value);
        }
    }

    /**
     * 前序遍历  非递归
     */
    public static void backTraverse1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                //当前节点不为null 遍历左子树
                System.out.println(currentNode.value);
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                //当前节点为null 弹出栈中的节点  弹出的节点是当前节点的父节点
                //遍历父节点的右子树
                TreeNode parentNode = stack.pop();
                currentNode = parentNode.right;
            }
        }
    }

    /**
     * 中序遍历
     */
    public static void middleTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        middleTraverse(root.left);

        System.out.println(root.value);

        middleTraverse(root.right);

    }

    /**
     * 广度优先遍历
     * @param root
     */
    public static void breadthTraverse(TreeNode<Integer> root){
        if (root == null) {
            return;
        }
        //实现核心，利用队列的先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode != null) {
                System.out.println(currentNode.value);
                //把左右节点都加入到队列中
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
    }

    /**
     * 广度优先遍历
     * @param root
     */
    public static void breadthTraverse1(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        //当前层的所有节点
        List<TreeNode<Integer>> currentLevelNodes =
                new ArrayList<>();

        currentLevelNodes.add(root);
        while (currentLevelNodes.size() != 0) {
            //下一层的所有节点
            List<TreeNode<Integer>> nextLevelNodes =
                    new ArrayList<>();

            //遍历当前层的所有节点
            for (TreeNode<Integer> currentNode : currentLevelNodes) {
                System.out.println(currentNode.value);
                //把子节点加入到下一层中
                if (currentNode.left != null) {
                    nextLevelNodes.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevelNodes.add(currentNode.right);
                }
            }

            //遍历下一层
            currentLevelNodes = nextLevelNodes;
        }


    }
}


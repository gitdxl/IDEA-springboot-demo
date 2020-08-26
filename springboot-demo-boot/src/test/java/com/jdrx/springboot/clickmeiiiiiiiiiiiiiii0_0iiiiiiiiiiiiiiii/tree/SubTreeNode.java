package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.tree;

import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.TreeNode;
import sun.misc.Unsafe;

import java.util.LinkedList;

/**
 * 判断A是否是B的子树
 */
public class SubTreeNode {

    public static void main(String[] args) {
        Unsafe unsafe = Unsafe.getUnsafe();
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> root1 = new TreeNode<>(3);
        TreeNode<Integer> root2 = new TreeNode<>(4);
        root.left = root1;
        root.right = root2;

        TreeNode<Integer> root3 = new TreeNode<>(13);
        root1.left = root3;

        TreeNode<Integer> root4 = new TreeNode<>(11);
        root3.left = root4;
        TreeNode<Integer> root5 = new TreeNode<>(144);
        root3.right = root5;

        System.out.println(isSubTree(root, root));
        System.out.println(isSubTree(root, root1));
        System.out.println(isSubTree(root, root2));
        System.out.println(isSubTree(root, root3));


        TreeNode<Integer> root222 = new TreeNode<>(1444);
        TreeNode<Integer> root2221 = new TreeNode<>(1);
        root222.left = root2221;
        System.out.println(isSubTree(root, root222));
    }


    //遍历A树，判断当前树和B树是否相等
    public static boolean isSubTree(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1 == null || root2 == null){
            return false;
        }

        //while 这里不想使用递归
        LinkedList<TreeNode<Integer>> nodes = new LinkedList<>();
        nodes.add(root1);

        while (!nodes.isEmpty()) {
            TreeNode<Integer> currentNode = nodes.pop();

            //判断是否是同一棵树
            boolean isEqualsTree = equals(currentNode, root2);
            if(isEqualsTree){
                //当前A树和B树完全一样，返回true
                return true;
            } else {
                //遍历左右子树

                if(currentNode.left != null){
                    nodes.add(currentNode.left);
                }
                if(currentNode.right != null){
                    nodes.add(currentNode.right);
                }
            }
        }
        return false;
    }

    //同时遍历左右子树

    /**
     * 两棵树是否相等
     * @param root1
     * @param root2
     * @return
     */
    public static boolean equals(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1 == null && root2 == null) {
            //都是空树，也算作他们是相等的
            return true;
        }

        if(root1 == null || root2 == null){
            //有一个是空树，不相等。
            return false;
        }

        if(root1.value.equals(root2.value)){
            //当前节点值相等，判断左右子树是否相等
            return equals(root1.left, root2.left) && equals(root1.right, root2.right);
        }
        //值不相等
        return false;

    }

}








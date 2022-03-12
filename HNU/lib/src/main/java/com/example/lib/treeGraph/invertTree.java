package com.example.lib.treeGraph;

import com.example.lib.StackQueue.Queue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Create by chenlong.wang
 * 翻转一棵二叉树。
 * on 2020/9/7
 */
public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            invertTree(root.left);
        }
        if(root.right!=null){
            invertTree(root.right);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


    private static void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    /**
     * 非递归实现。
     *
     * @param root
     */
    public static void stackRevert(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            swap(current);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

    }



}

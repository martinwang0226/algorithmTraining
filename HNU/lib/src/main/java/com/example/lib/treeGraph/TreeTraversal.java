package com.example.lib.treeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * <description>
 * 树的遍历
 * 分为深度遍历和层序遍历
 * 都是递归写法
 *
 * @author habo
 * @date 2020/3/21
 */
public class TreeTraversal {

    //全局变量
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归终止条件，root 为 null 则遍历结束
        if (root == null) {
            return list;
        }
        // 前序遍历添加顺序：root--root.left--root.right
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return list;
        }
        preorderTraversal(root.left);
        list.add(root.val);
        preorderTraversal(root.right);
        return list;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        // 递归终止条件，root 为 null 则遍历结束
        if (root == null) {
            return list;
        }

        preorderTraversal(root.left);
        preorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        // 递归终止条件，root 为 null 则遍历结束
        if (root == null) {
            return;
        }
        // 根据 level 以及集合的大小判断是否需要加入新的层级，也就是新的的 List
        if (level >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        // 向下一个 level 中的左树进行遍历
        dfs(res, root.left, level + 1);
        // 向下一个 level 中的左树进行遍历
        dfs(res, root.right, level + 1);
    }

    /**
     * 非递归实现
     */

    //全局变量
    List<Integer> list2 = new ArrayList<>();

    // 用非递归的方法进行先序遍历
    public void qinaxuFeiDigui(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                list2.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    // 用非递归的方法进行中序遍历
    public void zhongxuFeiDigui(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                list2.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }

    // 用非递归的方法进行后序遍历
    public void houxuFeiDigui(TreeNode treeNode) {
        TreeNode cur, pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                list2.add(treeNode.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    public void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list2.add(root.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


}

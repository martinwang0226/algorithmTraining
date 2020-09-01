package com.example.lib.treeGraph;

/**
 * Create by chenlong.wang
 * 4.9　给定一棵二叉树，其中每个结点都含有一个数值。设计一个算法，打印结点数值总和等于某个给定值的所有路径。注意，路径不一定非得从二叉树的根结点或叶结点开始或结束。（第54页）
 * Gayle Laakmann McDowell. 程序员面试金典（第5版） (p. 161). 人民邮电出版社. Kindle 版本.
 * on 2020/9/1
 */
public class findSum {

    public static void main(String[] args) {

    }

    public void findSum(TreeNode node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }
        //将当前节点插入路径
        path[level] = node.val;

        //查找以此为终点且总和为sum的路径
        int t = 0;
        for (int i = level; i >= 0; i--) {
            t = t + path[i];
            if (t == sum) {
                print(path, i, level);
            }
        }

        //查找此节点之下的节点
        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);

        path[level] = Integer.MIN_VALUE;


    }

    public void findSum(TreeNode node, int sum) {
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }

    public static void print(int[] path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + "");
        }
    }
}

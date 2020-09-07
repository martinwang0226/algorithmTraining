package com.example.lib.treeGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by chenlong.wang
 * 二叉树的左视图
 * on 2020/9/4
 */
public class LeftView {
    static void LeftView(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        //设置 size 和 child 两个标记，child在循环中会变，size不会变，作为循环条件
        //第一层只有根节点1个，所以size = 1
        int size = 1;
        //记录孩子数
        int child;
        while (!queue.isEmpty()) {
            //初始化孩子数为 0
            child = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue.poll();
                // i = 0,说明是该层第一个结点
                if (i == 0) {
                    System.out.println(node1.val);
                }
                if (node1.left != null) {
                    queue.offer(node1.left);
                    child++;
                }
                if (node1.right != null) {
                    queue.offer(node1.right);
                    child++;
                }
            }
            size = child;
        }

    }
}

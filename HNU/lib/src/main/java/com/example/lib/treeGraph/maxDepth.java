package com.example.lib.treeGraph;

/**
 * Create by chenlong.wang
 * on 2020/9/7
 * 二叉树最大深度
 */
public class maxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}

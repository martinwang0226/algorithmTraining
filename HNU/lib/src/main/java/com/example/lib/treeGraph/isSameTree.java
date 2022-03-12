package com.example.lib.treeGraph;

/**
 * Create by chenlong.wang
 * on 2020/9/16
 * 判断两棵树是否相同
 */
public class isSameTree {
    public boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {//若两棵树均为空
            return true;
        } else if (tree1 == null || tree2 == null) {//若两棵树有一方为空
            return false;
        }
        if (tree1 != null && tree2 != null) {
            if (tree1.val != tree2.val) {
                return false;
            } else {
                return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
            }
        }
        return false;
    }
}

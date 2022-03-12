package com.example.lib.treeGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by chenlong.wang
 * 4.5　实现一个函数，检查一棵二叉树是否为二叉查找树。（第54页）
 * <p>
 * Gayle Laakmann McDowell. 程序员面试金典（第5版） (p. 151). 人民邮电出版社. Kindle 版本.
 * on 2020/9/1
 */
public class checkBST {

    /**
     * 解法1，中序遍历
     * 假定这棵树不包含重复值
     */

    public static void main(String[] args) {

    }

    public static int last_printed = Integer.MIN_VALUE;

    /**
     * 二叉搜索树中序遍历严格递增
     *
     * @param n
     * @return
     */
    public static boolean checkBST(TreeNode n) {

        if (n == null) {
            return true;
        }
        //递归检查左子树
        if (!checkBST(n.left)) {
            return false;
        }

        //检查当前节点
        if (n.val <= last_printed) {
            return false;
        }

        last_printed = n.val;

        //递归检查右子树
        if (!checkBST(n.right)) {
            return false;
        }
        return true;
    }

    /**
     * 解答2
     * 最小/最大法
     * 也是利用了递归的思想，分别对每一个子树进行判断，但是它的亮点在于在判断的时候并不需要对子树进行搜索“最相近的值”，而是利用了“最大值”、“最小值”的思想：
     *
     * 对于每个子树，都有一个最大值和一个最小值，
     *
     * 对于左子树，最大值就是它的根节点的值，最小值是根节点的最小值（左父亲或者MIN_VALUE）
     *
     * 对于右子树，最小值就是它的根节点的值，最大值是根节点的最大值（右父亲或者MAX_VALUE）
     */
    public static boolean checkBST2(TreeNode n) {
        return checkBST2(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean checkBST2(TreeNode n, int min, int max) {
        if (n == null) {
            return true;
        }
        if (n.val < min || n.val >= max) {
            return false;
        }

        if (!checkBST2(n.left, min, n.val) || !checkBST2(n.right, n.val, max)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1))
                return false;
        }

        return true;
    }

    //中序遍历
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }


}

package com.example.lib.treeGraph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Create by chenlong.wang
 * 4.4　给定一棵二叉树，设计一个算法，创建含有某一深度上所有结点的链表（比如，若一棵树的深度为D，则会创建出D个链表）。（第54页）
 * <p>
 * Gayle Laakmann McDowell. 程序员面试金典（第5版） (p. 150). 人民邮电出版社. Kindle 版本.
 * on 2020/9/2
 */
public class createLevelLinkedList {

    public static void main(String[] args) {

    }

    /**
     * 将前序遍历修改，将level +1 传入下一个递归调用，深度优先搜索
     *
     * @param root
     * @param lists
     * @param level
     */
    public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = null;
        if (list.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        list.add(root);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    /**
     * 广度优先搜索稍作修改，从根节点开始迭代，然后第二层、第三层
     * 处于第i层，表明我们已经访问过第i-1层的所有节点
     * 也就是说，要得到i层的节点，只需直接查看第i-1层节点的所有子节点即可
     */

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        //访问根节点
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            //加入上一层
            result.add(current);
            //转到下一层
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                //访问子节点
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

}

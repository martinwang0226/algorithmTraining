package com.example.lib.treeGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class TreeTraversal {

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

    public List<Integer> preorderTraversal3(TreeNode root) {
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
        dfs(res,root.left,level+1);
        // 向下一个 level 中的左树进行遍历
        dfs(res,root.right,level+1);
    }


}

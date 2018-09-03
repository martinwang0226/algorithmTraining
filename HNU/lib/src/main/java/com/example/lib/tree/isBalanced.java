package com.example.lib.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by martinwang on 2018/9/1.
 */

public class isBalanced {
    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static List<TreeNode> nodeList = null;

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(0);
        TreeNode pNode1 = treeNode;



    }

    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    // 建树
    public void createBinTree() {
        nodeList = new LinkedList<TreeNode>();
        for (int i = 0; i < array.length; i++)
            nodeList.add(new TreeNode(array[i]));
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        int lastparentIndex = array.length / 2 - 1;
        nodeList.get(lastparentIndex).left = nodeList
                .get(lastparentIndex * 2 + 1);
        if (array.length % 2 == 1)
            nodeList.get(lastparentIndex).right = nodeList
                    .get(lastparentIndex * 2 + 2);

    }

    public static int checkHeight(TreeNode treeNode){
        if(treeNode ==null){
            return 0;
        }

        int leftHeight = checkHeight(treeNode.left);
        if(leftHeight ==-1){
            return -1;
        }

        int rightHeight = checkHeight(treeNode.right);
        if(rightHeight ==-1){
            return -1;
        }
        int heightDiff = leftHeight-rightHeight;
        if(Math.abs(heightDiff)>1){
            return -1;
        }else {
            return Math.max(leftHeight,+rightHeight) +1;
        }


    }

    public static boolean isBalanced2(TreeNode treeNode){
        if(checkHeight(treeNode)==-1){
            return false;
        }else {
            return true;
        }
    }


}

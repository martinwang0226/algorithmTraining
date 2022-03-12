package com.example.lib.treeGraph;

/**
 * Create by chenlong.wang
 * on 2020/9/2
 * 4.3　给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉查找树。（第54页）
 * <p>
 * Gayle Laakmann McDowell. 程序员面试金典（第5版） (p. 149). 人民邮电出版社. Kindle 版本.
 */
public class createMinimalBST {
    public static void main(String[] args) {

    }


    TreeNode CreateMinBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);

        n.left = CreateMinBST(arr, start, mid);
        n.right = CreateMinBST(arr, mid + 1, end);

        return n;

    }

}

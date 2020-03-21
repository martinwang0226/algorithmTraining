package com.example.lib.ArrayString;

import com.example.lib.linkedList.mergeTwoLists;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 最长字串的长度一定不会超过第 0 个字符串的长度
        int end = strs[0].length();
        for (int i = 1; i < strs.length; i++){
            int j = 0;
            while (j < end && j < strs[i].length() && strs[0].charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            end = j;
        }
        return strs[0].substring(0,end);
    }

}

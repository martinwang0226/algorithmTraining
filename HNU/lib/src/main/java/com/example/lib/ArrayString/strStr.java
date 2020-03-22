package com.example.lib.ArrayString;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * @author habo
 * @date 2020/3/21
 */
public class strStr {
    public static void main(String[] args) {
        System.out.print("子字符串在父字符串出现的第一个位置" + "======================="+strStr("HelloWorld","oW"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    private int[] callLps(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int length = 0;
        for (int i = 1;i < pattern.length();i++) {
            while (length > 0 && pattern.charAt(length) != pattern.charAt(i)) {
                length = lps[length - 1];
            }
            if (pattern.charAt(length) == pattern.charAt(i)) {
                length++;
            }
            lps[i] = length;
        }
        return lps;
    }
    public int strStr2(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int[] lps = callLps(needle); // longest proper prefix which is also suffix
        int i = 0, j = 0; // idx for text and pattern
        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            }
            if (j == needle.length()) {
                return i - j;
            } else if (i < haystack.length() && needle.charAt(j) != haystack.charAt(i)) { // mismatch after j matches
                if (j > 0) { // Don't match lps[0..lps[j-1]] characters, they will match anyway
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

}

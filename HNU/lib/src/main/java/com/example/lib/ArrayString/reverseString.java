package com.example.lib.ArrayString;

/**
 * Created by martinwang on 2018/8/31.
 * 字符串反转
 * 原题目用C／C++，这里用Java实现
 */

public class reverseString {

    public static void main(String[] args) {
        System.out.print("翻转字符串" + "=======================" + reverse2("I want to be a ByteDancer"));

    }

    //关注StringBuffer相对于String字符串拼接的优势
    private static String reverse1(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    private static String reverse3(String str) {
        char[] array = str.toCharArray();
        String reverse = "";
        for (int i = array.length - 1; i >= 0; i--) {
            reverse += array[i];
        }
        return reverse;
    }

    private static String reverse2(String str) {
        int length = str.length();
        String reverse = "";
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }

    /**
     * 带空格的字符串反转
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     */

    private String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(new StringBuffer(word).reverse().toString() + " ");
        }
        return res.toString().trim();
    }



}

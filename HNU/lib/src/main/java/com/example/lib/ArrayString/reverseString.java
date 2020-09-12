package com.example.lib.ArrayString;

/**
 * Created by martinwang on 2018/8/31.
 * 字符串反转
 * 原题目用C／C++，这里用Java实现
 */

public class reverseString {

    public static void main(String[] args) {
        System.out.print("翻转字符串" + "=======================" + reverseWords("I want to be a ByteDancer"));

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

    private static String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(new StringBuffer(word).reverse().toString() + " ");
        }
        return res.toString().trim();
    }

    /**
     * 输入:
     * "the sky is blue",
     *
     * 输出:
     * "blue is sky the".
     * @param s
     * @return
     */
    public  String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        if(s == null || "".equals(s.trim())){
            return "";
        }else{
            String [] strs = s.trim().split("\\s+");
            int len = strs.length-1;
            for(int i=len;i>=0;i--){
                if(i == 0){
                    sb.append(strs[i]);
                }else{
                    sb.append(strs[i]+" ");
                }
            }
            return sb.toString();
        }
    }



}

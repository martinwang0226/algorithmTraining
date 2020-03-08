package com.example.lib.ArrayString;

import java.util.Arrays;

/**
 * Created by martinwang on 2018/8/31.
 * 给定两个字符串，请确定其中一个字符串的字符重新排序后，能否变成另一个字符串
 */

public class permutation {
    public static void main(String args[]) {
        System.out.println("字符串匹配" + "===============" + permutation("HelWorld", "HelloWorld"));
    }

    public static String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    public static boolean permutationNum(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[256];
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

}

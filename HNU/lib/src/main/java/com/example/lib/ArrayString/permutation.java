package com.example.lib.ArrayString;

import java.util.Arrays;

/**
 * Created by martinwang on 2018/8/31.
 * 给定两个字符串，请确定其中一个字符串的字符重新排序后，能否变成另一个字符串
 *  是否区分大小写啊
 *  先判断长度
 */

public class permutation {
    public static void main(String args[]) {
        System.out.println("字符串重新排序，能否变成另一个呢？？？" + "===============" + permutation("HelWorld", "HelloWorld"));
    }

    public static String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    //解法1，排序解法，效率不一定高，但是清晰容易想出来
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }


    //这里假设字符集为ASCII码
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

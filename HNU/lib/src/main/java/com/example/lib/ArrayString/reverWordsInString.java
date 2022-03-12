package com.example.lib.ArrayString;

/**
 * Create by chenlong.wang
 * on 2020/9/9
 */
public class reverWordsInString {


    //反转部分字符串的工具方法
    public static void reverseString(char[] s, int l, int r) {
        int n = s.length;
        if (n <= 1) {
            return;
        }
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }

    }

    public static String reverseWords(String s) {
        if (s.equals("")) {
            return "";
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n <= 1) {
            return null;
        }
        int l = 0;

        int r = 0;
        int i = 0;
        while (i < n) {
            //找到l的位置
            for (; i < n; i++) {
                if (arr[i] != ' ') {
                    l = i;
                    break;
                } else {
                    i++;
                }
            }
            //找到r的位置
            while (i < n) {
                if (i == n - 1) {
                    r = n - 1;
                    reverseString(arr, l, r);
                    i++;
                    break;
                }
                if (arr[i] == ' ') {
                    r = i - 1;
                    reverseString(arr, l, r);
                    i++;
                    break;
                } else {
                    i++;
                }
            }
        }
        return new String(arr);

    }
}

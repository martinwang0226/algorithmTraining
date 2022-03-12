package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class longestPalindrome {
    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        String res = "";
        // dp[i][j] 用来表示 i 到 j 的字串是否是回文串
        boolean[][] dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                // dp[i][j] 用来判断是否为回文串， j - i + 1 > res.length() 用来判断是否是最长回文串
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        if(s.equals("")){
            return "";
        }
        int l = 0; // left index of the current substring
        int r = 0; // right index of the current substring
        int maxLength = 0; // length of the longest palindromic substring for now
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // odd case: 'xxx s[i] xxx', such as 'abcdcba'
            // 向左最多移动 i 位，向右最多移动 n - 1 - i 位
            for (int j = 0; j < Math.min(i + 1, n - i); j++) {
                // 不对称了就不用继续往下判断了
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                // 如果当前子串长度大于目前最长长度
                if (2 * j + 1 > maxLength) {
                    maxLength = 2 * j + 1;
                    l = i - j;
                    r = i + j;
                }
            }
            // even case: 'xxx s[i] s[i+1] xxx', such as 'abcddcba'
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                // s[i]向左最多移动 i 位，s[i+1]向右最多移动 [n-1-(i+1)] 位
                for (int j = 0; j < Math.min(i + 1, n - i - 1); j++ ) {
                    // 不对称了就不用继续往下判断了
                    if (s.charAt(i - j) != s.charAt(i + 1 + j)) {
                        break;
                    }
                    if (2 * j + 2 > maxLength) {
                        maxLength = 2 * j + 2;
                        l = i - j;
                        r = i + 1 + j;
                    }
                }
            }
        }
        return s.substring(l,r + 1);
    }


    public String longestPalindrome3(String s) {
        if(s.equals("")){
            return "";
        }
        int l = 0; // left index of the current substring
        int r = 0; // right index of the current substring
        int maxLength = 0; // length of the longest palindromic substring for now
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // odd case: 'xxx s[i] xxx', such as 'abcdcba'
            // 向左最多移动 i 位，向右最多移动 n - 1 - i 位
            for (int j = 0; j < Math.min(i + 1, n - i); j++) {
                // 不对称了就不用继续往下判断了
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                // 如果当前子串长度大于目前最长长度
                if (2 * j + 1 > maxLength) {
                    maxLength = 2 * j + 1;
                    l = i - j;
                    r = i + j;
                }
            }
            // even case: 'xxx s[i] s[i+1] xxx', such as 'abcddcba'
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                // s[i]向左最多移动 i 位，s[i+1]向右最多移动 [n-1-(i+1)] 位
                for (int j = 0; j < Math.min(i + 1, n - i - 1); j++ ) {
                    // 不对称了就不用继续往下判断了
                    if (s.charAt(i - j) != s.charAt(i + 1 + j)) {
                        break;
                    }
                    if (2 * j + 2 > maxLength) {
                        maxLength = 2 * j + 2;
                        l = i - j;
                        r = i + 1 + j;
                    }
                }
            }
        }
        return s.substring(l,r + 1);
    }
}

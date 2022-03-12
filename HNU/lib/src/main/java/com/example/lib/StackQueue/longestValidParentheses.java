package com.example.lib.StackQueue;

/**
 * Create by chenlong.wang
 * Longest Valid Parentheses（最长有效的括号）
 * on 2020/9/20
 */
public class longestValidParentheses {

    int len;
    boolean[] ok;
    char[] cs;

    public int longestValidParentheses1(String s) {
        len = s.length();
        cs = s.toCharArray();
        ok = new boolean[len];
        for (int i = 1; i < len; ++i) {
            if (cs[i] == ')')
                expand(i);
        }
        int res = 0, temp = 0;
        for (int i = 0; i < len; ++i) {
            if (ok[i])
                ++temp;
            else {
                res = Math.max(res, temp);
                temp = 0;
            }
            res = Math.max(res, temp);
        }
        return res;
    }

    public void expand(int index) {
        int match = index - 1;
        while (match >= 0 && index < len) {
            if (ok[match]) --match;
            else if (ok[index]) ++index;
            else if (cs[match] == '(' && cs[index] == ')')
                ok[match--] = ok[index++] = true;
            else break;
        }
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chas = s.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chas[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            if (dp[i] > res) res = dp[i];
        }
        return res;
    }


}

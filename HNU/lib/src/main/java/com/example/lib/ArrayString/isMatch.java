package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class isMatch {

    /**
     * @param s
     * @param p
     * @param i 表示 s 现在的位置
     * @param j 表示 p 现在的位置
     * @return 该函数返回 s[0..i] 能否和 p[0..i] 匹配
     */
    public boolean isMatch(String s, String p, int i, int j) {
        if (i == -1 && j == -1) {
            return true;
        }
        if (i == -1) {
            if (p.charAt(j) == '*') {
                return isMatch(s, p, i, j - 2);
            } else {
                return false;
            }
        }
        if (j == -1) {
            return false;
        }
        // 处理 .*
        if (j > 0 && p.charAt(j - 1) == '.' && p.charAt(j) == '*') {
            return isMatch(s, p, i - 1, j) || isMatch(s, p, i, j - 2);
        }
        // 处理 a*
        if (j > 0 && p.charAt(j) == '*') {
            if (s.charAt(i) == p.charAt(j - 1)) {
                return isMatch(s, p, i - 1, j) || isMatch(s, p, i, j - 2);
            } else {
                return isMatch(s, p, i, j - 2);
            }
        }
        // 处理.
        if (p.charAt(j) == '.') {
            return isMatch(s, p, i - 1, j - 1);
        }
        // 处理a
        if (p.charAt(j) == s.charAt(i)) {
            return isMatch(s, p, i - 1, j - 1);
        } else {
            return false;
        }
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, s.length() - 1, p.length() - 1);
    }
}

package com.example.lib.ArrayString;

/**
 * Create by chenlong.wang
 * on 2020/9/2
 * 判断一个字符串是否为另一个字符串旋转而成
 */
public class isRotation {
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public boolean isSubstring(String s1, String s2) {
        return true;
    }

}

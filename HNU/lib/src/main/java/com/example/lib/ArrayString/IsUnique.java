package com.example.lib.ArrayString;

/**
 * Created by martinwang on 2018/9/1
 * 实现一个算法，确定一个字符串的所有字符是否全都不同
 * 假如不允许使用额外的数据结构，又该如何处理
 */

public class IsUnique {
    public static void main(String[] args) {
        System.out.print("true or false" +"=======================" +isUniqueChar2("Helo"));
        // isUniqueCharsString("HelloWorld");

    }

    //假如字符串全部都是ASCII码
    //时间复杂度是O（n），空间复杂度是O（1）
    public static boolean isUniqueChar2(String str) {
        if (str.length() > 256) {
            return false;
        }

        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    //假设字符串只含有小写字母a～z
    //空间占用为原来的1／8
    public static boolean isUniqueCharsString(String str) {
        if (str.length() > 26) return false;
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            System.out.print("i" + " " + " " + i);
            int var = str.charAt(i) - 'a';
            System.out.print("val" + " " + " " + var);
            if ((checker & (1 << var)) > 0) {
                return false;
            }
            checker |= (1 << var);
            System.out.print("checker" + " " + checker);
        }
        return true;
    }


}

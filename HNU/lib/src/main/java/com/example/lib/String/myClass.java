package com.example.lib.String;

public class myClass {
    public static void main(String[] args) {
//        System.out.print("true or false" + isUniqueChar2("Helo"));
        isUniqueCharsString("HelloWorld");

    }

    public static boolean isUniqueChar2(String str) {
        if (str.length() > 256) return false;
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

    public static  boolean isUniqueCharsString(String str) {
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

package com.example.lib.String;

/**
 * Created by martinwang on 2018/8/31.
 */

public class reverseString {
    public static void main(String[] args){
        System.out.println("反转后的字符串是" +"===============" +reverseString("ABCDEFG"));

    }

    public static String reverseString(String str){
      return new StringBuffer(str).reverse().toString();
    }
}

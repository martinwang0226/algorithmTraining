package com.example.lib.dynamic;

import java.util.Scanner;

/**
 * Create by chenlong.wang
 * on 2020/9/20
 * 编程实现求阶乘 n!
 */
public class recursion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个正数：");
        int n = sc.nextInt();
        System.out.println("该数的阶乘是："+recursion(n));
    }
    // 递归方法
    public static int recursion(int n) {
        if(n==1) {
            return 1;
        }else {
            return recursion(n-1)*n;
        }
    }
}

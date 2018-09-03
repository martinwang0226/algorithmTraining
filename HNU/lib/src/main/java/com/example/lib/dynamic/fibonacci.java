package com.example.lib.dynamic;

/**
 * Created by martinwang on 2018/9/1.
 */

public class fibonacci {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println("斐波那契数列" + fibonacciCache(100));
        System.out.println(System.currentTimeMillis());
    }

    public static int fibonacci(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);

    }

    public static int fibonacciCache(int i) {
        int[] fib = new int[256];
        if (i == 0) return 0;
        if (i == 1) return 1;
        if (fib[i] != 0) return fib[i];
        fib[i] = fibonacci(i - 1) + fibonacci(i - 2);
        return fib[i];
    }
}

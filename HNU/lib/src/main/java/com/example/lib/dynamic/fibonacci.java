package com.example.lib.dynamic;

/**
 * Created by martinwang on 2018/9/1.
 */

public class fibonacci {

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        int a[] = new int[50];
        for (int i = 0; i < 50; i++) {
            a[i] = -1;
        }
        System.out.println("斐波那契数列" + fibonacciLowUp(40, a));
        long time2 = System.currentTimeMillis();
        long time = time2 - time1;
        System.out.println("斐波那契数列运行时间==" + time);

    }

    public static int fibonacci(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);

    }

    /**
     * 使用一个数组来记录各个子问题的解，当再一次遇到这一问题的时候直接查找数组来获得解避免多次计算子问题。
     *
     * @param i
     * @return
     */
    public static int fibonacciCache(int i, int fib[]) {
        if (i == 0) {
            fib[0] = 0;
            return 0;
        }
        if (i == 1) {
            fib[1] = 1;
            return 1;
        }
        if (fib[i] >= 0) {
            return fib[i];
        }
        fib[i] = fibonacciCache(i - 1, fib) + fibonacciCache(i - 2, fib);
        return fib[i];
    }

    /**
     * 先求解子问题再根据子问题的解来求解父问题，斐波那契数列的子问题图如下：
     */
    public static int fibonacciLowUp(int n, int fib[]) {
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }


}

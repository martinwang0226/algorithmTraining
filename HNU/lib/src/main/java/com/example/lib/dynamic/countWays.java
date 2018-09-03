package com.example.lib.dynamic;

/**
 * Created by martinwang on 2018/9/1.
 * 递归转动态规划的重点就是添加缓存项
 */

public class countWays {
    public static void main(String[] args) {
        int k = 5;
        int[] map=new int[1024];
        System.out.println("小孩上" + k + "阶楼梯有多少种方法" + "=============" + countWaysDP(k,map));
    }

    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    public static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > 0) {
            return map[n];
        } else {
            map[n] = countWaysDP(n - 1,  map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
            System.out.println("小孩上" + n + "阶楼梯有多少种方法" + "=============" + map[n]);
            return map[n];
        }
    }
}

package com.example.lib.dynamic;

/**
 * Created by martinwang on 2018/9/1.
 * 上n层阶梯，有多少种方法，每一次可以说上1，2，3种阶梯
 * 递归转动态规划的重点就是添加缓存项
 */

public class countWays {
    public static void main(String[] args) {
        int k = 22;
        int[] map = new int[1024];
        for (int n = 0; n < 1024; n++) {
            map[n] = -1;
        }

//        System.out.println("小孩上" + k + "阶楼梯有多少种方法" + "=============" + countWays(k));
        System.out.println("小孩上" + k + "阶楼梯有多少种方法" + "=============" + countWaysDP(k, map));
    }

    /**
     * 时间复杂度程指数级增长，O(n^3)
     *
     * @param n
     * @return
     */
    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    /**
     * 重复计算的类，利用map[n]存储中间状态
     *
     * @param n
     * @param map
     * @return
     */
    public static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            map[0] = 0;
            return 0;
        } else if (n == 0) {
            map[1] = 1;
            return 1;
        } else if (map[n] > 0) {
            return map[n];
        } else {
            map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
            System.out.println("小孩上" + n + "阶楼梯有多少种方法" + "=============" + map[n]);
            return map[n];
        }
    }
}

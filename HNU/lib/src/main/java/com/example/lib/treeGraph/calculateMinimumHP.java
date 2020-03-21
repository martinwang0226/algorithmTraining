package com.example.lib.treeGraph;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class calculateMinimumHP {

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] dp = new int[row+1][col+1];
        for (int i = 0; i < row + 1; i++) {
            dp[i] = new int[col+1];
            for (int j = 0; j < col + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        // 初始化右下角下方和右上角右边这两个格子，即从右下角出来都只需要1滴血即可存活
        dp[row][col-1] = 1;
        dp[row-1][col] = 1;
        for (int i = row-1; i > -1; i--) {
            for (int j = col-1; j > -1; j--) {
                // 在dungeon[i][j]中加的血是否达到了从dungeon[i+1][j]和dungeon[i][j+1]两者中出发的最小血量
                int tmp = dungeon[i][j] - (int) (Math.min(dp[i+1][j], dp[i][j+1]));
                if (tmp >= 0) { // 够, 只要1滴血能进dungeon[i][j]就行
                    dp[i][j] = 1;
                } else { // 不够，初始就要这么多血的差值才能进来
                    dp[i][j] = -tmp;
                }
            }
        }
        return dp[0][0];
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[] dp = new int[col+1];
        for (int i = 0; i < col + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 初始化右下角下方和右上角右边这两个格子，即从右下角出来都只需要1滴血即可存活
        dp[col-1] = 1;
        for (int i = row-1; i > -1; i--) {
            for (int j = col-1; j > -1; j--) {
                // 在dungeon[i][j]中加的血是否达到了从dungeon[i+1][j]和dungeon[i][j+1]两者中出发的最小血量
                int tmp = dungeon[i][j] - (int) (Math.min(dp[j], dp[j+1]));
                if (tmp >= 0) { // 够, 只要1滴血能进dungeon[i][j]就行
                    dp[j] = 1;
                } else { // 不够，初始就要这么多血的差值才能进来
                    dp[j] = -tmp;
                }
            }
        }
        return dp[0];
    }
}

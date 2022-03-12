package com.example.lib.treeGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class dfsStudent {

    int res = 0;
    int M = (int) Math.pow(10, 9) + 7;
    public void dfs(String cur, int cntA, int n) {
        if (cur.length() == n) { // 如果出勤记录长度达到了n就退出
            res += 1;
            res %= M;
            return;
        }
        if (cntA < 1) { // 如果'A'的个数少于1，我们可以允许有一次'A'
            dfs(cur+"A", cntA + 1, n);
        }
        // 如果没有连续两次的'L'，我们可以加上一次'L'
        if ((cur.length() < 2) || !(cur.charAt(cur.length()-1) == cur.charAt(cur.length()-2) && cur.charAt(cur.length()-1) == 'L')) {
            dfs(cur+"L", cntA, n);
        }
        dfs(cur+"P", cntA, n); // 任何时候我们加上一个'P'都是可行的
    }
    public int checkRecord(int n) {
        dfs("", 0, n);
        return res % M;
    }

    public int checkRecord2(int n) {
        int M = (int) Math.pow(10, 9) + 7;
        List<Long> dp = new ArrayList<>();
        dp.add((long) 1); // 这3个数字是根据规律推出来的, dp[0] = 1, dp[1] = 2, dp[2] = 4
        dp.add((long) 2);
        dp.add((long) 4);
        for (int i = 2; i < n; i++) {
            dp.add((dp.get(i) + dp.get(i-1) + dp.get(i-2)) % M);
        }
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            if (i == n) {
                res += dp.get(n);
            } else {
                res += (dp.get(i) * dp.get(n-1-i)) % M; // i 代表 'A' 前面的长度，n-1-i 代表 'A' 后面的长度
            }
            res %= M;
        }
        return res;
    }
}

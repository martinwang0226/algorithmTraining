package com.example.lib.treeGraph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class bsearch {

    private int[] sum;
    //由于前缀和需要用到sum[-1]=0，需要特判
    private int getSum(int index) {
        if (index == -1) {
            return 0;
        } else {
            return sum[index];
        }
    }
    private int bsearch(List<Integer> Q, int value) {
        int left = -1, right = Q.size();
        //二分查找
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (getSum(Q.get(mid)) <= value) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int shortestSubarray(int[] A, int K) {
        sum = new int[A.length];
        int s = 0;
        //前缀和
        for (int i = 0;i < A.length;i++) {
            s += A[i];
            sum[i] = s;
        }
        int ret = -1;
        List<Integer> Q = new ArrayList<>();//单调栈的实现
        Q.add(-1);
        for (int i = 0;i < sum.length;i++) {
            int index = bsearch(Q, sum[i] - K);
            if (index != -1) {
                if (ret == -1 || ret > i - Q.get(index)) {
                    ret = i - Q.get(index);
                }
            }
            //维护单调栈的递增性
            while (Q.size() > 0 && getSum(Q.get(Q.size() - 1)) > sum[i]) {
                Q.remove(Q.size() - 1);
            }
            Q.add(i);
        }
        return ret;
    }



    //由于前缀和需要用到sum[-1]=0，需要特判
    private int getSum2(int index) {
        if (index == -1) {
            return 0;
        } else {
            return sum[index];
        }
    }
    public int shortestSubarray2(int[] A, int K) {
        sum = new int[A.length];
        int s = 0;
        //前缀和
        for (int i = 0;i < A.length;i++) {
            s += A[i];
            sum[i] = s;
        }
        int ret = -1;
        Deque<Integer> Q = new LinkedList<>();//单调队列的实现
        Q.addLast(-1);
        for (int i = 0;i < sum.length;i++) {
            int index = -2;
            //改进的部分在这里
            while (Q.size() > 0 && getSum(Q.getFirst()) <= sum[i] - K) {
                index = Q.pollFirst();
            }
            if (index != -2) {
                if (ret == -1 || ret > i - index) {
                    ret = i - index;
                }
            }
            //维护单调队列的递增性
            while (Q.size() > 0 && getSum(Q.getLast()) > sum[i]) {
                Q.pollLast();
            }
            Q.addLast(i);
        }
        return ret;
    }
}

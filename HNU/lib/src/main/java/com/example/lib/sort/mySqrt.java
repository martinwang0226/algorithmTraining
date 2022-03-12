package com.example.lib.sort;

/**
 * Create by chenlong.wang
 * on 2020/9/20
 */
public class mySqrt {

    public int mySqrt(int x) {
        for (long i = 1; i <= x; i++) {
            if(i * i > x) {
                return (int)(i - 1);
            }else if(i * i == x) {
                return (int)i;
            }
        }
        return 0;
    }

    public int mySqrt2(int x) {
        int left = 0, right = x / 2 + 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return right;
    }


}

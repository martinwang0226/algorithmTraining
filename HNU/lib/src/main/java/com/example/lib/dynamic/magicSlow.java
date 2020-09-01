package com.example.lib.dynamic;

/**
 * Create by chenlong.wang
 * on 2020/8/31
 */
public class magicSlow {

    public static void main(String[] args) {

    }

    /**
     * 暴力搜索法
     *
     * @param array
     * @return
     */
    public static int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 类似二分搜索法
     */

    public static int magicFast(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] < mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    public static int magicFast2(int[] array, int start, int end) {
        if (end < start || start < 0 || end > array.length) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }

        //搜索左半部分
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast2(array, start, leftIndex);
        if (left > 0) {
            return left;
        }

        //搜索右半部分
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast2(array, rightIndex, end);
        return right;
    }


}

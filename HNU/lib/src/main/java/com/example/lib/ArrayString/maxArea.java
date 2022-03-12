package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class maxArea {
    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        // 目前这个区间能装的水有多少
        int ret = min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] < height[right]) {
                left++; // 此时left需要右移
            } else {
                right--; // 此时right需要左移
            }
            ret = max(ret, min(height[left], height[right]) * (right - left));
        }
        return ret;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }
}

package com.example.lib.ArrayString;

import java.util.Arrays;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class threeSumClosest {

    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        // 通过内部 api 进行排序
        Arrays.sort(nums);
        int ret = 1<<30;
        // 通过固定 nums[i]、移动 nums[left] 以及 nums[right] 来逼近目标值 target
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (Math.abs(ret - target) > Math.abs(temp - target)) {
                    ret = temp;
                }
                // temp 小于目标值 target 说明应该向由移动 left 指针，如果大于目标值 target 说明应该向左移动 right 指针
                if (temp <= target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ret;
    }
}

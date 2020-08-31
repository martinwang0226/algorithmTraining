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
        System.out.print("最接近的三数之和" + "=======================");
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int He, min;
        if (nums.length < 3) {
            return target;
        }
        min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0) {
                while (nums[i] == nums[i - 1] && i < nums.length - 2) {
                    i++;
                }
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                He = nums[i] + nums[j] + nums[k];
                if (He < target) {
                    if (target - He < Math.abs(min - target)) {
                        min = He;
                    }
                    j++;
                } else if (He > target) {
                    if (He - target < Math.abs(min - target)) {
                        min = He;
                    }
                    k--;
                } else {
                    return target;
                }
            }
        }
        return min;
    }
}

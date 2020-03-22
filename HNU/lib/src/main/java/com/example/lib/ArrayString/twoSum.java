package com.example.lib.ArrayString;

import java.util.HashMap;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 */
public class twoSum {
    public static void main(String[] args) {
        System.out.print("两数字相加的和等于目标值" + "=======================");
    }

    //暴力搜索，两重循环
    public int[] twoSum(int[] nums, int target) {
        // 第一轮遍历
        for (int i = 0; i < nums.length; i++) {
            // 第二轮遍历不能重复计算了
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    // 注意 leetcode 中要求返回的是索引位置
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    //主要的思路就是，空间换时间
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 将原本为两个目标值切换为一个目标值，只需要每次从 map 中寻找目标值即可
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            // 每次遍历过的值都存储到 map 中，这样之后就能从 map 中寻找需要的目标值
            map.put(nums[i], i);
        }
        return null;
    }
}


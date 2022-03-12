package com.example.lib.ArrayString;

/**
 * Create by chenlong.wang
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数
 * Missing Positive（求缺失的第一个正数）
 * on 2020/9/7
 */
public class missNum {

    // 关键字：桶排序，什么数字就要放在对应的索引上，其它空着就空着
    // 最好的例子：[3,4,-1,1]
    // 整理好应该是这样：[1,-1,3,4]，
    // 这里 1，3，4 都在正确的位置上，
    // -1 不在正确的位置上，索引是 1 ，所以返回 2
    // [4,3,2,1] 要变成 [1,2,3,4]
    // 这里负数和大于数组长度的数都是"捣乱项"。
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 前两个是在判断是否成为索引
            // 后一个是在判断，例如 3 在不在索引 2 上
            // 即 nums[i] ?= nums[nums[i]-1] 这里要特别小心
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 第 3 个条件不成立的索引的部分是 i 和 nums[i]-1
                swap(nums, nums[i] - 1, i);
            }
        }

        // 调试代码
        // System.out.println(Arrays.toString(nums));

        for (int i = 0; i < len; i++) {
            // [1,-2,3,4]
            // 除了 -2 其它都满足：i+1 = num[i]
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }

        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

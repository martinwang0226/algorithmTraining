package com.example.lib.sort;

import java.util.Arrays;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 创建新数组存储 nums1 和 nums2
        int[] nums = Arrays.copyOf(nums1, nums1.length + nums2.length);
        // 将 nums2 复制到新创建的数组 nums 中
        System.arraycopy(nums2,0,nums,nums1.length, nums2.length);
        // 数组排序
        Arrays.sort(nums);
        if (nums.length % 2 == 0) {
            // 新数组的长度如果是偶数，则需要找到中间的两个数进行取平均数
            int n1 = nums[nums.length / 2 - 1];
            int n2 = nums[nums.length / 2];
            return (double)(n1 + n2) / 2;
        } else {
            // 否则直接就是最中间的数
            return nums[nums.length / 2];
        }
    }
}

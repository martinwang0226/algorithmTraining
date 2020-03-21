package com.example.lib.ArrayString;

import java.util.Arrays;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class wiggleSort {

    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int k = temp.length - 1;
        for (int i = 1;i < nums.length;i += 2) {
            nums[i] = temp[k--];
        }
        for (int i = 0;i < nums.length;i += 2) {
            nums[i] = temp[k--];
        }
    }

    public void wiggleSort2(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int k = temp.length - 1;
        for (int i = 1;i < nums.length;i += 2) {
            nums[i] = temp[k--];
        }
        for (int i = 0;i < nums.length;i += 2) {
            nums[i] = temp[k--];
        }
    }
}

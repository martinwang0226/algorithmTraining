package com.example.lib.sort;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class nextPermutation {

    public static void main(String[] args){

    }


    public void nextPermutation(int[] nums) {
        int idx = nums.length - 2;
        //寻找从右边开始第一个比右边小的数
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            idx--;
        }
        if (idx >= 0) {
            int next = nums.length - 1;
            //寻找nums[idx]的下一个数
            while (next >= 0 && nums[next] <= nums[idx]) {
                next--;
            }
            //交换nums[idx]和nums[next]
            int temp = nums[idx];
            nums[idx] = nums[next];
            nums[next] = temp;
        }
        //将nums[idx+1..]倒过来
        int left = idx + 1, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

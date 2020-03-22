package com.example.lib.ArrayString;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author habo
 * @date 2020/3/21
 */
public class removeNum {

    public static void main(String[] args) {
        int[] numsTest = {1,2,3,4,4,5,6,7,7};
        System.out.print("删除数组中的元素" + "======================="+removeElement(numsTest,4));
    }


    public static int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    //思路 1：时间复杂度: O(N^2) 空间复杂度: O(1)

    public int removeElement2(int[] nums, int val) {
        int len = 0;
        //把nums[0..len]当做新数组，不等于val的往里面插入
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}

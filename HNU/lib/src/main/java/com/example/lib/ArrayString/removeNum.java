package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class removeNum {

    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }


    //思路 1：时间复杂度: O(N^2) 空间复杂度: O(1)
    private int removeIndex(int[] nums, int len, int index) {
        for (int i = index + 1;i < len;i++) {
            nums[i - 1] = nums[i];
        }
        //python这里会调用一个resize的方法，把数组的长度变量修改成len-1，但数组实际上的长度还是不变
        return len - 1;
    }
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        while (true) {
            boolean find = false;
            for (int i = 0;i < len;i++) {
                if (nums[i] == val) {
                    len = removeIndex(nums, len, i);
                    find = true;
                    break;
                }
            }
            if (!find) {
                break;
            }
        }
        return len;
    }

    //思路 1：时间复杂度: O(N^2) 空间复杂度: O(1)

    public int removeElement2(int[] nums, int val) {
        int len = 0;
        //把nums[0..len]当做新数组，不等于val的往里面插入
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}

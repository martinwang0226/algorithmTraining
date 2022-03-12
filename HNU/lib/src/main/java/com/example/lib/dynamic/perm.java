package com.example.lib.dynamic;

import java.util.Arrays;
import java.util.Stack;

/**
 * Create by chenlong.wang
 * 编程实现一组数据集合的全排列
 * on 2020/9/20
 */
public class perm {
    public static void main(String[] args) {
        perm(new int[]{1, 2, 3}, new Stack<Integer>());
    }

    public static void perm(int[] array, Stack<Integer> stack) {
        if (array.length <= 0) {
            //进入了叶子节点，输出栈中内容
            System.out.println(stack);
        } else {
            for (int i = 0; i < array.length; i++) {
                //tmepArray是一个临时数组，用于就是Ri
                //eg：1，2，3的全排列，先取出1，那么这时tempArray中就是2，3
                int[] tempArray = new int[array.length - 1];
                System.arraycopy(array, 0, tempArray, 0, i);
                System.arraycopy(array, i + 1, tempArray, i, array.length - i - 1);
                stack.push(array[i]);
                perm(tempArray, stack);
                stack.pop();
            }
        }
    }

    public static void perm(int[] array, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i <= end; i++) {
                //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                swap2(array, start, i);
                perm(array, start + 1, end);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                swap2(array, start, i);
            }
        }
    }

    public static void swap2(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

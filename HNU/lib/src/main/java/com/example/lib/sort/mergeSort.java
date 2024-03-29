package com.example.lib.sort;

/**
 * 归并排序常规方法
 * 思路：递归 + 排序数组合并
 * Created by martinwang on 2018/9/1.
 */

public class mergeSort {
    static void mergeSortComplete(int[] array, int low, int high, int[] helper) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSortComplete(array, low, middle, helper);//递归排序左半边
            mergeSortComplete(array, middle + 1, high, helper);//递归排序右半边
            merge(array, low, middle, high, helper);//合并有序的两个数组
        }
    }

    static void merge(int[] array, int low, int middle, int high, int[] helper) {//合并两组有序的数列
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        //第一个开始游标
        int helperLeft = low;
        //第二个开始游标
        int helperRight = middle + 1;
        int current = low;
        //两个游标，helperLeft和helperRight
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {//右半部分的元素早已经在目标数组中，无需复制
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 4, 5, 2, 1, 3, 6};
        int[] helper = new int[array.length];//需要有额外的数组
        mergeSortComplete(array, 0, array.length - 1, helper);
        for (int i = 0; i < array.length; i++) {
            System.out.println("排序后的结果是" + "=======================" + array[i]);
        }
    }
}

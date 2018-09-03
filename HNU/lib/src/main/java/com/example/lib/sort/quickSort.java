package com.example.lib.sort;

/**
 * Created by martinwang on 2018/9/1.
 */

public class quickSort {
    public static void main(String[] args) {
        return;
    }

    public static void quickSortHnu(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSortHnu(arr, left, index - 1);
        }
        if (index < right) {
            quickSortHnu(arr, index, right);
        }
    }

    public static int partition(int arr[], int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right++;

            if (left <= right) {
                //
            }
        }
        return 0;
    }
}

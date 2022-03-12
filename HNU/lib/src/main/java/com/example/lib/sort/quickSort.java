package com.example.lib.sort;

/**
 * Created by martinwang on 2018/9/1.
 */

public class quickSort {

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 4, 5, 2, 1, 3, 6};
        quickSortHnu(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println("排序后的结果是" + "=======================" + array[i]);
        }
    }

    public static void quickSortHnu(int arr[], int low, int high) {
        if (high < low) {
            return;
        }

        int pivot;
        pivot = partition(arr, low, high);
        quickSortHnu(arr, low, pivot - 1);
        quickSortHnu(arr, pivot + 1, high);


    }

    //arr[l+1....j]<pivot   arr[j+1 ...i-1]>pivot
    public static int partition(int arr[], int l, int r) {
        int pivot = arr[l];

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < pivot) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;
    }


}

package com.example.lib.sort;

/**
 * Create by chenlong.wang
 * 寻找数组中第k大的元素
 * 编程实现 O(n) 时间复杂度内找到一组数据的第 K 大元素
 * on 2020/9/10
 */
public class findKMax {


    //arr[low+1....j]<pivot   arr[j+1 ...i-1]>pivot [i...r]是当前考察的元素
    public static int partition(int[] arr, int l, int r) {
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

    public static void find_k(int k, int[] arr, int low, int high) {
        int temp = partition(arr, low, high);
        if (temp == k - 1) {
            System.out.print("第" + k + "大的数是：" + arr[temp]);
        } else if (temp > k - 1) {
            find_k(k, arr, low, temp - 1);
        } else {
            find_k(k - temp, arr, temp + 1, high);
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4, 7, 6};
        find_k(2, arr, 0, arr.length - 1);
    }


    public int findKthLargest2(int[] nums, int k) {
        // 先取K个元素放入数组topk中
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = nums[i];
        }

        minHeap heap = new minHeap(topk);

        for (int i = k; i < nums.length; i++) {
            heap.setRoot(nums[i]);
        }
        return topk[0];
    }
}

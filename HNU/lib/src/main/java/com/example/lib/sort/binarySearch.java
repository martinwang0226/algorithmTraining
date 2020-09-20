package com.example.lib.sort;

/**
 * Created by martinwang on 2018/9/1.
 */

public class binarySearch {

    public static void main(String[] srgs) {
        int[] a = {2, 3, 4, 5, 6, 7, 8, 11};
        System.out.println("寻找小数字" + "===============" + binarySearchRecursive(a, 2, 0, a.length - 1));
    }

    //迭代
    public static int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    //递归
    public static int binarySearchRecursive(int[] a, int x, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;

        if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid - 1);
        } else {
            return mid;
        }
    }

    //查找第一个值等于给定值的元素
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            //防止值溢出
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                //这块逻辑的处理是难点
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素

    public int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    //变体三：查找第一个大于等于给定值的元素

    public int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //变体四：查找最后一个小于等于给定值的元素

    public int bsearch7(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }


}

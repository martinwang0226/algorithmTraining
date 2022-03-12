package com.example.lib.sort;

/**
 * Created by martinwang on 2018/9/1.
 * 11.1　给定两个排序后的数组A和B，其中A的末端有足够的缓冲空容纳B。编写一个方法，将B合并入A并排序
 *
 */

public class mergeAB {

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0;i<5;i++){
            a[i] = i;
        }

        int[] b = {11, 12, 34, 56, 63};
        merge(a, b, 5, b.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println("合并后的数组为" + "============" + a[i]);
        }

    }

    //关键在于跳出思维定势，反着来
    public static void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;//A、B数组的末端
        int indexB = lastB - 1;
        int indexMerged = lastA + lastB - 1;//数组的末端

        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexMerged--;
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexMerged--;
                indexB--;
            }
        }
        //将数组B剩余的元素放到A数组中，A剩余的数组是不用处理的，因为A的元素本来就在原地
        while (indexB >= 0) {
            a[indexMerged] = b[indexB];
            indexMerged--;
            indexB--;
        }
    }
}

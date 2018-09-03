package com.example.lib.sort;

/**
 * Created by martinwang on 2018/9/1.
 */

public class binarySearch {

    public static void main(String[] srgs) {
        int[] a = {1,3,4,5,6,7,8,11};
        System.out.println("寻找小数字"+"==============="+binarySearchRecursive(a,2,0,a.length-1));
    }

    //迭代
    public static int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if(a[mid]<x){
                low = mid +1;
            }else if(a[mid]>x){
                high = mid -1;
            }else {
                return mid;
            }

        }
        return -1;
    }

    //递归
    public static int binarySearchRecursive(int[] a,int x,int low,int high){
        if(low>high)return -1;
        int mid = (low + high)/2;

        if(a[mid]<x){
            return binarySearchRecursive(a,x,mid+1,high);
        }else if(a[mid]>x){
            return binarySearchRecursive(a,x,low,mid-1);
        }else {
            return mid;
        }
    }


}

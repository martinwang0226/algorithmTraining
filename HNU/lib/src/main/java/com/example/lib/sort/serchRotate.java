package com.example.lib.sort;

/**
 * Created by martinwang on 2018/9/1.
 */

public class serchRotate {

    public static void main(String[] args){

    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        //搜索区间[l,r]

        while (l <= r) {
            //获得区间[l,r]的中点
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[r]) {
                //mid和r同时落在绿线或者红线上
                if (nums[mid] < target && nums[r] >= target) {
                    //target在mid的右边
                    l = mid + 1;
                } else {
                    //target在mid的左边
                    r = mid - 1;
                }
            } else {
                //mid在红线，r在绿线的情况
                if (nums[l] <= target && target < nums[mid]) {
                    //target在mid的左边
                    r = mid - 1;
                } else {
                    //target在mid的右边
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

}

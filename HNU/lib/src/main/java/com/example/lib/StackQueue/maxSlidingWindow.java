package com.example.lib.StackQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Create by chenlong.wang
 * 滑动窗口最大值
 * on 2020/9/20
 */
public class maxSlidingWindow {

    //1:优先级队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length<0 || k<=0 || k==1)
            return nums;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int[] max = new int[nums.length - k  + 1];
        for (int i = 0; i < nums.length; i++){
//          如果是第K个数之前和第K个数，就说明优先队列没有满，继续添加
            if(i  <  k - 1){
                queue.add(nums[i]);
            }else if(i == k- 1){
                queue.add(nums[i]);
                max[0] = queue.peek();
            }else {
//              优先队列已满，删除滑动窗口最左边的数[i - k],添加新的数
                queue.remove(nums[i - k]);
                queue.add(nums[i]);
                max[i - k + 1] = queue.peek();
            }
        }
        return max;

    }

}

package com.example.lib.ArrayString;

/**
 * Create by chenlong.wang
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * on 2020/9/7
 */
public class majorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(num == nums[i]){
                count++;
            }else{
                count--;
                if(count == 0){
                    num = nums[i];
                    count++;
                }

            }
        }
        return num;
    }
}

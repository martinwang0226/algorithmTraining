package com.example.lib.ArrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <description>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Three Sum（求三数之和）
 * @author habo
 * @date 2020/3/2
 *
 */
public class threeSum {

    public static void main(String[] args) {
//        System.out.print("链表中的两数相加" + "=======================");
    }

    /**
     * 暴力解法
     * 时间复杂度：O(n3)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 将数组排序
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        // 通过三层循环进行暴力搜索
        for (int i = 0; i < n; i++) {
            // 如果出现相同的值则跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                // 如果出现相同的值则跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    // 如果出现相同的值则跳过
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    // 如果三个数相加为 0，则是目标值集合
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        ret.add(temp);
                    }
                }
            }
        }
        return ret;
    }

    /**
     * 双指针解法
     * 算法复杂度（n2）
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> List = new ArrayList<List<Integer>>();
        if (nums.length < 3) return List;
        Arrays.sort(nums); // 第一步：进行排序
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            } // nums[i]大于0，则三数之和大于0，所以结束跳出
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } // 去掉重复


            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int He = nums[i] + nums[j] + nums[k];
                if (He == 0) {
                    List.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    } // 去掉左重复
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }// 去掉右重复
                    j++;
                    k--;
                } else if (He < 0) {
                    j++;
                } else if (He > 0) {
                    k--;
                }
            }
        }
        return List;
    }


}

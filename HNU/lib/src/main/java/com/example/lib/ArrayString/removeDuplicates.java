package com.example.lib.ArrayString;

import com.example.lib.linkedList.Node;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author habo
 * @date 2020/3/21
 */
public class removeDuplicates {
    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    //因为已经是排序数组，所以是相邻元素的比较
    public int removeDuplicates(int[] nums) {
        // len 初始化为 nums 的长度，当发现重复的元素则会递减
        int len = nums.length;
        int i = 0;
        while (i < len - 1) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < len - 1; j++) {
                    // 发现重复的元素则会将后面的元素依次前移一位
                    nums[j] = nums[j + 1];
                }
                len--;
            } else {
                i++;
            }
        }
        return len;
    }

    public int removeDuplicates2(int[] nums) {
        // 第一个数肯定不是重复的数，并且作为一个指针来计算不重复的数的个数
        int length = 0;
        for (int j = 1; j < nums.length; j++) {
            // 如果不是重复的数，就将指针 i 后移,同时将不重复的元素分配到指针 i 目前到达的位置
            if (nums[j] != nums[length]) {
                length++;
                nums[length] = nums[j];
            }
        }
        // i+1 是因为需要加上第一个不重复的数
        return length + 1;
    }

    //   允许两个重复的元素
    public int removeDuplicates3(int[] nums) {
        // 设置一个指针 i 来标志满足要求的元素个数
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // 前两个元素肯定不会重复两次以上
            if (i < 2 || nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    //链表,dummy  节点解决边界问题
    public ListNode deleteDuplicates4(ListNode head) {
        ListNode dummy = head;
        while (head != null) {
            // 当下一个元素不为空，并且当前元素的值与下一个元素的值相等
            while (head.next != null && head.data == head.next.data) {
                // 则将当前元素指向下一个元素的指针指向下一个元素的再下一个元素
                head.next = head.next.next;
            }
            // 当前元素没重复，进行下一次判断
            head = head.next;
        }
        return dummy;
    }

    //现在又来了一个新问题，如果我们想让最终的链表中只留下之前没有重复的元素，该怎么做？
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // dummy 指向不重复的 head 结点
        ListNode dummy  = new ListNode(0);
        // cur 指向当前结点
        ListNode cur  = dummy;
        // prev 指向前一个结点
        ListNode prev  = null;
        while (head != null) {
            if ((head.next == null || head.data != head.next.data) && (prev == null || prev.data != head.data)){
                cur.next = head;
                cur = cur.next;
            }
            prev = head;
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public class ListNode {
        ListNode next = null;
        int data;

        public ListNode(int d) {
            data = d;
        }

        void appendToTail(int d) {
            ListNode end = new ListNode(d);
            ListNode n = this;
            while (n.next != null) {
                n = n.next;
            }

            n.next = end;
        }
    }
}

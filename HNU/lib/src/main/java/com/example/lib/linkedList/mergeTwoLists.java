package com.example.lib.linkedList;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 实现两个有序的链表合并为一个有序链表
 * 示例:
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class mergeTwoLists {
    public static void main(String[] args) {
        System.out.print("两个链表进行合并" + "=======================");
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //dummy head
        ListNode dummyNode = new ListNode(0);
        ListNode prev = dummyNode;
        // 遍历两个链表，每次比较链表头的大小，每次让较小值添加到 dummy 的后面，并且让较小值所在的链表后移一位
        while (l1 != null && l2 != null) {
            if (l1.data >= l2.data) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        // 会出现一条链表遍历完，另外一条链表没遍历完的情况，需要将没遍历的链表添加到结果链表中
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        ListNode resultNode = dummyNode.next;
        return resultNode;
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

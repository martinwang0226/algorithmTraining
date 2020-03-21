package com.example.lib.linkedList;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class mergeTwoLists {
    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode prev = result;
        // 遍历两个链表，每次比较链表头的大小，每次让较小值添加到 dummy 的后面，并且让较小值所在的链表后移一位
        while (l1!= null && l2!= null) {
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
        return result.next;
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

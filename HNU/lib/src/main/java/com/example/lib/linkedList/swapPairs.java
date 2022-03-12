package com.example.lib.linkedList;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class swapPairs {

    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public ListNode swapPairs(ListNode head) {
        // 链表长度小于2，我们都直接返回head就行
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        // 递归处理后面所有的节点
        head.next = swapPairs(next.next);
        // 交换前两个节点
        next.next = head;
        return next;
    }

    public  class ListNode {
        ListNode next = null;
        int val;

        public ListNode(int d) {
            val = d;
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

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (true) {
            //迭代所有节点
            if (p.next == null || p.next.next == null) {
                break;
            }
            ListNode first = p.next;
            ListNode second = first.next;
            //交换前两个节点
            first.next = second.next;
            second.next = first;
            p.next = second;
            p = p.next.next;
        }
        return dummy.next;
    }


}

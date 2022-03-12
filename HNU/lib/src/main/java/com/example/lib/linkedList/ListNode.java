package com.example.lib.linkedList;

/**
 * Create by chenlong.wang
 * on 2020/9/7
 */
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

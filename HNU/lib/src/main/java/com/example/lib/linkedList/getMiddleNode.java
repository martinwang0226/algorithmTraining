package com.example.lib.linkedList;

/**
 * Create by chenlong.wang
 * 寻找一个链表的中间节点
 * 实现求链表的中间结点
 * on 2020/9/7
 */
public class getMiddleNode {

    public LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}

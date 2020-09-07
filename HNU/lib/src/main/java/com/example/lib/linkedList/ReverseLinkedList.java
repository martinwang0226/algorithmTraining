package com.example.lib.linkedList;

import java.util.Stack;

/**
 * Create by chenlong.wang
 * 单链表的反转
 * on 2020/8/26
 */
public class ReverseLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代
     *记不住
     * @param node
     * @return
     */
    public static Node reverseList(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     * 方法3 利用其他数据结构 stack
     * 最容易理解
     *
     * @param head
     * @return
     */
    public static Node reverse3(Node head) {
        Stack<Node> stack = new Stack<Node>();
        for (Node node = head; null != node; node = node.next) {
            stack.add(node);
        }
        Node reHead = stack.pop();
        Node cur = reHead;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
            cur.next = null;
        }
        return reHead;
    }
}

package com.example.lib.linkedList;

import java.util.Stack;

/**
 * Create by chenlong.wang
 * 实现单链表反转
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
     *1->2->3->4
     * @param head
     *
     * @return
     */
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代
     * @param cur
     * @return
     * 两个指针，pre和next
     * pre  1:null  2:node1->null
     * next 1:null  2:node2->node3  3:node3->node4
     * node 1:node1->node2   2: node2->node3 3:node2->node1->null
     */
    public static Node reverseList(Node cur) {
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;//保留当前节点的下一个节点
            cur.next = pre;//重置当前节点的下一个节点为上一个节点
            pre = cur;//下次遍历需要用到的上一个节点
            cur = next;//下次遍历需要用到的当前节点
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

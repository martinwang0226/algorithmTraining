package com.example.lib.linkedList;

/**
 * Create by chenlong.wang
 * 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * on 2020/8/26
 */
public class Partition {

    public static void main(String[] args) {

    }

    public static LinkedListNode partition2(LinkedListNode node, int x) {
        if (node == null) {
            return null;
        }

        LinkedListNode beforeStart = null;
        LinkedListNode afterStart = null;

        while (node != null) {
            LinkedListNode next = node.next;
            if ((int) node.data < x) {
                node.next = beforeStart;
                beforeStart = node;
            } else {
                node.next = afterStart.next;
                afterStart = node;
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        LinkedListNode head = beforeStart;
        while (beforeStart.next != null) {
            beforeStart = beforeStart.next;
        }
        beforeStart.next = afterStart;

        return head;
    }

    /*
     * 直接创建两个链表：一个链表存放小于x的元素，另一个存放大于或等于x的元素。
     * 然后迭代访问整个链表，将元素插入before或者after链表末尾。一旦抵达链表末端，则表明拆分完毕，最后合并两个链表。
     */

    public static LinkedListNode partition(LinkedListNode node, int x) {
        if (node == null) {
            return null;
        }


        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (node != null) {
            LinkedListNode next = node.next; //将链表存储在next中
            node.next = null;                            //将node的next清零表示，只是添加一个节点，而非以该节点为头结点的链表
            if ((int) node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        //合并
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}

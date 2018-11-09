package com.example.lib.linkedList;

/**
 * Created by martinwang on 2018/9/5.
 */

public class nthOfLast {
    public static void main(String[] args) {
        AutoLinkList listNode = new AutoLinkList();
        for (int i = 0; i < 10; i++) {
            listNode.add(i * 3);
        }
        LinkedListNode n0;
        n0 = listNode.head;
        while (n0 != null) {
            System.out.println("数据链表为" + "==============" + n0.data);
            n0 = n0.next;
        }
        int k = 3;
//        nthToLast(listNode.head, k);
//        IntWrapper i = new IntWrapper();
//        System.out.println("找到的倒数第K个数字为" + nthToLastR2(listNode.head, k, i).data);
        System.out.println("找到的倒数第K个数为"+ nToLastR3(listNode.head,k).data);
    }

    //递归
    public static int nthToLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int i = nthToLast(head.next, k) + 1;
        if (i == k) {
            System.out.println(head.data);
        }
        return i;

    }

    public static class IntWrapper {
        public int value = 0;
    }

    //依然是递归法，带包裹类返回值的
    public static LinkedListNode nthToLastR2(LinkedListNode head, int k, IntWrapper i) {
        if (head == null) {
            return null;
        }
        System.out.println("value 的前数值为" + "==========" + i.value);
        LinkedListNode node = nthToLastR2(head.next, k, i);
        i.value = i.value + 1;
        System.out.println("value 的后数值为" + "==========" + i.value);
        if (i.value == k) {
            return head;
        }
        return node;
    }

    //有迭代就有递归啊
    public static LinkedListNode nToLastR3(LinkedListNode head, int k) {
        if (k <= 0) return null;
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int i = 0; i < k; i++) {
            if (p2 == null) return null;
            p2 = p2.next;

        }
        if (p2 == null) return null;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

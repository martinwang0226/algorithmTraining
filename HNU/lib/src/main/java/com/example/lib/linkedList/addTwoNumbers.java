package com.example.lib.linkedList;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 * 链表中的两数相加
 */
public class addTwoNumbers {

    public static void main(String[] args) {
        System.out.print("链表中的两数相加" +"=======================" );
    }

    public static class ListNode {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String numStr1 = String.valueOf(l1.val);
        String numStr2 = String.valueOf(l2.val);

        //把链表转化为字符串
        // 拼接 l1 的值
        while (l1.next != null){
            numStr1 += String.valueOf(l1.next.val);
            l1 = l1.next;
        }

        // 拼接 l2 的值
        while (l2.next != null) {
            numStr2 += String.valueOf(l2.next.val);
            l2 = l2.next;
        }

        // 使用 BigInteger 是为了防止大数的溢出
        BigInteger num1 = new BigInteger(new StringBuffer(numStr1).reverse().toString());
        BigInteger num2 = new BigInteger(new StringBuffer(numStr2).reverse().toString());

        BigInteger sum = num1.add(num2);

        String sumStr = new StringBuffer(String.valueOf(sum)).reverse().toString();

        ListNode head = new ListNode(0);
        ListNode dummy = head;
        // 将字符串 sum 转化为链表形式的 sum
        for (int i = 0; i < sumStr.length(); i++) {
            head.next = new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(i))));
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        if (l1 == null && l2 == null) {
            // l1 与 l2 都为 null 的情况
            return null;
        } else if (l1 == null && l2 != null) {
            // l1 为 null 但是 l2 不为 null 的情况
            return l2;
        } else if (l1 != null && l2 == null) {
            // l1 不为 null 但是 l2 为 null 的情况
            return l1;
        } else {
            // l1 l2 都不为 null 的情况
            if (l1.val + l2.val < 10) {
                // 不需要进位的情况
                l3 = new ListNode(l1.val + l2.val);
                l3.next = addTwoNumbers(l1.next, l2.next);
            }else {
                // 需要进位的情况
                l3 = new ListNode(l1.val + l2.val - 10);
                l3.next = addTwoNumbers(l1.next, addTwoNumbers(l2.next, new ListNode(1)));
            }
        }
        return l3;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        // one 用来判断是否应该进位
        boolean one = false;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (one) {
                val += 1;
            }
            // 判断是否进位
            if (val >= 10) {
                val -= 10;
                one = true;
            }else {
                one = false;
            }
            if (head == null) {
                head = tail = new ListNode(val);
            }else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }
        if (one) {
            tail.next = new ListNode(1);
        }
        return head;
    }




}

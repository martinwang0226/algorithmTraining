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
        System.out.print("链表中的两数相加" + "=======================");
    }

    public static class ListNode {
        ListNode next = null;
        ListNode prev = null;
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

    /**
     * 方法1：转化为字符串，利用API 反转后再相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String numStr1 = String.valueOf(l1.val);
        String numStr2 = String.valueOf(l2.val);

        //把链表转化为字符串
        // 拼接 l1 的值
        while (l1.next != null) {
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

    /**
     * 方法2，递归方法
     *
     * @param l1
     * @param l2
     * @return
     */
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
            } else {
                // 需要进位的情况
                l3 = new ListNode(l1.val + l2.val - 10);
                l3.next = addTwoNumbers(l1.next, addTwoNumbers(l2.next, new ListNode(1)));
            }
        }
        return l3;
    }

    /**
     * 迭代方法
     *
     * @param l1
     * @param l2
     * @return
     */
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
            } else {
                one = false;
            }
            if (head == null) {
                head = tail = new ListNode(val);
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }
        if (one) {
            tail.next = new ListNode(1);
        }
        return head;
    }

    /**
     * 方法4递归方法
     * @param l1
     * @param l2
     * @param carry
     * @return
     */
    public ListNode addLists(ListNode l1, ListNode l2, int carry)
//LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry = 0)
    {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        ListNode result = new ListNode(-1);
        int value = carry;
        if (l1 != null) {
            value += l1.val;
        }
        if (l2 != null) {
            value += l2.val;
        }

        result.val = value % 10;

        ListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
        result.next = more;
        return result;
    }

    //2.5b进阶：假设这些数位是正向存放的
    public class PartialSum
    {
        public ListNode sum = null;
        public int carry = 0;
    }

    public int length(ListNode l){
        return 1;
    }

    ListNode addLists(ListNode l1, ListNode l2)
    {
        int len1 = length(l1);
        int len2 = length(l2);

        //用零填充较短的链表
        if (len1 < len2)
        {
            l1 = padList(l1, len2 - len1);
        }
        else
        {
            l2 = padList(l2, len1 - len2);
        }

        //对两个链表求和
        PartialSum sum = addListsHelper(l1, l2);

        //如有进位，则插入链表首部，否则，直接返回整个链表
        if (sum.carry == 0)
        {
            return sum.sum;
        }
        else
        {
            ListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    PartialSum addListsHelper(ListNode l1, ListNode l2)
    {
        if (l1 == null && l2 == null)
        {
            PartialSum sum = new PartialSum();
            return sum;
        }

        //先递归为较小数字求和
        PartialSum sum = addListsHelper(l1.next, l2.next);

        //将进位和当前数据相加
        int val = sum.carry + l1.val + l2.val;

        //插入当前数字的求和结果
        ListNode full_result = insertBefore(sum.sum, val % 10);

        //返回求和结果与进位值
        sum.sum = full_result;
        sum.carry = val/10;
        return sum;
    }

    //用零填充链表
    ListNode padList(ListNode l,int padding)
    {
        ListNode head = l;
        for (int i = 0; i < padding; i++)
        {
            ListNode n = new ListNode(0);
            head.prev = n;
            n.next = head;
            head = n;
        }
        return head;
    }

    //辅助函数，将结点插入链表首部
    ListNode insertBefore(ListNode list, int data)
    {
        ListNode node = new ListNode(data);
        if (list != null)
        {
            list.prev = node;
            node.next = list;
        }
        return node;
    }



}

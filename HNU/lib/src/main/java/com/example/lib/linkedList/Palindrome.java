package com.example.lib.linkedList;

import java.util.Stack;

/**
 * Create by chenlong.wang
 * 编写一个函数，检查一个链表是否是回文串
 * on 2020/8/27
 */
public class Palindrome {

    /**
     * 方法1，快慢指针法，同时用stack存储
     *
     * @param head
     * @return
     */
    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push((int) slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //如果链表有奇数个元素，那么fast这时不为空，则比较后半段时跳过中间元素
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();
            //如果不相同，则不是回文
            if (top != (int) slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;


    }

    public class Result {
        public LinkedListNode node;
        public boolean result;

        public Result(LinkedListNode node,boolean result){
            this.node = node;
            this.result = result;
        }
    }

    public Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length == 0) {
            return new Result(null, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        } else if (length == 2) {
            return new Result(head.next.next, head.data == head.next.data);
        }
        Result res = isPalindromeRecurse(head.next, length - 2);
        if (!res.result || res.node == null) {
            return res;
        } else {
            res.result = head.data == res.node.data;
            res.node = res.node.next;
            return res;
        }
    }

    boolean isPalinddrome(LinkedListNode head) {
        Result p = isPalindromeRecurse(head, listSize(head));
        return p.result;
    }

    public int listSize(LinkedListNode h){
        return 1;
    }
}

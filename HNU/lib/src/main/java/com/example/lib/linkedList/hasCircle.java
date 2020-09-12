package com.example.lib.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by chenlong.wang
 * on 2020/9/7
 */
public class hasCircle {

    //顺着链表一直遍历下去，看有无重复节点
    public boolean hasCycle(Node head) {
        //声明一个set存放已遍历的节点，即为标记节点（Set中不允许重复元素）
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public boolean hasCycle2(Node head) {
        //声明两个节点从头开始遍历节点==
        Node quick = head;
        Node slow = head;
        //当快指针能够走到头表示无环
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

}

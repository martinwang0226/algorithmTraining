package com.example.lib.linkedList;

import java.util.PriorityQueue;

/**
 * Create by chenlong.wang
 * Merge k Sorted Lists（合并 k 个排序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表
 *
 * Merge k Sorted Lists（合并 k 个排序链表）
 * on 2020/9/7
 */
public class mergeKListNode {


    //利用优先级队列实现
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 0){
            return null;
        }
        //按照intenger的大小优先级排队
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(ListNode node:lists){
            while(node != null){
                queue.add(node.data);
                node = node.next;
            }
        }
        ListNode dummyNode = new ListNode(0);
        ListNode tmp= dummyNode;
        while(!queue.isEmpty()){
            ListNode temp = new ListNode(queue.poll());
            tmp.next = temp;
            tmp = tmp.next;
        }
        return dummyNode.next;
    }

    //利用mergeTwoLists 的结果进行链表合并
    //常规思路，可以想到
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode res = new ListNode(0);  //设置结果
        if(lists == null || lists.length < 0){
            return null;
        }else if(lists.length == 1){
            return lists[0];
        }else if(lists.length == 2){
            mergeTwoLists(lists[0],lists[1]);
        }else{
            res = mergeTwoLists(lists[0],lists[1]);
            for(int i = 2; i < lists.length;i++){
                mergeTwoLists(res,lists[i]);
            }
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode res = new ListNode(0);
        ListNode tmp = res;

        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        //后面是为了补全的，因为链表的长度可能不一样
        if(l1 != null){
            tmp.next = l1;
        }else{
            tmp.next = l2;
        }
        return res.next;
    }
}

package com.example.lib.linkedList;

import java.util.Hashtable;

/**
 * Created by martinwang on 2018/8/31.
 */

public class DeleteDups {
    public static void main(String[] args) {
        AutoLinkList listNode = new AutoLinkList();
        for (int i = 0; i < 10; i++) {
            listNode.add(i);
        }
        listNode.add(5);
        LinkedListNode n0;
        n0 = listNode.head;
        while (n0 != null) {
            System.out.println("处理重复数据前的链表为" + "==============" + n0.data);
            n0 = n0.next;
        }
        deleteDups(listNode.head);
        LinkedListNode n;
        n = listNode.head;
        while (n != null) {
            System.out.println("处理重复数据后的链表为" + "==============" + n.data);
            n = n.next;
        }

        return;
    }

    //增加游标head，O(n) 空间换时间
    public static LinkedListNode deleteDups(LinkedListNode n) {
        Hashtable hashtable = new Hashtable();
        LinkedListNode previous = null;
        while (n != null) {
            if (hashtable.containsKey(n.data)) {
                previous.next = n.next;
            } else {
                hashtable.put(n.data, true);
                previous = n;
            }
            n = n.next;
        }
        return previous;
    }

    //没有缓冲区域的实现，时间换空间,两个游标 O(n 的2)
    public static void deleteDups1(LinkedListNode head){
        if(head !=null)return;
        LinkedListNode current = head;
        while(current!=null){
            LinkedListNode runner = current;
            while(runner.next!=null){
                if(runner.next.data ==current.data){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

    }


}

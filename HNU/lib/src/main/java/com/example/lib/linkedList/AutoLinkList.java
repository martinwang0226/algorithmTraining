package com.example.lib.linkedList;

/**
 * Created by martinwang on 2018/9/4.
 */

public class AutoLinkList {
    public  LinkedListNode head;
    public  LinkedListNode current;

    public void add(int data){
        if(head ==null){
            head = new LinkedListNode(data);
            current= head;
        }else {
            current.next = new LinkedListNode(data);
            current = current.next;
        }
    }
}

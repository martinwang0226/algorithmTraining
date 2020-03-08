package com.example.lib.StackQueue;

/**
 * Created by martinwang on 2018/9/1.
 */

public class stack {
    Node top;

    Object pop() {
        if (top != null) {
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(Object item){
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    Object peek(){
        return  top.data;
    }

}

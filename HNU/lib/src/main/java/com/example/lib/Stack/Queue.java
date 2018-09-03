package com.example.lib.Stack;

/**
 * Created by martinwang on 2018/9/1.
 */

public class Queue {
    Node first, last;

    void equeu(Object item) {
        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    Object dequeu() {
        if (first != null) {
            Object item = first.data;
            first = first.next;
            return item;
        } else {
            return null;
        }
    }
}

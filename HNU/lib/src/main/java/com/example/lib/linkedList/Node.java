package com.example.lib.linkedList;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/8
 */
public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }
}

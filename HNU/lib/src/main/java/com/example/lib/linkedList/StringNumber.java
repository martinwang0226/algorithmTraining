package com.example.lib.linkedList;

import java.util.Hashtable;

/**
 * <description>
 *
 * 编写代码，移除未排序链表中的重复节点
 *  如果不能使用临时缓冲区，该如何解决
 * @author habo
 * @date 2020/3/8
 */
public class StringNumber {
    private LinkedListNode<Integer> head;
    private LinkedListNode<Integer> tail;
    private int size;

    //尾部插入
    public boolean addTail(int data) {
        if (this.head == null) {
            this.head = new LinkedListNode<Integer>( data);
            this.tail = this.head;
        } else {
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>( data);
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
        return true;
    }

    public String toString() {
        if (this.isEmpty())
            return "[]";
        else {
            StringBuffer st = new StringBuffer("[");
            for (LinkedListNode<Integer> curent = this.head; curent != null; curent = curent.next)
                st.append(curent.data.toString() + " ,");
            st.append("]");
            return st.toString();
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public void deleteDups(LinkedListNode<Integer> n){
        Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
        LinkedListNode<Integer> previous = null;
        while(n != null){
            if(table.containsKey(n.data)){
                previous.next = n.next;
            }else{
                table.put(n.data, true);
                previous = n;
            }
            n =n.next;
        }
        while(head!=null){
            System.out.println(head.data.toString());
            head= head.next;
        }
    }

    public void deleteDups2(LinkedListNode<Integer> head){
        if(head == null)
            return;
        LinkedListNode<Integer> current = head;
        while(current != null){
            //移除后续值相同的所有节点
            LinkedListNode<Integer> runner = current;
            while(runner.next != null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current= current.next;
        }
        while(head!=null){
            System.out.println(head.data.toString());
            head= head.next;
        }
    }

    public LinkedListNode getHead(){
        return head;
    }
}

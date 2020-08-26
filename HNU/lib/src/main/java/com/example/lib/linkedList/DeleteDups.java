package com.example.lib.linkedList;

import java.util.Hashtable;

/**
 * Created by martinwang on 2018/8/31.
 * <p>
 * 编写代码，移除未排序链表中的重复节点
 * 如果不能使用临时缓冲区，该如何解决
 *
 * 这道问题还是没调试出来，待定
 */

public class DeleteDups {
    public static void main(String[] args) {
        int arr[] = {1,2,3,3,2,1,4,2};

        //将数组元素依次存入链表
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(1);
        int i = 1;
        LinkedListNode p1 = head;
        while (i < arr.length) {
            p1.next = new LinkedListNode(arr[i]);
            p1 = p1.next;
            ++i;
        }

//        System.out.println("删除链表中的重复节点后，之前就是？？？" + "===============" + .toString());
        //输出样例的预期结果
//        LinkedListNode p2 = head;
//        while (p2 != null) {
//            System.out.print(p2.data + (p2.next == null ? "" : " "));
//            p2 = p2.next;
//        }

         new DeleteDups().deleteDups2(head);

//        System.out.println("删除链表中的重复节点后，结果就是？？？" + "===============" + test.toString());
        //输出样例的预期结果
        LinkedListNode p2 = head;
        while (p2 != null) {
            System.out.print(p2.data + (p2.next == null ? "" : " "));
            p2 = p2.next;
        }
    }

    public LinkedListNode deleteDups(LinkedListNode<Integer> head){
        Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
        LinkedListNode<Integer> previous = null;
        LinkedListNode p = head;
        while(p != null){
            if(table.containsKey(p.data)){
                previous.next = p.next;
            }else{
                table.put((Integer) p.data, true);
                previous = p;
            }
            p =p.next;
        }
       return head;
    }

    public void deleteDups2(LinkedListNode<Integer> head){
        if(head == null){
            return;
        }

        LinkedListNode<Integer> current = head;
        while(current != null){
            //移除后续值相同的所有节点
            LinkedListNode<Integer> runner = current;
            while(runner.next != null){
                if(runner.next.data.equals(current.data)){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current= current.next;
        }
    }




}

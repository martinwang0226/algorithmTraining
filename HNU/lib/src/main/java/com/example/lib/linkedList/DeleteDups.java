package com.example.lib.linkedList;

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
        StringNumber test = new StringNumber();
        test.addTail(1);
        test.addTail(2);
        test.addTail(3);
        test.addTail(3);
        test.addTail(4);
        test.addTail(1);
        System.out.println("删除链表中的重复节点后，之前就是？？？" + "===============" + test.toString());

         test.deleteDups(test.getHead());

        System.out.println("删除链表中的重复节点后，结果就是？？？" + "===============" + test.toString());
    }




}

package com.example.lib.treeGraph;

import com.example.lib.linkedList.Node;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Create by chenlong.wang
 * 4.2　给定有向图，设计一个算法，找出两个结点之间是否存在一条路径。（第54页）
 *
 * Gayle Laakmann McDowell. 程序员面试金典（第5版） (p. 148). 人民邮电出版社. Kindle 版本.
 * on 2020/9/2
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphSearch {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        UndirectedGraphNode a = new UndirectedGraphNode(1);
        UndirectedGraphNode a1 = new UndirectedGraphNode(2);
        UndirectedGraphNode a2 = new UndirectedGraphNode(3);
        UndirectedGraphNode a3 = new UndirectedGraphNode(4);
        UndirectedGraphNode a11 = new UndirectedGraphNode(5);
        UndirectedGraphNode a12 = new UndirectedGraphNode(6);
        UndirectedGraphNode a13 = new UndirectedGraphNode(7);
        UndirectedGraphNode b = new UndirectedGraphNode(8);
        a1.neighbors.add(a);
        a.neighbors.add(a2);
        a.neighbors.add(a3);
        a.neighbors.add(a1);
        a11.neighbors.add(a1);
        a1.neighbors.add(a12);
        a1.neighbors.add(a13);
        b.neighbors.add(a11);
        System.out.println(checkPath(a, b));
    }

    public static boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        map.clear();
        boolean bool1 = checkPathCore(a, b);
        map.clear();
        boolean bool2 = checkPathCore(b, a);
        return bool1 || bool2;
    }

    public static Map<UndirectedGraphNode, Boolean> map = new HashMap<UndirectedGraphNode, Boolean>();

    public static boolean checkPathCore(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        if (a == null || b == null) {
            return false;
        }
        if (a == b) {
            return true;
        }
        map.put(a, true);
        int num = a.neighbors.size();
        for (int i = 0; i < num; i++) {
            if (!map.containsKey(a.neighbors.get(i))  && checkPathCore(a.neighbors.get(i), b))
                //深度遍历
            {
                return true;
            }
        }
        return false;
    }

    public static class UndirectedGraphNode {
        int label = 0;
        UndirectedGraphNode left = null;
        UndirectedGraphNode right = null;
        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

        public UndirectedGraphNode(int label) {
            this.label = label;
        }
    }

}

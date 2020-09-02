package com.example.lib.treeGraph;

/**
 * Create by chenlong.wang
 * on 2020/9/2
 * 图论中图的定义
 */
public class Graph {            //建立图和添加顶点
    private Node vertices[];
    public int count;

    public Graph() {
        vertices = new Node[6];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < 30) {
            vertices[count] = x;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }

    public Node[] getNodes() {
        return vertices;
    }
}

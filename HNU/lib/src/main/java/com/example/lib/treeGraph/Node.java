package com.example.lib.treeGraph;

/**
 * Create by chenlong.wang
 * on 2020/9/2
 * 图论中点的定义
 */
class Node {
    private Node adjacent[];
    //邻接的所有顶点，存放在一个数组中
    public int adjacentCount;
    private String vertex;
    //当前顶点的值
    public Question.State state;

    public Node(String vertex, int adjacentLength) {
        //adjacentLength是和该顶点邻接的顶点的数量
        this.vertex = vertex;
        adjacentCount = 0;
        //每实例化一个顶点，邻接顶点的数量开始是0
        adjacent = new Node[adjacentLength];
    }

    public void addAdjacent(Node x) {
        //添加邻接的顶点
        if (adjacentCount < 30) {
            //邻接的顶点的数量不要操作30
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
            //邻接的顶点的数量加1
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
    public Node[] getAdjacent() {
        //返回所有的邻接顶点的数组
        return adjacent;
    }
    public String getVertex() {     //取得当前顶点的值
        return vertex;
    }
}

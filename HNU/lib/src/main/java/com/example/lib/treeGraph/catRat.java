package com.example.lib.treeGraph;

import com.example.lib.StackQueue.Queue;

import java.util.LinkedList;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class catRat {
    private class Node {
        int first;
        int mouse;
        int cat;
        // 声明Node
        public Node(int first, int cat, int mouse) {
            this.first = first;
            this.mouse = mouse;
            this.cat = cat;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getMouse() {
            return mouse;
        }

        public void setMouse(int mouse) {
            this.mouse = mouse;
        }

        public int getCat() {
            return cat;
        }

        public void setCat(int cat) {
            this.cat = cat;
        }
    }

    private int solve(int[][] graph) {
        int[][][] cache = new int[2][graph.length][graph.length];
        for (int first = 0;first < 2;first++) {
            for (int cat = 0;cat < graph.length;cat++) {
                for (int mouse = 0;mouse < graph.length;mouse++) {
                    cache[first][cat][mouse] = 0;
                }
            }
        }

        java.util.Queue<Node> nodes = new LinkedList<Node>();

        for (int first = 0;first < 2;first++) {
            for (int cat = 1; cat < graph.length; cat++) {
                for (int mouse = 0; mouse < graph.length; mouse++) {
                    if (mouse == 0) { // 老鼠在0
                        cache[first][cat][mouse] = 1;
                        nodes.add(new Node(first, cat, mouse));
                    }
                    if (cat == mouse) { // 猫和老鼠在一个地方
                        cache[first][cat][mouse] = 2;
                        nodes.add(new Node(first, cat, mouse));
                    }
                }
            }
        }

        while (!nodes.isEmpty()) { // 只要nodes非空
            Node node = nodes.poll();

            if (node.first == 0) {
                for (int i = 0;i < graph[node.mouse].length;i++) {
                    int x = graph[node.mouse][i];

                    int pre = cache[1][node.cat][x];
                    if (x == 0 || node.cat == x) {
                        continue;
                    }

                    boolean findWin = false;
                    boolean findDraw = false;
                    for (int j = 0;j < graph[x].length;j++) {
                        int y = graph[x][j];
                        if (cache[0][node.cat][y] == 1) {
                            findWin = true;
                        } else if (cache[0][node.cat][y] == 0) {
                            findDraw = true;
                        }
                    }
                    if (findWin) {
                        cache[1][node.cat][x] = 1;
                    } else if (!findDraw) {
                        cache[1][node.cat][x] = 2;
                    } else {
                        cache[1][node.cat][x] = 0;
                    }

                    if (cache[1][node.cat][x] != pre) {
                        nodes.add(new Node(1, node.cat, x));
                    }
                }
            } else {
                for (int i = 0;i < graph[node.cat].length;i++) {
                    int x = graph[node.cat][i];

                    int pre = cache[0][x][node.mouse];

                    if (x == 0 || node.mouse == x) {
                        continue;
                    }

                    boolean findWin = false;
                    boolean findDraw = false;
                    for (int j = 0;j < graph[x].length;j++) {
                        int y = graph[x][j];
                        if (y == 0) {
                            continue;
                        }
                        if (cache[1][y][node.mouse] == 2) {
                            findWin = true;
                        } else if (cache[1][y][node.mouse] == 0) {
                            findDraw = true;
                        }
                    }
                    if (findWin) {
                        cache[0][x][node.mouse] = 2;
                    } else if (!findDraw) {
                        cache[0][x][node.mouse] = 1;
                    } else {
                        cache[0][x][node.mouse] = 0;
                    }

                    if (pre != cache[0][x][node.mouse]) {
                        nodes.add(new Node(0, x, node.mouse));
                    }
                }
            }
        }

        return cache[1][2][1];
    }

    public int catMouseGame(int[][] graph) {
        int ret = solve(graph);
        return ret;
    }
}

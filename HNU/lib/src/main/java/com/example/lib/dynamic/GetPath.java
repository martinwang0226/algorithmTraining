package com.example.lib.dynamic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create by chenlong.wang
 * 设想有个机器人坐在X × Y网格的左上角，只能向右、向下移动。机器人从(0,0)到(X,Y)有多少种走法？
 * 进阶 假设有些点为“禁区”，机器人不能踏足。设计一种算法，找出一条路径，让机器人从左上角移动到右下角。（第68页）
 * on 2020/8/31
 */
public class GetPath {

    public static void main(String[] args) {

    }

    //递归法

    /**
     * 思路：自上而下
     * 从终点往回走，试着找出到其相邻点的路径。
     *
     * @param x
     * @param y
     * @param path
     * @return
     */
    public static boolean getPath(int x, int y, ArrayList<Point> path) {
        Point p = new Point(x, y);
        path.add(p);
        if (x == 0 && y == 0) {
            return true;//找到路径
        }

        boolean success = false;
        if (x >= 1 && isFree(x - 1, y))//向左走
        {
            success = getPath(x - 1, y, path);
        }
        if (!success && y >= 1 && isFree(x, y - 1)) {//向上走
            success = getPath(x, y - 1, path);
        }
        if (!success) {
            path.add(p);//错误路径
        }
        return success;
    }

    public static boolean isFree(int x, int y) {
        return true;
    }

    /**
     * 思路：缓存先前访问过的点
     *
     * @param x
     * @param y
     * @param path
     * @param cache
     * @return
     */
    public static boolean getPathDP(int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
        Point p = new Point(x, y);
        if (x == 0 & y == 0) {
            return true;
        }
        path.add(p);

        if (cache.containsKey(p)) {//已经访问过这个点
            return cache.get(p);
        }
        boolean success = false;
        if (x >= 1 && isFree(x - 1, y)) {
            success = getPathDP(x - 1, y, path, cache);
        }
        if (y >= 1 && isFree(x, y - 1)) {
            success = getPathDP(x, y - 1, path, cache);
        }

        if (!success) {
            path.add(p);//错误路径的点
        }

        cache.put(p, success);//缓存结果

        return success;
    }
}




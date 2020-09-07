package com.example.lib.ArrayString;

import java.util.ArrayList;

/**
 * Create by chenlong.wang
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * on 2020/9/7
 */
public class MatrixClock {
    public ArrayList<Integer> printMatrixClockwisely(int[][] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int rows = nums.length;
        int cols = nums[0].length;
        if (nums == null || cols <= 0 || rows <= 0) {
            return null;
        }
        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            printMatrixInCircle(list, nums, cols, rows, start);
            ++start;
        }
        return list;

    }


    private void printMatrixInCircle(ArrayList<Integer> list, int[][] nums,
                                     int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; ++i) {
            int number = nums[start][i];
            list.add(number);
        }
        //从上到下打印一列
        if(start < endY){
            for (int i = start + 1; i <= endY; ++i) {
                int number = nums[i][endX];
                list.add(number);
            }
        }
        //从右向左打印一行
        if(start < endX && start < endY){
            for (int i = endX-1; i >= start; --i) {
                int number = nums[endY][i];
                list.add(number);
            }
        }
        //从下向上打印一列
        if(start < endX && start < endY - 1){
            for (int i = endY-1; i >= start + 1; --i) {
                int number = nums[i][start];
                list.add(number);
            }
        }
    }

}

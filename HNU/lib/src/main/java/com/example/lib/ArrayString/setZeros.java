package com.example.lib.ArrayString;

/**
 * Create by chenlong.wang
 * 1.7　编写一个算法，若M×N矩阵中某个元素为0，则将其所在的行与列清零。（第47页）
 * <p>
 * Gayle Laakmann McDowell. 程序员面试金典（第5版） (p. 115). 人民邮电出版社. Kindle 版本.
 * on 2020/9/3
 */
public class setZeros {

    public void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //确认哪些行哪些列需要置0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        //置0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

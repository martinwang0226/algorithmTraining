package com.example.lib.ArrayString;

/**
 * Create by chenlong.wang
 * on 2020/9/3
 */
public class rotate {

    public void rotate(int[][] matrix, int n)
    {
        for (int layer = 0; layer < n / 2; ++layer)
        {
            //layer就是层，从外面一层一层往里。
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i)
            {
                int offset = i - first;
                int top = matrix[first][i];
                //左到上
                matrix[first][i] = matrix[last - offset][first];
                //下到左
                matrix[last - offset][first] = matrix[last][last - offset];
                //右到下
                matrix[last][last - offset] = matrix[i][last];
                //上到右
                matrix[i][last] = top;
            }
        }
    }
}

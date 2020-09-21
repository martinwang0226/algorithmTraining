package com.example.lib.heap;

/**
 * Create by chenlong.wang
 * 求一组动态数据集合的最大 Top K
 * https://www.cnblogs.com/mm962464/p/13064206.html
 * 堆：分为大顶堆（堆顶元素大于其他所有元素）和小顶堆（堆顶其他元素小于所有其他元素）
 * <p>
 * 我们使用小顶堆来实现，为什么不适用大顶堆下面会介绍~
 * <p>
 * 取出K个元素放在另外的数组中，对这K个元素进行建堆 ps:堆排序请参考：https://blog.csdn.net/CSDN___LYY/article/details/81454613
 * <p>
 * 然后循环从K下标位置遍历数据，只要元素大于堆顶，我们就将堆顶赋值为该元素，然后重新调整为小顶堆
 * <p>
 * 循环完毕后，K个元素的堆数组就是我们所需要的TopK
 * <p>
 * 为什么使用小顶堆呢？
 * <p>
 * 我们在比较的过程中使用堆顶是最小值的小顶堆，元素大于堆顶我们对堆顶进行重新赋值，那么堆顶永远是这K个值中最小的值，当我们下一个元素和堆顶比较时，如果不大于堆顶的话，那么一定不属于topK范围的
 * on 2020/9/21
 */
public class topk {

    public static void main(String[] args) {
        // 源数据
        int[] data = {56, 275, 12, 6, 45, 478, 41, 1236, 456, 12, 546, 45};

// 获取Top5
        int[] top5 = topK(data, 5);

        for (int i = 0; i < 5; i++) {
            System.out.println(top5[i]);
        }
    }

    // 从data数组中获取最大的k个数
    private static int[] topK(int[] data, int k) {
        // 先取K个元素放入一个数组topk中
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = data[i];
        }

        // 转换成最小堆
        MinHeap heap = new MinHeap(topk);

        // 从k开始，遍历data
        for (int i = k; i < data.length; i++) {
            int root = heap.getRoot();

            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
            if (data[i] > root) {
                heap.setRoot(data[i]);
            }
        }

        return topk;
    }
}

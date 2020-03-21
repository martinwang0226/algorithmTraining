package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class reverseNum {
    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public int reverse(int x) {
        if (x == -2147483648) { //如果不做这个判断，下面的x=-x将会报错
            return 0;
        }
        if (x < 0) { // 判断是否为负数
            return -reverse(-x); // 如果是负数则取绝对值调用自身，最后将结果转为负数
        }
        int res = 0;
        while (x != 0) { // 每次得到最后一位数字，并将其作为结果中的当前最高位
            if (res > 214748364) { // 处理溢出
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res <= 0x7fffffff ? res : 0; // 如果溢出就返回0
    }
}

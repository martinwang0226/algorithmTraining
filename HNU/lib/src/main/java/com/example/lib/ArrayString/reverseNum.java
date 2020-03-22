package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class reverseNum {
    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    //我们int型的数值范围是 -2147483648～2147483647 (-2^31 ~ 2^31 - 1)，
    // 那么如果我们要翻转 1000000009 这个在数值范围内的数，得到 9000000001，但翻转后的数就超过了范围，
    // 这个情况就是溢出，这个时候程序返回 0 即可。
    //如果输入的是负数，就递归调用原函数，参数变成 -x 即可，代码大致执行流程如下
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

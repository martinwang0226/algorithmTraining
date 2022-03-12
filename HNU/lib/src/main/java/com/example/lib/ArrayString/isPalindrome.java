package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class isPalindrome {

    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    //时间复杂度: O(N) 空间复杂度: O(N)
    public boolean isPalindrome(int x) {
        if (x < 0) { // 排除小于0的数
            return false;
        }
        String str = String.valueOf(x);
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) { // 通过字符串前后对应字符比较，对比数字是否相等就行
                return false;
            }
        }
        return true;
    }

    // (满足Follow up)：时间复杂度: O(1) 空间复杂度: O(1)
//    刚才我们在思路 1 中通过将整数转为字符串处理，现在我们不转了，直接用整数类型来判断是否是回文数。
// 首先负数肯定不是回文数，这个不用多说。其次就是如果一个数字为正整数，而且能够被 10 整除，那么这个数字也不是回文数，因为回文数的首位肯定不是 0 。
//
//    那么不把整数转为字符串该怎么做呢？还记得在 2.2 小节整数反转么？
//
//    没错，我们直接把整数反转过来，与原来的值比较即可。如果印象不深刻的同学可以去重新看下2.2小节。

    public boolean isPalindrome2(int x) {
        if (x < 0) { // 负数肯定不是palindrome
            return false;
        }
        int temp = x;
        // 翻转之后的数字可能超过整型的范围
        long y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return temp == y;
    }

}

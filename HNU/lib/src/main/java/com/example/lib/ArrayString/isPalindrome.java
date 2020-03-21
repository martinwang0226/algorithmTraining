package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
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

    public boolean isPalindrome2(int x) {
        if (x < 0) { // 负数肯定不是palindrome
            return false;
        }
        int temp = x;
        // 翻转之后的数字可能超过整型的范围
        long y = 0;
        while ( x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return  temp == y;
    }

}

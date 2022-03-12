package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class convertZOrder {

    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) { // numRows为1时需要特判
            return s;
        }
        String res = "";
        int step = numRows - 1;
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                res += s.charAt(j);
                if (i == 0 || i == numRows - 1) { // 第一行和最后一行
                    j += 2 * step;
                } else { // 其它行
                    j += 2 * (step - j % step);
                }
            }
        }
        return res;
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1) { // numRows为1时需要特判
            return s;
        }
        String res = "";
        int step = numRows - 1;
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                res += s.charAt(j);
                if (i == 0 || i == numRows - 1) { // 第一行和最后一行
                    j += 2 * step;
                } else { // 其它行
                    j += 2 * (step - j % step);
                }
            }
        }
        return res;
    }
}

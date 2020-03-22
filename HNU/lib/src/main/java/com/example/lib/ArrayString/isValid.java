package com.example.lib.ArrayString;

import java.util.Stack;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *  1.左括号必须用相同类型的右括号闭合。
 *  2.左括号必须以正确的顺序闭合。
 *
 * 注意：空字符串可被认为是有效字符串。
 */
public class isValid {
    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    //时间复杂度: O(N^2) 空间复杂度: O(N)
    public boolean isValid(String s) {
        int length;
        while (true) {
            length = s.length();
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
            if (length == s.length()) {
                break;
            }
        }
        return length == 0;
    }

    //思路 2：时间复杂度: O(N) 空间复杂度: O(N)
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 如果是左括号就入栈
            if (s.charAt(i) == '{'|| s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            // 如果是右括号就判断栈是否为空，以及栈顶是否和右括号匹配，如果不匹配直接可以返回 false
            if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        // 如果全部匹配，则栈为空，否则不为空
        return stack.isEmpty();
    }
}

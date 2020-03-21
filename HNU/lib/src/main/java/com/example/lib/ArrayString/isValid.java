package com.example.lib.ArrayString;

import java.util.Stack;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class isValid {
    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

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

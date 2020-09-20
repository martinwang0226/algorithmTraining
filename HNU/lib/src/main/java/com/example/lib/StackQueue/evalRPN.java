package com.example.lib.StackQueue;

import java.util.Stack;

/**
 * Create by chenlong.wang
 * Evaluate Reverse Polish Notatio（逆波兰表达式求值）
 * on 2020/9/20
 */
public class evalRPN {
    public int evalRPN(String[] tokens) {
        int a = 0, b = 0;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if (s.equals("+"))
                S.add(S.pop() + S.pop());
            else if (s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            } else if (s.equals("*"))
                S.add(S.pop() * S.pop());
            else if (s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            } else
                S.add(Integer.parseInt(s));
        }
        return S.pop();

    }
}

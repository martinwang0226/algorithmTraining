package com.example.lib.ArrayString;

import java.util.ArrayList;
import java.util.List;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class generateParenthesis {

    public static void main(String[] args) {
        System.out.print("链表中的两数相加" + "=======================");
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        singleStr(result,"",0,0,n);
        return result;
    }

    private void singleStr(List<String> result, String str,int left, int right, int n){
        if (left == n && right == n) {
            result.add(str);
        }
        if (left < n) {
            singleStr(result,str + "(", left + 1,right,n);
        }
        if (right < left) {
            singleStr(result, str + ")", left, right+1,n);
        }
    }
}

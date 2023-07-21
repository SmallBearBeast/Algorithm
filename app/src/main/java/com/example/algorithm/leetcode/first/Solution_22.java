package com.example.algorithm.leetcode.first;
//
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
//For example, given n = 3, a solution set is:
//
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_22 {
    public static void main(String[] args) {
        Solution_22 solution = new Solution_22();
        solution.mySolution(4);
    }

    // 闭合数
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public List<String> mySolution(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        if (n == 0)
            return result.get(0);
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
//        char[] parentheses = new char[n << 1];
//        List<String> result = new ArrayList<>();
//        fill(result, 0, 0, parentheses);
//        return result;
    }

    public void fill(List<String> result, int openCount, int closeCount, char[] parentheses) {
        if (openCount + closeCount == parentheses.length) {
            result.add(new String(parentheses));
            return;
        }
        if (openCount > closeCount) {
            if (openCount < parentheses.length / 2) {
                parentheses[openCount + closeCount] = '(';
                fill(result, openCount + 1, closeCount, parentheses);
            }
            if (closeCount < parentheses.length / 2) {
                parentheses[openCount + closeCount] = ')';
                fill(result, openCount, closeCount + 1, parentheses);
            }
        } else {
            if (openCount < parentheses.length / 2) {
                parentheses[openCount + closeCount] = '(';
                fill(result, openCount + 1, closeCount, parentheses);
            }
        }
    }
}

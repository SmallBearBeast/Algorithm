package com.example.algorithm.leetcode.second;

import java.util.Stack;

public class Solution_2390 {
    public static void main(String[] args) {
        Solution_2390 solution_2390 = new Solution_2390();
        System.out.println(solution_2390.mySolution_1("erase*****"));
    }


    // 栈方法
    public String mySolution_1(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c != '*') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                char top = stack.pop();
                if (top == '*') {
                    stack.push(top);
                }
            }
        }
        char[] result = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }

    // StringBuilder
    public String mySolution_2(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                res.append(s.charAt(i));
            } else {
                res.deleteCharAt(res.length() - 1);
            }
        }
        return res.toString();
    }
}

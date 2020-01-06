package com.example.algorithm.leetcode;
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
// Note that an empty string is also considered valid.
//
// Example 1:
//
//
//Input: "()"
//Output: true
//
//
// Example 2:
//
//
//Input: "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: "(]"
//Output: false
//
//
// Example 4:
//
//
//Input: "([)]"
//Output: false
//
//
// Example 5:
//
//
//Input: "{[]}"
//Output: true
//
// Related Topics String Stack


import java.util.Stack;

public class Solution_20 {
    public static void main(String[] args) {
        Solution_20 solution = new Solution_20();
        solution.mySolution("[]");
    }
    public boolean isValid(String s) {
        return false;
    }

    public boolean mySolution(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0, length = s.length(); i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char top = stack.pop();
                char temp = s.charAt(i);
                if (!(top == '[' && temp== ']') && !(top == '{' && temp == '}') && !(top == '(' && temp == ')')) {
                    stack.push(top);
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}

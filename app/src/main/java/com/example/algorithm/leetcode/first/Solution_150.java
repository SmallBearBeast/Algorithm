package com.example.algorithm.leetcode.first;
//根据逆波兰表示法，求表达式的值。
//
// 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//
// 说明：
//
//
// 整数除法只保留整数部分。
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
//
//
// 示例 1：
//
// 输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: ((2 + 1) * 3) = 9
//
//
// 示例 2：
//
// 输入: ["4", "13", "5", "/", "+"]
//输出: 6
//解释: (4 + (13 / 5)) = 6
//
//
// 示例 3：
//
// 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//输出: 22
//解释:
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// Related Topics 栈

import java.util.Stack;

public class Solution_150 {
    public static void main(String[] args) {
        Solution_150 solution = new Solution_150();
    }

    public int evalRPN(String[] tokens) {
        return 1;
    }

    public int mySolution(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(tokens[i]);
            } else {
                int op_2 = Integer.valueOf(stack.pop());
                int op_1 = Integer.valueOf(stack.pop());
                int val = 0;
                switch (tokens[i]) {
                    case "+":
                        val = op_1 + op_2;
                        break;
                    case "-":
                        val = op_1 - op_2;
                        break;
                    case "*":
                        val = op_1 * op_2;
                        break;
                    case "/":
                        val = op_1 / op_2;
                        break;
                }
                stack.push(String.valueOf(val));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public int mySolution_2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}

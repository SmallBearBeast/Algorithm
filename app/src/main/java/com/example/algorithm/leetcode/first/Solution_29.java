package com.example.algorithm.leetcode.first;
//Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
//
// Return the quotient after dividing dividend by divisor.
//
// The integer division should truncate toward zero.
//
// Example 1:
//
//
//Input: dividend = 10, divisor = 3
//Output: 3
//
// Example 2:
//
//
//Input: dividend = 7, divisor = -3
//Output: -2
//
// Note:
//
//
// Both dividend and divisor will be 32-bit signed integers.
// The divisor will never be 0.
// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
//
// Related Topics Math Binary Search

public class Solution_29 {
    public static void main(String[] args) {
        Solution_29 solution = new Solution_29();
        solution.mySolution(0 ,1);
    }

    public int divide(int dividend, int divisor) {
        return 1;
    }

    // 考虑下不使用long解法
    public int mySolution(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int length = 0;
        long[] base = new long[33];
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        while (length == 0 || base[length - 1] < absDividend) {
            base[length] = absDivisor << length;
            length ++;
        }

        long result = 0;
        for (int i = length - 1; i >= 0 && absDividend >= absDivisor; i--) {
            if (absDividend - base[i] >= 0) {
                absDividend = absDividend - base[i];
                result = result + (1 << i);
            }
        }
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            return (int) result;
        }
        return (int) -result;
    }

}

package com.example.algorithm.leetcode.first;
//Given a 32-bit signed integer, reverse digits of an integer.
//
// Example 1:
//
//
//Input: 123
//Output: 321
//
//
// Example 2:
//
//
//Input: -123
//Output: -321
//
//
// Example 3:
//
//
//Input: 120
//Output: 21
//
//
// Note:
//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
// Related Topics Math

public class Solution_7 {
    public static void main(String[] args) {
        Solution_7 solution_7 = new Solution_7();
        solution_7.mySolution(Integer.MIN_VALUE);
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int mySolution(int x) {
        boolean positive = x >= 0;
        long temp = Math.abs((long) x);
        int base = 1;
        long result = 0;
        while (temp >= 10) {
            temp = temp / 10;
            base = base * 10;
        }
        temp = Math.abs((long) x);
        while (temp > 0) {
            result = temp % 10 * base + result;
            base = base / 10;
            temp = temp / 10;
        }
        if (positive) {
            result = result > Integer.MAX_VALUE ? 0 : result;
        } else {
            result = result - 1 > Integer.MAX_VALUE ? 0 : -result;
        }
        return (int) result;
    }
}

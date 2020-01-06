package com.example.algorithm.leetcode;
//Given an integer n, return the number of trailing zeroes in n!.
//
// Example 1:
//
//
//Input: 3
//Output: 0
//Explanation: 3! = 6, no trailing zero.
//
// Example 2:
//
//
//Input: 5
//Output: 1
//Explanation: 5! = 120, one trailing zero.
//
// Note: Your solution should be in logarithmic time complexity.
// Related Topics Math

public class Solution_172 {
    public static void main(String[] args) {
        Solution_172 solution = new Solution_172();
        solution.mySolution(100);
    }

    public int trailingZeroes(int n) {
        return 1;
    }

    public int mySolution(int n) {
        int res = 0;
        while (n != 0) {
            n = n / 5;
            res = res + n;
        }
        return res;
    }
}

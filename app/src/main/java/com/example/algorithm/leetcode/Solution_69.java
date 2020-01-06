package com.example.algorithm.leetcode;
//Implement int sqrt(int x).
//
// Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
// Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
//
// Example 1:
//
//
//Input: 4
//Output: 2
//
//
// Example 2:
//
//
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since
//             the decimal part is truncated, 2 is returned.
//
// Related Topics Math Binary Search

public class Solution_69 {
    public static void main(String[] args) {
        Solution_69 solution = new Solution_69();
        solution.mySolution_3(6);

    }

    public int mySqrt(int x) {
        return 1;
    }

    // 暴力
    public int mySolution_1(int x) {
        for (int i = 1; i <= x; i++) {
            if (x / i == i) {
                return i;
            } else if (x / i < i) {
                return i - 1;
            }
        }
        return 0;
    }


    public int mySolution_2(int x) {
        if (x <= 1) {
            return x;
        }
        int start = 1;
        int end = x;
        while (start < end) {
            int mid = (start + end) / 2;
            int val = x / mid;
            if (val > mid) {
                start = mid + 1;
            } else if (val < mid) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        if (x / start < start) {
            return start - 1;
        }
        return start;
    }

    // 牛顿法
    public int mySolution_3(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}

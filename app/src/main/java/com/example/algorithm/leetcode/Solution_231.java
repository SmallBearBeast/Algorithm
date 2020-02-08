package com.example.algorithm.leetcode;

//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1:
//
// 输入: 1
//输出: true
//解释: 20 = 1
//
// 示例 2:
//
// 输入: 16
//输出: true
//解释: 24 = 16
//
// 示例 3:
//
// 输入: 218
//输出: false
// Related Topics 位运算 数学

public class Solution_231 {
    public static void main(String[] args) {
        Solution_231 solution = new Solution_231();
    }

    public boolean isPowerOfTwo(int n) {
        return false;
    }

    public boolean mySolution_1(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }

    // 位运算
    public boolean mySolution_2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

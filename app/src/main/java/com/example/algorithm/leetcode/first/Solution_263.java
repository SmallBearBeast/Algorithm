package com.example.algorithm.leetcode.first;

//编写一个程序判断给定的数是否为丑数。
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。
//
// 示例 1:
//
// 输入: 6
//输出: true
//解释: 6 = 2 × 3
//
// 示例 2:
//
// 输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
//
//
// 示例 3:
//
// 输入: 14
//输出: false
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。
//
// 说明：
//
//
// 1 是丑数。
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。
//
// Related Topics 数学

public class Solution_263 {
    public static void main(String[] args) {
        Solution_263 solution = new Solution_263();
        boolean result = solution.mySolution_2(3);
        System.out.println("result = " + result);
    }

    public boolean isUgly(int num) {
        return false;
    }

    public boolean mySolution_1(int num) {
        if (num <= 0) {
            return false;
        }
        while ((num % 2) == 0) {
            num = num / 2;
        }
        while ((num % 3) == 0) {
            num = num / 3;
        }
        while ((num % 5) == 0) {
            num = num / 5;
        }
        return num == 1;
    }

    /**
     * 递归写法
     */
    public boolean mySolution_2(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int temp = num;
        if ((num % 2) == 0) {
            num = num / 2;
        }
        if ((num % 3) == 0) {
            num = num / 3;
        }
        if ((num % 5) == 0) {
            num = num / 5;
        }
        if (temp == num) {
            return false;
        }
        return mySolution_2(num);
    }

}

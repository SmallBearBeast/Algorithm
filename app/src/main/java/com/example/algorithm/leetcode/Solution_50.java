package com.example.algorithm.leetcode;
//Implement pow(x, n), which calculates x raised to the power n (xn).
//
// Example 1:
//
//
//Input: 2.00000, 10
//Output: 1024.00000
//
//
// Example 2:
//
//
//Input: 2.10000, 3
//Output: 9.26100
//
//
// Example 3:
//
//
//Input: 2.00000, -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
//
//
// Note:
//
//
// -100.0 < x < 100.0
// n is a 32-bit signed integer, within the range [−231, 231 − 1]
//
// Related Topics Math Binary Search

public class Solution_50 {
    public static void main(String[] args) {
        Solution_50 solution = new Solution_50();
        double result = solution.mySolution_1(2, 9);
        result = 1;
    }

    public double myPow(double x, int n) {
        return 1;
    }

    public double mySolution_1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long tempN = Math.abs((long) n);
        long pos = 1;
        long[] posArray = new long[32];
        double[] xArray = new double[32];
        int index = 0;
        while (pos <= tempN) {
            posArray[index] = pos;
            xArray[index] = x;
            x = x * x;
            pos = pos << 1;
            index++;
        }
        double result = 1.0;
        for (int i = index - 1; i >= 0; i--) {
            if (tempN - posArray[i] >= 0) {
                tempN = tempN - posArray[i];
                result = result * xArray[i];
                if (tempN == 0) {
                    break;
                }
            }
        }
        return n > 0 ? result : 1 / result;
    }

    public double mySolution_2(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public double mySolution_3(double x, int n) {
        double res = recursive_3(x, Math.abs((long) n));
        return n < 0 ? 1 / res : res;
    }

    public double recursive_3(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double res = recursive_3(x, n / 2);
        res = res * res;
        if (n % 2 == 1) {
            res = res * x;
        }
        return res;
    }

}

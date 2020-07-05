package com.example.algorithm.leetcode;

public class Solution_201 {
    public static void main(String[] args) {
        Solution_201 solution = new Solution_201();
        int result = solution.mySolution_3(1, 7);
        System.out.println("result = " + result);
    }

    public int rangeBitwiseAnd(int m, int n) {
        return 1;
    }

    public int mySolution_1(int m, int n) {
        int num = n - m + 1;
        int bitNum = 0;
        int temp = n;
        while (temp > 0) {
            bitNum++;
            temp = temp >> 1;
        }
        int step = 1;
        int result = 0;
        for (int i = 0; i < bitNum; i++) {
            if (num <= step) {
                int start = m & 1;
                int end = n & 1;
                if (start == 1 && start == end) {
                    result = result + step;
                }
            }
            step = 2 * step;
            m = m >> 1;
            n = n >> 1;
        }
        return result;
    }

    // 公共前缀法
    public int mySolution_2(int m, int n) {
        int shift = 0;
        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            shift++;
        }
        return m << shift;
    }

    // 汉明距离求公共前缀法
    public int mySolution_3(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return m & n;
    }
}

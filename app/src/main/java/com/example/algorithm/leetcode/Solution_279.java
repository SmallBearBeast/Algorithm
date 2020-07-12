package com.example.algorithm.leetcode;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 示例 1:
//
// 输入: n = 12
//输出: 3
//解释: 12 = 4 + 4 + 4.
//
// 示例 2:
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9.
// Related Topics 广度优先搜索 数学 动态规划

import java.util.HashSet;
import java.util.Set;

public class Solution_279 {
    public Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Solution_279 solution = new Solution_279();
        int result = solution.mySolution_4(2);
        System.out.println("result = " + result);
    }

    public int numSquares(int n) {
        return 1;
    }

    public int mySolution_1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 1; j--) {
                dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
                if (dp[i] == 2) {
                    break;
                }
            }
        }
        return dp[n];
    }

    // 硬币问题
    public int mySolution_2(int n) {
        int length = (int) Math.sqrt(n);
        if (length * length == n) {
            return 1;
        }
        int[] values = new int[length];
        for (int i = 1; i <= length; i++) {
            values[i - 1] = i * i;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < values.length; j++) {
                if (i < values[j]) {
                    break;
                }
                dp[i] = Math.min(dp[i - values[j]] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    public boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    public int mySolution_3(int n) {
        // four-square and three-square theorems.
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        if (isSquare(n)) {
            return 1;
        }
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i)) {
                return 2;
            }
        }
        // bottom case of three-square theorem.
        return 3;
    }

    // 贪心 + dfs
    public int mySolution_4(int n) {
        int length = (int) Math.sqrt(n) + 1;
        for (int i = 1; i <= length; i++) {
            set.add(i * i);
        }
        int count = 1;
        for (; count <= length; count++) {
            if (isSuccess(n, count)) {
                return count;
            }
        }
        return count;
    }

    public boolean isSuccess(int n, int count) {
        if (n < 1) {
            return false;
        }
        if (count == 1) {
            return set.contains(n);
        }
        for (Integer value : set) {
            if (isSuccess(n - value, count - 1)) {
                return true;
            }
        }
        return false;
    }
}

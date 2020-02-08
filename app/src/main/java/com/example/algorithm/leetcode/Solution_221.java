package com.example.algorithm.leetcode;

//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
// Related Topics 动态规划

public class Solution_221 {
    public static void main(String[] args) {
        Solution_221 solution = new Solution_221();
    }

    public int maximalSquare(char[][] matrix) {
        return 1;
    }

    public int mySolution_1(char[][] matrix) {
        return 1;
    }

    // 动态规划
    public int mySolution_2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxLen = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }

    // 优化动态规划，一维数组
    public int mySolution_3(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxLen = 0;
        int prev = 0;
        int[] dp = new int[matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), prev) + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxLen * maxLen;
    }
}

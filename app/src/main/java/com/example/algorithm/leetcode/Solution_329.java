package com.example.algorithm.leetcode;

//给定一个整数矩阵，找出最长递增路径的长度。
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
//
// 示例 1:
//
// 输入: nums =
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//]
//输出: 4
//解释: 最长递增路径为 [1, 2, 6, 9]。
//
// 示例 2:
//
// 输入: nums =
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//]
//输出: 4
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
//
// Related Topics 深度优先搜索 拓扑排序 记忆化

public class Solution_329 {
    public static void main(String[] args) {
        Solution_329 solution = new Solution_329();
        int result = solution.mySolution_1(new int[][]{
                {1}
        });
        System.out.println("result = " + result);
    }

    public int longestIncreasingPath(int[][] matrix) {
        return 1;
    }

    // dfs + dp
    public int mySolution_1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                recursive_1(matrix, dp, i, j);
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public void recursive_1(int[][] matrix, int[][] dp, int x, int y) {
        if (x < 0 || x >= matrix.length) {
            return;
        }
        if (y < 0 || y >= matrix[0].length) {
            return;
        }
        if (dp[x][y] > 0) {
            return;
        }
        if (x > 0) {
            if (matrix[x][y] < matrix[x - 1][y]) {
                recursive_1(matrix, dp, x - 1, y);
                dp[x][y] = Math.max(dp[x - 1][y] + 1, dp[x][y]);
            }
        }
        if (x < matrix.length - 1) {
            if (matrix[x][y] < matrix[x + 1][y]) {
                recursive_1(matrix, dp, x + 1, y);
                dp[x][y] = Math.max(dp[x + 1][y] + 1, dp[x][y]);
            }
        }
        if (y > 0) {
            if (matrix[x][y] < matrix[x][y - 1]) {
                recursive_1(matrix, dp, x, y - 1);
                dp[x][y] = Math.max(dp[x][y - 1] + 1, dp[x][y]);
            }
        }
        if (y < matrix[0].length - 1) {
            if (matrix[x][y] < matrix[x][y + 1]) {
                recursive_1(matrix, dp, x, y + 1);
                dp[x][y] = Math.max(dp[x][y + 1] + 1, dp[x][y]);
            }
        }
        dp[x][y] = Math.max(dp[x][y], 1);
    }

    public int mySolution_2(int[][] matrix) {
        return 1;
    }

}

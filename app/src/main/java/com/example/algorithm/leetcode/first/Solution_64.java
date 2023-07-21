package com.example.algorithm.leetcode.first;
//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example:
//
//
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//
// Related Topics Array Dynamic Programming

public class Solution_64 {
    public static void main(String[] args) {
        Solution_64 solution_3 = new Solution_64();
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        solution_3.minPathSum_1(grid);
    }

    // 二维数组动态规划
    public int minPathSum_1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    // 一维数组动态规划
    public int minPathSum_2(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + Math.min(dp[j + 1], dp[j]);
                } else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }

    // 不需要额外存储空间
    public int minPathSum_3(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
                } else {
                    grid[i][j] = grid[i][j];
                }
            }
        }
        return grid[0][0];
    }


    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int minLen = Math.min(row, column);
        int[] curDp = new int[minLen];
        int[] lastDp = new int[minLen];
        int size = row + column;
        int i = 1;
        while (i < size) {
            int x = i <= row ? i - 1 : row - 1;
            int y = i - x - 1;
            int len = Math.min(Math.min(i, minLen), size - i);
            for (int j = 0; j < len; j++) {
                if (x == 0 && y == 0) {
                    curDp[j] = grid[x][y];
                } else if (x - j > 0 && y + j > 0) {
                    curDp[j] = Math.min(lastDp[j - 1], lastDp[j]) + grid[x - j][y + j];
                } else if (y + j > 0) {
                    curDp[j] = lastDp[j - 1] + grid[x - j][y + j];
                } else if (x - j > 0) {
                    curDp[j] = lastDp[j] + grid[x - j][y + j];
                }
            }
            for (int j = 0; j < minLen; j++) {
                lastDp[j] = curDp[j];
            }
            i++;
        }
        return 0;
    }

    public int mySolution(int[][] grid) {
        int result = add(grid, 0, 0);
        return result;
    }

    public int add(int[][] routes, int startX, int startY) {
        int result = 0;
        if (startX == routes.length - 1) {
            for (int i = startY; i < routes[0].length; i++) {
                result = result + routes[startX][i];
            }
        } else if (startY == routes[0].length - 1) {
            for (int i = startX; i < routes.length; i++) {
                result = result + routes[i][startY];
            }
        } else {
            result = routes[startX][startY] +
                    Math.min(add(routes, startX + 1, startY), add(routes, startX, startY + 1));
        }
        return result;
    }
}

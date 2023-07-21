package com.example.algorithm.leetcode.first;
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
//
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
//
//
// Example 2:
//
//
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
// Related Topics Depth-first Search Breadth-first Search Union Find

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_200 {
    public static void main(String[] args) {
        Solution_200 solution = new Solution_200();
        solution.mySolution_2(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '1', '0', '0'},
                {'1', '0', '1', '1', '0'},
                {'1', '0', '0', '1', '1'},
        });
    }

    public int numIslands(char[][] grid) {
        return 1;
    }

    public int mySolution_1(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs_1(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    public void dfs_1(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs_1(grid, i, j + 1);
        dfs_1(grid, i, j - 1);
        dfs_1(grid, i + 1, j);
        dfs_1(grid, i - 1, j);
    }

    public int mySolution_2(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            i = queue.poll();
            j = queue.poll();
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                queue.add(i);
                queue.add(j + 1);
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                queue.add(i);
                queue.add(j - 1);
            }
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                queue.add(i + 1);
                queue.add(j);
            }
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                queue.add(i - 1);
                queue.add(j);
            }
        }
    }

    public int mySolution_3(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs_3(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    public void dfs_3(char[][] grid, int i, int j) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        stack.push(j);
        grid[i][j] = '0';
        while (!stack.isEmpty()) {
            j = stack.pop();
            i = stack.pop();
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                stack.add(i);
                stack.add(j + 1);
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                stack.add(i);
                stack.add(j - 1);
            }
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                stack.add(i + 1);
                stack.add(j);
            }
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                stack.add(i - 1);
                stack.add(j);
            }
        }
    }
}

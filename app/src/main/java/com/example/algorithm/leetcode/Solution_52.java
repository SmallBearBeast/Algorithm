package com.example.algorithm.leetcode;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
//
// 示例:
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

public class Solution_52 {
    public static void main(String[] args) {
        Solution_52 solution = new Solution_52();
    }

    public int totalNQueens(int n) {
        return 1;
    }

    public int mySolution_1(int n) {
        int[] columns = new int[n];
        int[] k_1s = new int[n << 1];
        int[] k_2s = new int[n << 1];
        dfs_1(0, n, columns, k_1s, k_2s);
        return count;
    }

    public int mySolution_2(int n) {
        int[] columns = new int[n];
        int[] k_1s = new int[n << 1];
        int[] k_2s = new int[n << 1];
        return dfs_2(0, n, columns, k_1s, k_2s);
    }

    public int count = 0;
    public void dfs_1(int index, int n, int[] columns, int[] k_1s, int[] k_2s) {
        if (index == n) {
            count ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns[i] == 0 && k_1s[index + i] == 0 && k_2s[n + i - index] == 0) {
                columns[i] = 1;
                k_1s[index + i] = 1;
                k_2s[n + i - index] = 1;
                dfs_1(index + 1, n, columns, k_1s, k_2s);
                columns[i] = 0;
                k_1s[index + i] = 0;
                k_2s[n + i - index] = 0;
            }
        }
    }

    public int dfs_2(int index, int n, int[] columns, int[] k_1s, int[] k_2s) {
        if (index == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (columns[i] == 0 && k_1s[index + i] == 0 && k_2s[n + i - index] == 0) {
                columns[i] = 1;
                k_1s[index + i] = 1;
                k_2s[n + i - index] = 1;
                count = count + dfs_2(index + 1, n, columns, k_1s, k_2s);
                columns[i] = 0;
                k_1s[index + i] = 0;
                k_2s[n + i - index] = 0;
            }
        }
        return count;
    }
}

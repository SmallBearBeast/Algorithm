package com.example.algorithm.leetcode;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.List;

public class Solution_51 {
    public static void main(String[] args) {
        Solution_51 solution = new Solution_51();
        solution.mySolution_1(3);
    }

    public List<List<String>> solveNQueens(int n) {
        return null;
    }

    public List<List<String>> mySolution_1(int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        int[] columns = new int[n];
        int[] k_1s = new int[n << 1];
        int[] k_2s = new int[n << 1];
        dfs(0, res, matrix, columns, k_1s, k_2s);
        return res;
    }

    public void dfs(int index, List<List<String>> res, char[][] matrix, int[] columns, int[] k_1s, int[] k_2s) {
        if (index == matrix.length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                temp.add(new String(matrix[i]));
            }
            res.add(temp);
            return;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (columns[i] == 0 && k_1s[index + i] == 0 && k_2s[matrix.length + i - index] == 0) {
                matrix[index][i] = 'Q';
                columns[i] = 1;
                k_1s[index + i] = 1;
                k_2s[matrix.length + i - index] = 1;
                dfs(index + 1, res, matrix, columns, k_1s, k_2s);
                matrix[index][i] = '.';
                columns[i] = 0;
                k_1s[index + i] = 0;
                k_2s[matrix.length + i - index] = 0;
            }
        }
    }

    public List<List<String>> mySolution_2(int n) {
        return null;
    }

}

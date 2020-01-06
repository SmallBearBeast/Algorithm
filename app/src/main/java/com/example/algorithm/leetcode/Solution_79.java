package com.example.algorithm.leetcode;
//Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// Example:
//
//
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.
//
// Related Topics Array Backtracking

public class Solution_79 {
    public static void main(String[] args) {
        Solution_79 solution = new Solution_79();
        solution.mySolution(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCEDAF");
    }

    public boolean exist(char[][] board, String word) {
        return false;
    }

    public boolean mySolution(char[][] board, String word) {
        boolean[][] check = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, word, 0, check)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, String word, int index, boolean[][] check) {
        if (index == word.length()) {
            return true;
        }
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (check[i][j]) {
                return false;
            }
            if (board[i][j] != word.charAt(index)) {
                return false;
            }
            check[i][j] = true;
            if (search(board, i + 1, j, word, index + 1, check)
                    || search(board, i - 1, j, word, index + 1, check)
                    || search(board, i, j + 1, word, index + 1, check)
                    || search(board, i, j - 1, word, index + 1, check)) {
                return true;
            }
            check[i][j] = false;
        }
        return false;
    }
}

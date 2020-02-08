package com.example.algorithm.leetcode;

//编写一个程序，通过已填充的空格来解决数独问题。
//
// 一个数独的解法需遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
// 空白格用 '.' 表示。
//
//
//
// 一个数独。
//
//
//
// 答案被标成红色。
//
// Note:
//
//
// 给定的数独序列只包含数字 1-9 和字符 '.' 。
// 你可以假设给定的数独只有唯一解。
// 给定数独永远是 9x9 形式的。
//
// Related Topics 哈希表 回溯算法

public class Solution_37 {
    public static void main(String[] args) {
        Solution_37 solution = new Solution_37();
        solution.mySolution_1(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        });
    }

    public void solveSudoku(char[][] board) {

    }

    public void mySolution_1(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] columns = new int[9][10];
        int[][] squares = new int[9][10];
        int temp = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    temp = board[i][j] - '0';
                    rows[i][temp] = 1;
                    columns[j][temp] = 1;
                    squares[i / 3 * 3 + j / 3][temp] = 1;
                }
            }
        }
        dfs(board, 0, 0, rows, columns, squares);
//        for (int i = 0; i < 9; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
    }

    public boolean dfs(char[][] board, int x, int y, int[][] rows, int[][] columns, int[][] squares) {
        if (x == 9) {
            return true;
        }
        for (int i = y; i < 9; i++) {
            if (board[x][i] == '.') {
                for (int j = 1; j <= 9; j++) {
                    if (rows[x][j] != 1 && columns[i][j] != 1 && squares[x / 3 * 3 + i / 3][j] != 1) {
                        board[x][i] = (char) (j + '0');
                        rows[x][j] = 1;
                        columns[i][j] = 1;
                        squares[x / 3 * 3 + i / 3][j] = 1;
                        if (dfs(board, x, i + 1, rows, columns, squares)) {
                            return true;
                        }
                        board[x][i] = '.';
                        rows[x][j] = 0;
                        columns[i][j] = 0;
                        squares[x / 3 * 3 + i / 3][j] = 0;
                    }
                }
                return false;
            }
        }
        return dfs(board, x + 1, 0, rows, columns, squares);
    }

    public void mySolution_2(char[][] board) {

    }

}

package com.example.algorithm.leetcode;

public class Tecent_1 {

    public static void main(String[] args) {
        Tecent_1 tecent1 = new Tecent_1();
        int[][] matrix_1 = {
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };
        tecent1.printLeftPos(matrix_1);



        System.out.println("result_1 = " + tecent1.existAttact_1(matrix_1));

        int[][] matrix_2 = {
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 1},
        };
//        System.out.println("result_2 = " + tecent1.existAttact_2(matrix_2));
//
//
//        System.out.println("leftCount_1 = " + tecent1.leftCount(matrix_1));
//
//        System.out.println("leftCount_2 = " + tecent1.leftCount(matrix_1));

//        tecent1.printLeftPos(matrix_1);
    }

    // 棋盘是否存在冲突解法1
    public boolean existAttact_1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for(int i = 0; i < matrix.length; i ++) {
            int count = 0;
            for(int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 1) {
                    count ++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
        }
        for(int i = 0; i < matrix[0].length; i ++) {
            int count = 0;
            for(int j = 0; j < matrix.length; j ++) {
                if (matrix[i][j] == 1) {
                    count ++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 棋盘是否存在冲突解法2，下面有
    public boolean existAttact_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for(int i = 1; i < matrix.length; i ++) {
            for(int j = 1; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 1 && (matrix[i][0] == 1 || matrix[0][j] == 1)) {
                    return true;
                }
                matrix[i][0] = matrix[i][j] == 1 ? 1 : matrix[i][0];
                matrix[0][j] = matrix[0][j] == 1 ? 1 : matrix[0][j];
            }
        }
        return false;
    }

    // 还能放多少个
    public int leftCount(int[][] matrix) {
        int count = 0;
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 1) {
                    count ++;
                }
            }
        }
        return count > matrix.length ? 0 : matrix.length - count;
    }

    // 打印一种可能存在的case
    public void printLeftPos(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 1 && (row[j] == 1 || column[i] == 1)) {
                    return;
                }
                if (matrix[i][j] == 1) {
                    row[j] = 1;
                    column[i] = 1;
                }
            }
        }


        for (int i = 0; i < column.length; i++) {
            for (int j = 0; j < row.length; j++) {
                if (column[i] == 0 && row[j] == 0) {
                    System.out.println("i = " + i + ", j = " + j);
                    column[i] = 1;
                    row[j] = 1;
                }
            }
        }
    }
}

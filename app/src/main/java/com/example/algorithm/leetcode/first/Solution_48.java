package com.example.algorithm.leetcode.first;
//You are given an n x n 2D matrix representing an image.
//
// Rotate the image by 90 degrees (clockwise).
//
// Note:
//
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
// Example 1:
//
//
//Given input matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//rotate the input matrix in-place such that it becomes:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//
//
// Example 2:
//
//
//Given input matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
//rotate the input matrix in-place such that it becomes:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
//
// Related Topics Array

public class Solution_48 {
    public static void main(String[] args) {
        Solution_48 solution = new Solution_48();
        int[][] matrix = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        solution.mySolution(matrix);
    }

    // 转置加翻转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public void mySolution(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            for (int i = 0; i < end - start; i++) {
                int temp = matrix[end - i][start];
                matrix[end - i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[start + i][end];
                matrix[start + i][end] = matrix[start][start + i];
                matrix[start][start + i] = temp;
            }
            start++;
            end--;
        }
    }

    public void rotateStep(int[][] matrix, int start, int end) {
        for (int i = 0; i < end - start; i++) {
            int temp = matrix[end - i][start];
            matrix[end - i][start] = matrix[end][end - i];
            matrix[end][end - i] = matrix[start + i][end];
            matrix[start + i][end] = matrix[start][start + i];
            matrix[start][start + i] = temp;
        }
    }

}

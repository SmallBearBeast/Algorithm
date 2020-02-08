package com.example.algorithm.leetcode;
//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
// Example 1:
//
//
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
//
//
// Example 2:
//
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array


import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
    public static void main(String[] args) {
        Solution_54 solution = new Solution_54();
        List<Integer> result = solution.mySolution_2(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},

        });
        result = null;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        return null;
    }

    public List<Integer> mySolution_1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        int level = (Math.min(matrix.length, matrix[0].length) - 1) / 2;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= level; i++) {
            goThrough(result, matrix, i);
        }
        return result;
    }

    public void goThrough(List<Integer> result, int[][] matrix, int level) {
        if (level == matrix[0].length - 1 - level) {
            for (int i = level; i <= matrix.length - 1 - level; i++) {
                result.add(matrix[i][level]);
            }
            return;
        }
        if (level == matrix.length - 1 - level) {
            for (int i = level; i <= matrix[0].length - 1 - level; i++) {
                result.add(matrix[level][i]);
            }
            return;
        }
        for (int i = level; i < matrix[0].length - 1 - level; i++) {
            result.add(matrix[level][i]);
        }
        for (int i = level; i < matrix.length - 1 - level; i++) {
            result.add(matrix[i][matrix[0].length - 1 - level]);
        }
        for (int i = matrix[0].length - 1 - level; i > level; i--) {
            result.add(matrix[matrix.length - 1 - level][i]);
        }
        for (int i = matrix.length - 1 - level; i > level; i--) {
            result.add(matrix[i][level]);
        }
    }

    public List<Integer> mySolution_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int num = 0, tar = matrix.length * matrix[0].length;
        while (num < tar) {
            for (int i = l; i <= r && num < tar; i++) {
                result.add(matrix[t][i]);
                num++; // left to right.
            }
            t++;
            for (int i = t; i <= b && num < tar; i++) {
                result.add(matrix[i][r]);
                num++; // top to bottom.
            }
            r--;
            for (int i = r; i >= l && num < tar; i--) {
                result.add(matrix[b][i]);
                num++; // right to left.
            }
            b--;
            for (int i = b; i >= t && num < tar; i--) {
                result.add(matrix[i][l]);
                num++; // bottom to top.
            }
            l++;
        }
        return result;
    }
}

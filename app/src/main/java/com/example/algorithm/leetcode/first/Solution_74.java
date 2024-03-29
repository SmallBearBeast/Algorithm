package com.example.algorithm.leetcode.first;


//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
// 示例 1:
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
//
//
// 示例 2:
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false
// Related Topics 数组 二分查找

public class Solution_74 {
    public static void main(String[] args) {
        Solution_74 solution = new Solution_74();
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }

    public boolean mySolution_1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0;
        int column = matrix[0].length;
        int end = matrix.length * column - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            int value = matrix[mid / column][mid % column];
            if (value > target) {
                end = mid - 1;
            } else if (value < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean mySolution_2(int[][] matrix, int target) {
        return false;
    }

}

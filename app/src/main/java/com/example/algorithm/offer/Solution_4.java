package com.example.algorithm.offer;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//示例:
//现有矩阵 matrix 如下：
//[
//[1,   4,  7, 11, 15],
//[2,   5,  8, 12, 19],
//[3,   6,  9, 16, 22],
//[10, 13, 14, 17, 24],
//[18, 21, 23, 26, 30]
//]
//给定 target = 5，返回 true。
//给定 target = 20，返回 false。
//限制：
//0 <= n <= 1000
//0 <= m <= 1000

public class Solution_4 {
    public static void main(String[] args) {
        Solution_4 solution = new Solution_4();
        solution.mySolution_1(new int[][]{
                {-1, 3}
        }, 3);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return false;
    }

    public boolean mySolution_1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
                if (binarySearch(matrix[i], target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // 贪心法
    public boolean mySolution_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] > target) {
                row --;
            } else if (matrix[row][column] < target) {
                column ++;
            } else {
                return true;
            }
        }
        return false;
    }

}

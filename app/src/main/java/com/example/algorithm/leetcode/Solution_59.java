package com.example.algorithm.leetcode;

//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//
// 示例:
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// Related Topics 数组

public class Solution_59 {
    public static void main(String[] args) {
        Solution_59 solution = new Solution_59();
        solution.mySolution_1(3);
    }

    public int[][] generateMatrix(int n) {
        return null;
    }

    public int[][] mySolution_1(int n) {
        int[][] matrix = new int[n][n];
        int N = (n + 1) / 2;
        int num = 1;
        for(int i = 0; i < N; i ++) {
            for(int j = i; j < n - i - 1; j ++) {
                matrix[i][j] = num++;
            }
            for(int j = i; j < n - i - 1; j ++) {
                matrix[j][n - 1 - i] = num++;
            }
            for(int j = n - 1 - i; j > i; j --) {
                matrix[n - 1 - i][j] = num++;
            }
            for(int j = n - 1 - i; j > i; j --) {
                matrix[j][i] = num ++;
            }
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = num;
        }
        return matrix;
    }

    // 使用num <= tar解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。
    public int[][] mySolution_2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

}

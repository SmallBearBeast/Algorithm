package com.example.algorithm.leetcode.first;

//给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// 示例 1:
//
// 输入: 1
//输出: "A"
//
//
// 示例 2:
//
// 输入: 28
//输出: "AB"
//
//
// 示例 3:
//
// 输入: 701
//输出: "ZY"
//
// Related Topics 数学

public class Solution_168 {
    public static void main(String[] args) {
        Solution_168 solution = new Solution_168();
        solution.mySolution_1(1);
    }

    public String convertToTitle(int n) {
        return null;
    }

    public String mySolution_1(int n) {
        StringBuilder builder = new StringBuilder();
        int value = 0;
        while (n > 0) {
            value = n;
            n = n % 26;
            if (n == 0) {
                n = 26;
            }
            builder.append((char)('@' + n));
            n = (value - n) / 26;
        }
        return builder.reverse().toString();
    }

    public String mySolution_2(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            n--;
            builder.append((char)('A' + (n % 26)));
            n = n / 26;
        }
        return builder.reverse().toString();
    }

}

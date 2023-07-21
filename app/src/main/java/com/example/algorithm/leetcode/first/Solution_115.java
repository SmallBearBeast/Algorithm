package com.example.algorithm.leetcode.first;

//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
//
// 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是）
//
// 题目数据保证答案符合 32 位带符号整数范围。
//
//
//
// 示例 1：
//
// 输入：S = "rabbbit", T = "rabbit"
//输出：3
//解释：
//
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
//
//
// 示例 2：
//
// 输入：S = "babgbag", T = "bag"
//输出：5
//解释：
//
//如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^
// Related Topics 字符串 动态规划

public class Solution_115 {
    public static void main(String[] args) {
        Solution_115 solution = new Solution_115();
        int result = solution.mySolution_3("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc");
//        int result = solution.mySolution_3("babgbag", "bag");
        String s = null;
    }

    public int numDistinct(String s, String t) {
        return 1;
    }

    // 递归回溯超时
    public int mySolution_1(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return 0;
        }
        if (t.length() > s.length()) {
            return 0;
        }
        int[][] values = new int[t.length()][s.length()];
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    values[i][j] = 1;
                }
            }
        }
        return recursive_1(values, 0, 0);
    }

    public int recursive_1(int[][] values, int row, int column) {
        if (row == values.length) {
            return 1;
        }
        int result = 0;
        for (int i = column; i < values[row].length; i++) {
            if (values[row][i] == 1) {
                result = result + recursive_1(values, row + 1, i + 1);
            }
        }
        return result;
    }

    public int mySolution_2(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return 0;
        }
        if (t.length() > s.length()) {
            return 0;
        }
        int row = t.length();
        int column = s.length();
        int[][] values = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (t.charAt(i) != s.charAt(j)) {
                    values[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < column; i++) {
            if (values[0][i] == 0) {
                values[0][i] = 1;
            }
        }

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column; j++) {
                if (values[i][j] > 0) {
                    for (int k = j + 1; k < column; k++) {
                        if (values[i + 1][k] >= 0) {
                            values[i + 1][k] = values[i + 1][k] + values[i][j];
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < column; i++) {
            if (values[row - 1][i] > 0) {
                result = result + values[row - 1][i];
            }
        }
        return result;
    }

    public int mySolution_3(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return 0;
        }
        if (t.length() > s.length()) {
            return 0;
        }
        int row = t.length();
        int column = s.length();
        int[][] values = new int[row][column];
        int temp = 0;
        for (int i = 0; i < column; i++) {
            if (t.charAt(0) == s.charAt(i)) {
                temp ++;
            }
            values[0][i] = temp;
        }
        for (int i = 1; i < row; i++) {
            temp = 0;
            for (int j = i; j < column; j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    values[i][j] = values[i][j - 1] + values[i - 1][j - 1];
                    temp = values[i][j];
                } else {
                    values[i][j] = temp;
                }
            }
        }
        return values[row - 1][column - 1];
    }
}

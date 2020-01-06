package com.example.algorithm.leetcode;
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
// Example 1:
//
//
//Input: num1 = "2", num2 = "3"
//Output: "6"
//
// Example 2:
//
//
//Input: num1 = "123", num2 = "456"
//Output: "56088"
//
//
// Note:
//
//
// The length of both num1 and num2 is < 110.
// Both num1 and num2 contain only digits 0-9.
// Both num1 and num2 do not contain any leading zero, except the number 0 itself.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.
//
// Related Topics Math String

import java.util.ArrayList;
import java.util.List;

public class Solution_43 {
    public static void main(String[] args) {
        Solution_43 solution = new Solution_43();
        solution.mySolution_1("1", "23");
    }

    // https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int num1Length = num1.length();
        int num2Length = num2.length();
        int[] res = new int[num1Length + num2Length];
        int value = 0;
        for (int i = num1Length - 1; i >= 0; i--) {
            for (int j = num2Length - 1; j >= 0; j--) {
                value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[i + j + 1];
                res[i + j + 1] = value % 10;
                res[i + j] = res[i + j] + value / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && i == 0) {
                continue;
            }
            builder.append(res[i]);
        }
        return builder.toString();
    }

    public String mySolution(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }
        char[] letters_1 = num1.toCharArray();
        char[] letters_2 = num2.toCharArray();
        List<Integer> result = new ArrayList<>();
        int step = 0, value = 0;
        for (int i = letters_1.length - 1; i >= 0; i--) {
            step = 0;
            for (int j = letters_2.length - 1; j >= 0; j--) {
                value = (letters_1[i] - '0') * (letters_2[j] - '0') + step;
                int index = letters_1.length + letters_2.length - 2 - i - j;
                value = value + (index < result.size() ? result.get(index) : 0);
                step = value / 10;
                value = value % 10;
                if (index == result.size()) {
                    result.add(value);
                } else {
                    result.set(index, value);
                }
            }
            if (step != 0) {
                result.add(step);
            }
        }
        StringBuilder builder = new StringBuilder();
        int size = result.size();
        for (int i = 0; i < size; i++) {
            builder.append(result.get(i));
        }
        return builder.reverse().toString();
    }

    // TODO: 2019-12-03
    public String mySolution_1(String num1, String num2) {
        int length_1 = num1.length();
        int length_2 = num2.length();
        int[][] datas = new int[10][length_2 + 1];
        int step = 0, value = 0, row = 0, index = 0;
        for (int i = length_1 - 1; i >= 0; i--) {
            row = num1.charAt(i) - '0';
            if (datas[0][row] == -1) {
                continue;
            }
            step = 0;
            for (int j = length_2 - 1; j >= 0; j--) {
                value = row * (num2.charAt(j) - '0') + step;
                step = value / 10;
                value = value % 10;
                datas[row][j + 1] = value;
            }
            datas[row][0] = step;
            datas[0][row] = -1;
        }

        char[] result = new char[length_1 + length_2 + 1];
        for (int i = length_1 - 1; i >= 0; i--) {
            row = num1.charAt(i) - '0';
            if (row == (length_1 = 1)) {
                for (int j = length_2; j >= 0; j--) {
                    result[length_1 + length_2 - (length_2 - j)] = (char) (datas[row][j] + '0');
                }
            } else {
                step = 0;
                for (int j = length_2; j >= 0; j--) {
                    index = length_1 + length_2 - (length_2 - j) - (length_1 - 1 - i);
                    value = datas[row][j] + result[index] + step;
                    step = value / 10;
                    result[index] = (char) (datas[row][j] + value % 10 + '0');
                }
                result[index - 1] = (char) (step + 1);
            }
        }
        return "";
    }
}

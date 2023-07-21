package com.example.algorithm.leetcode.first;
//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
// For example:
//
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//
// Example 1:
//
//
//Input: "A"
//Output: 1
//
//
// Example 2:
//
//
//Input: "AB"
//Output: 28
//
//
// Example 3:
//
//
//Input: "ZY"
//Output: 701
// Related Topics Math

public class Solution_171 {
    public static void main(String[] args) {
        Solution_171 solution = new Solution_171();
        solution.mySolution("ZY");
    }

    public int titleToNumber(String s) {
        return 1;
    }

    public int mySolution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int base = 1;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            res = res + (chars[i] - 'A' + 1) * base;
            base = base * 26;
        }
        return res;
    }

}

package com.example.algorithm.leetcode.first;
//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example 1:
//
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
//Input: "cbbd"
//Output: "bb"
//
// Related Topics String Dynamic Programming

public class Solution_5 {
    public static void main(String[] args) {
        Solution_5 solution = new Solution_5();
        solution.mySolution_1("aaaa");
    }

    public String longestPalindrome(String s) {
        return null;
    }

    public String longestPalindrome_1(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        String reverse = new StringBuilder(s).reverse().toString();
        int length = s.length();
        int[] dp = new int[length];
        int maxIndex = 0;
        int maxLen = 0;
        int preIndex = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[j] = 1;
                    } else {
                        dp[j] = dp[j - 1] + 1;
                    }
                } else {
                    dp[j] = 0;
                }
                if (maxLen < dp[j]) {
                    preIndex = length - 1 - j;
                    if (preIndex + dp[j] - 1 == i) {
                        maxLen = dp[j];
                        maxIndex = i;
                    }
                }
            }
        }
        return s.substring(maxIndex - maxLen + 1, maxIndex + 1);
    }

    public String longestPalindrome_2(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        int length = s.length();
        int result_1 = 0;
        int result_2 = 0;
        int temp = 0;
        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            temp = 1;
            result_1 = 0;
            while (i - temp >= 0 && i + temp < length && s.charAt(i - temp) == s.charAt(i + temp)) {
                temp ++;
                result_1 ++;
            }
            temp = 0;
            result_2 = 0;
            while (i - temp >= 0 && i + temp + 1 < length &&  s.charAt(i - temp) == s.charAt(i + temp + 1)) {
                temp ++;
                result_2 ++;
            }
            if (result_2 > result_1) {
                start = i - result_2 + 1;
                end = i + result_2;
            } else {
                start = i - result_1;
                end = i + result_1;
            }
            if (maxEnd - maxStart < end - start + 1) {
                maxEnd = end;
                maxStart = start;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    // 动态规划
    public String mySolution_1(String s) {
        int length = s.length();
        int maxStart = 0;
        int maxEnd = -1;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || (i - j == 1 || dp[j + 1][i - 1]) && s.charAt(i) == s.charAt(j)) {
                    if (maxEnd - maxStart < i - j) {
                        maxEnd = i;
                        maxStart = j;
                    }
                    dp[j][i] = true;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    //Manacher's Algorithm 马拉车算法。
}

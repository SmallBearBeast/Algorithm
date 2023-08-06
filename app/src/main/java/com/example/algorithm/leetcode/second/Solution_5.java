package com.example.algorithm.leetcode.second;

public class Solution_5 {
    public static void main(String[] args) {
        Solution_5 solution5 = new Solution_5();
        System.out.println(solution5.mySolution_2("cbbd"));
    }


    public String longestPalindrome(String s) {
        return "";
    }

    // 二维动态规划
    public String mySolution_1(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        // dp i要求要<=j
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i == j) || (i - j == 1 || dp[j + 1][i - 1]) && s.charAt(j) == s.charAt(i)) {
                    if (i - j > end - start) {
                        start = j;
                        end = i;
                    }
                    dp[j][i] = true;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    // 一维动态规划
    public String mySolution_2(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        boolean[] dp = new boolean[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i == j) || (i - j == 1 || dp[j + 1]) && s.charAt(j) == s.charAt(i)) {
                    if (i - j > end - start) {
                        start = j;
                        end = i;
                    }
                    dp[j] = true;
                } else {
                    dp[j] = false;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    // 中心指针解法
    public String mySolution_3(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
            }
            if (right - left - 1 > end - start) {
                start = left + 1;
                end = right;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
            }
            if (right - left - 1 > end - start) {
                start = left + 1;
                end = right;
            }
        }
        return s.substring(start, end);
    }
}

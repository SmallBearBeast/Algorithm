package com.example.algorithm.leetcode;
//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//
// Example:
//
//
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
// Related Topics Dynamic Programming Tree

public class Solution_96 {
    public static void main(String[] args) {
        Solution_96 solution = new Solution_96();
        solution.mySolution(3);
    }

    public int numTrees(int n) {
        return 1;
    }

    public int mySolution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }

}

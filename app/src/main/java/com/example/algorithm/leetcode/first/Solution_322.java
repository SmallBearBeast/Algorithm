package com.example.algorithm.leetcode.first;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
//
//
// 示例 1:
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//
// 示例 2:
//
// 输入: coins = [2], amount = 3
//输出: -1
//
//
//
// 说明:
//你可以认为每种硬币的数量是无限的。
// Related Topics 动态规划

import java.util.Arrays;

public class Solution_322 {
    public int minCount = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Solution_322 solution = new Solution_322();
//        int result = solution.mySolution_1(new int[]{
//                1, 2, 5
//        }, 11);
        int result = solution.mySolution_3(new int[]{
                470, 18, 66, 301, 403, 112, 360

        }, 8235);
        System.out.println("result = " + result);
    }

    public int coinChange(int[] coins, int amount) {
        return 1;
    }

    public int mySolution_1(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        Arrays.sort(coins);
        recursive_1(coins, amount, coins.length - 1, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    // 暴力遍历，严重超时。
    public void recursive_1(int[] coins, int amount, int index, int lastCount) {
        if (amount == 0) {
            minCount = Math.min(minCount, lastCount);
            return;
        }
        if (index < 0) {
            return;
        }
        int coin = coins[index];
        int count = amount / coin;
        for (int i = count; i >= 0; i--) {
            int rest = amount - i * coin;
            recursive_1(coins, rest, index - 1, i + lastCount);
        }
    }

    // dp
    public int mySolution_2(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        return recursive_2(coins, amount, new int[amount]);
    }

    public int recursive_2(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount - 1] != 0) {
            return dp[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int rest = recursive_2(coins, amount - coins[i], dp);
            if (rest >= 0 && rest + 1 < min) {
                min = rest + 1;
            }
        }
        dp[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount - 1];
    }

    public int mySolution_3(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

package com.example.algorithm.leetcode.second;

import java.util.Arrays;

public class Solution_45 {
    public static void main(String[] args) {
        Solution_45 solution_45 = new Solution_45();
        int result = solution_45.mySolution_1(new int[] {
                2, 3, 1, 1, 4
        });
        System.out.println(result);
    }

    public int jump(int[] nums) {
        return 1;
    }

    // 动态规划法，dp代表跳到该位置的最小次数。
    public int mySolution_1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    // 贪心算法
    public int mySolution_2(int[] nums) {
        int step = 0;
        int maxIndex = 0;
        int endPerStep = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 找能跳的最远的
            maxIndex = Math.max(maxIndex, i + nums[i]);
            // 遇到边界，就更新边界，并且步数加一
            if (endPerStep == i) {
                endPerStep = maxIndex;
                step ++;
            }
        }
        return step;
    }
}

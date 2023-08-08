package com.example.algorithm.leetcode.first;

//给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 示例:
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 说明:
//
// 假设你总是可以到达数组的最后一个位置。
// Related Topics 贪心算法 数组

import java.util.Arrays;

public class Solution_45 {
    public static void main(String[] args) {
        Solution_45 solution = new Solution_45();
        solution.mySolution_3(new int[]{
                1, 1, 3, 1, 1, 4
        });
    }

    public int jump(int[] nums) {
        return 1;
    }

    // 动态规划法，dp代表跳到该位置的最小次数。
    public int mySolution_1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
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

    public int mySolution_3(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position != 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

}

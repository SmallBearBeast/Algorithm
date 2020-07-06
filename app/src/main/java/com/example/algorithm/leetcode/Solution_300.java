package com.example.algorithm.leetcode;

//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例:
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
// 说明:
//
//
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。
//
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
// Related Topics 二分查找 动态规划

import java.util.Arrays;

public class Solution_300 {
    public static void main(String[] args) {
        Solution_300 solution = new Solution_300();
        int result = solution.mySolution_1(new int[]{
                10, 9, 2, 5, 3, 7, 101, 18
        });
        System.out.println("result = " + result);
    }

    public int lengthOfLIS(int[] nums) {
        return 1;
    }

    public int mySolution_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i] > j + 1) {
                    break;
                }
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }

    public int mySolution_2(int[] nums) {
        return 1;
    }

}

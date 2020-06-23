package com.example.algorithm.leetcode;
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
// Example 1:
//
//
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
//
// Example 2:
//
//
//Input: [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
//
// Related Topics Dynamic Programming

public class Solution_198 {
    public static void main(String[] args) {
        Solution_198 solution = new Solution_198();
        solution.mySolution_1(new int[]{
                2, 7, 9, 3, 1
        });
    }

    public int rob(int[] nums) {
        return 1;
    }

    public int mySolution_1(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            // 只需要比较i - 2，i - 3位置即可。
            if (i - 2 >= 0) {
                temp = Math.max(temp, dp[i - 2]);
            }
            if (i - 3 >= 0) {
                temp = Math.max(temp, dp[i - 3]);
            }
            dp[i] = nums[i] + temp;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int mySolution_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public int mySolution_3(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }
}

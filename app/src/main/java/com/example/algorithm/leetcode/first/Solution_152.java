package com.example.algorithm.leetcode.first;
//Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
// Example 1:
//
//
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
//
//
// Example 2:
//
//
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// Related Topics Array Dynamic Programming

public class Solution_152 {
    public static void main(String[] args) {
        Solution_152 solution = new Solution_152();
        solution.mySolution_1(new int[]{
                -2, -2
        });
    }

    public int maxProduct(int[] nums) {
        return 1;
    }

    public int mySolution_1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp[1][0] = 0;
                dp[1][1] = 0;
            } else if (nums[i] > 0) {
                dp[1][0] = dp[0][0] == 0 ? nums[i] : dp[0][0] * nums[i];
                dp[1][1] = dp[0][1] == 0 ? 0 : dp[0][1] * nums[i];
            } else if (nums[i] < 0) {
                dp[1][0] = dp[0][1] == 0 ? 0 : dp[0][1] * nums[i];
                dp[1][1] = dp[0][0] == 0 ? nums[i] : dp[0][0] * nums[i];
            }
            maxVal = Math.max(maxVal, dp[1][0]);
            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
        }
        return maxVal;
    }

    public int mySolution_2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
            int preMax = dpMax;
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            dpMin = Math.min(dpMin * nums[i], Math.min(preMax * nums[i], nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }
}

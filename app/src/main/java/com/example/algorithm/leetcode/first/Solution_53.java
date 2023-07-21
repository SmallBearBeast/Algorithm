package com.example.algorithm.leetcode.first;
//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
// Example:
//
//
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//
//
// Follow up:
//
// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
// Related Topics Array Divide and Conquer Dynamic Programming

public class Solution_53 {
    public static void main(String[] args) {
        Solution_53 solution = new Solution_53();
    }

    public int maxSubArray(int[] nums) {
        return 1;
    }

    // 贪心法
    public int maxSubArray_1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            //如果sum < 0，重新开始找子序串
            if (sum < 0) {
                sum = 0;
            }
        }

        return result;
    }

    // https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-cshi-xian-si-chong-jie-fa-bao-li-f/
    // 分治法
    public int maxSubArray_2(int[] nums) {
        return 1;
    }

    public int mySolution(int[] nums) {
        int maxSize = nums[0];
        int curSize = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSize = curSize <= 0 ? nums[i] : curSize + nums[i];
            maxSize = Math.max(curSize, maxSize);
        }
        return maxSize;
    }

}

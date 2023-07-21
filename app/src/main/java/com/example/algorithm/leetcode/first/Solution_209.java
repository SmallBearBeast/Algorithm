package com.example.algorithm.leetcode.first;

//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回
// 0。
//
// 示例:
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
//
//
// 进阶:
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
// Related Topics 数组 双指针 二分查找

public class Solution_209 {
    public static void main(String[] args) {
        Solution_209 solution = new Solution_209();
        solution.mySolution_1(7, new int[]{
                2, 3, 1, 2, 4, 3
        });
    }

    public int minSubArrayLen(int s, int[] nums) {
        return 1;
    }

    public int mySolution_1(int s, int[] nums) {
        int first = 0;
        int second = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (second < nums.length) {
            sum = sum + nums[second];
            while (sum >= s) {
                minLength = Math.min(minLength, second - first + 1);
                if (minLength == 1) {
                    return minLength;
                }
                sum = sum - nums[first];
                first++;
            }
            second++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public int mySolution_2(int s, int[] nums) {
        return 1;
    }

}

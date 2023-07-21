package com.example.algorithm.leetcode.first;

import java.util.Arrays;

//Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
// Example:
//
//
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
// Related Topics Array Two Pointers
public class Solution_16 {
    public static void main(String[] args) {
        Solution_16 solution = new Solution_16();
        //int[] nums = {-1, 2, 1, -4};
        //1
        //int[] nums = {1, 1, -1, -1, 3};
        //-1
        //nt[] nums = {1,2,4,8,16,32,64,128};
        //82
        int[] nums = {0,5,-1,-2,4,-1,0,-3,4,-5};
        //1
        solution.threeSumClosest(nums, 1);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int start, end, sum;
        for (int i = 0; i < nums.length - 2; i++) {
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }


    public int mySolution(int[] nums, int target) {
        Arrays.sort(nums);
        final int initValue = target >= 0 ? Integer.MIN_VALUE + 1 + target : Integer.MAX_VALUE + target;
        int result = initValue;
        int step;
        int stepMaxValue;
        int stepMinValue;
        int temp;
        int j, k, v = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = i + 2;
            stepMinValue = nums[i] + nums[j] + nums[k];
            stepMaxValue = nums[i] + nums[nums.length - 1] + nums[nums.length - 2];
            if (stepMinValue >= target) {
                if (stepMinValue - target < Math.abs(result - target)) {
                    result = stepMinValue;
                }
                break;
            }
            if (stepMaxValue <= target) {
                if (target - stepMaxValue < Math.abs(result - target)) {
                    result = stepMaxValue;
                }
                continue;
            }
            while (j <= v - 1) {
                step = initValue;
                while (k <= v) {
                    temp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(temp - target) <= Math.abs(step - target)) {
                        step = temp;
                        k ++;
                    } else {
                        v = k;
                        break;
                    }
                }
                if ((Math.abs(step - target) <= Math.abs(result - target))) {
                    result = step;
                }
                j ++;
                k = j + 1;
            }
        }
        return result;
    }
}
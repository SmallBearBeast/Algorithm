package com.example.algorithm.leetcode;

//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics Array Two Pointers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {
    public static void main(String[] args) {
        Solution_15 solution = new Solution_15();
        int[] nums = {0, 0, 0, 0, 0, 0};
        solution.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int start = 0, mid, end, temp; start < nums.length - 2; start++) {
            if (nums[start] > 0) {
                break;
            }
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }
            mid = start + 1;
            end = nums.length - 1;
            while (mid < end) {
                temp = nums[start] + nums[mid] + nums[end];
                if (temp < 0) {
                    do {
                        mid ++;
                    } while (mid < end && nums[mid] == nums[mid - 1]);
                } else if (temp > 0) {
                    do {
                        end --;
                    } while (mid < end && nums[end] == nums[end + 1]);
                } else {
                    result.add(Arrays.asList(nums[start], nums[mid], nums[end]));
                    do {
                        mid ++;
                    } while (mid < end && nums[mid] == nums[mid - 1]);
                    do {
                        end --;
                    } while (mid < end && nums[end] == nums[end + 1]);
                }
            }
        }
        return result;
    }


    public List<List<Integer>> mySolution(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int mid = start + 1;
        int end = nums.length - 1;
        int temp = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (start < nums.length && start < mid && mid < end && nums[start] <= 0) {
            temp = -(nums[start] + nums[end]);
            while (mid < end && nums[mid] != temp && temp >= nums[start] && temp <= nums[end]) {
                mid ++;
            }
            if (end == mid) {
                mid = start + 1;
                do {
                    end--;
                } while (end > mid && nums[end] >= 0 && nums[end] == nums[end + 1]);
            } else {
                if ((nums[start] + nums[mid] + nums[end]) == 0) {
                    result.add(Arrays.asList(nums[start], nums[mid], nums[end]));
                }
                do {
                    end --;
                } while (end > mid && nums[end] >= 0 && nums[end] == nums[end + 1]);
            }

            if (end == mid) {
                end = nums.length - 1;
                do {
                    start ++;
                } while (end > start + 1 && nums[start] <= 0 && nums[start] == nums[start - 1]);
                mid = start + 1;
            }
        }

        return result;
    }

    // TODO: 2019-11-12 three num and target
    public List<List<Integer>> mySolution(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int start, end, sum;
        for (int i = 0; i < nums.length - 3; i++) {

        }
        return null;
    }
}

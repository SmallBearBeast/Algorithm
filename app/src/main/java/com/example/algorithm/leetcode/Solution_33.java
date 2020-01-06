package com.example.algorithm.leetcode;
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// Example 1:
//
//
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//
//
// Example 2:
//
//
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Related Topics Array Binary Search

public class Solution_33 {
    public static void main(String[] args) {
        Solution_33 solution = new Solution_33();
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        solution.mySolution(nums, 0);
//        int[] nums = {3, 1};
//        solution.mySolution(nums, 1);
//        int[] nums = {1, 3};
//        solution.mySolution(nums, 3);
        int[] nums = {1, 3};
        solution.mySolution(nums, 3);
    }

    public int search(int[] nums, int target) {
        return mySolution(nums, target);
    }

    public int mySolution(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= target) {
                if (nums[mid] < nums[0]) {
                    end = mid - 1;
                } else {
                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            } else {
                if (nums[mid] >= nums[0]) {
                    start = mid + 1;
                } else {
                    if (nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}

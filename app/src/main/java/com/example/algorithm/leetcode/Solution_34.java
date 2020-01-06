package com.example.algorithm.leetcode;
//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
// Example 1:
//
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//
// Example 2:
//
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Related Topics Array Binary Search

public class Solution_34 {
    public static void main(String[] args) {
        Solution_34 solution = new Solution_34();
        int[] nums = {2, 2};
        solution.searchRange(new int[]{}, 3);
    }

    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        if (left <= right && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    public int findLeft(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return end + 1;
    }

    public int findRight(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] <= target) {
                start = mid + 1;
            }
        }
        return start - 1;
    }

    public int[] mySolution(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] == target) {
                start = mid;
                end = mid;
                while (start >= 0 && nums[mid] == nums[start]) {
                    start--;
                }
                while (end < nums.length && nums[mid] == nums[end]) {
                    end++;
                }
                return new int[]{start + 1, end - 1};
            }
        }
        return new int[]{-1, -1};
    }
}

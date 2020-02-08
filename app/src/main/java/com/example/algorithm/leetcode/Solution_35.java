package com.example.algorithm.leetcode;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找

public class Solution_35 {
    public static void main(String[] args) {
        Solution_35 solution = new Solution_35();
        solution.mySolution_1(new int[]{
                1, 3, 5, 6
        }, 2);
    }

    public int searchInsert(int[] nums, int target) {
        return 1;
    }

    // 多余调整
    public int mySolution_1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        if (start < 0) {
            return 0;
        }
        if (start >= nums.length) {
            return nums.length;
        }
        return target > nums[start] ? start + 1 : start;
    }

    // return start 无需调整
    public int mySolution_2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}

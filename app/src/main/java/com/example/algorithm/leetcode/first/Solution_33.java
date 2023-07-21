package com.example.algorithm.leetcode.first;
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
// 你可以假设数组中不存在重复的元素。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 示例 1:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//
//
// 示例 2:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1
// Related Topics 数组 二分查找

public class Solution_33 {
    public static void main(String[] args) {
        Solution_33 solution = new Solution_33();
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        solution.mySolution(nums, 0);
//        int[] nums = {3, 1};
//        solution.mySolution(nums, 1);
//        int[] nums = {1, 3};
//        solution.mySolution(nums, 3);
        int[] nums = {1, 3, 1, 1, 1};
        solution.mySolution_2(nums, 3);
    }

    public int mySolution_1(int[] nums, int target) {
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

    public boolean mySolution_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (end > start && nums[start] == nums[end]) {
            if (nums[start] == target) {
                return true;
            }
            start ++;
            end --;
        }
        return search(nums, target, start, end);
    }

    public boolean search(int[] nums, int target, int start, int end) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] <= target) {
                if (nums[mid] < nums[start]) {
                    end = mid - 1;
                } else {
                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            } else {
                if (nums[mid] >= nums[start]) {
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
        return false;
    }
}

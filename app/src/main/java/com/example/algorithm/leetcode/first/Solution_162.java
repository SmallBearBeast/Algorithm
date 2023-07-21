package com.example.algorithm.leetcode.first;
//A peak element is an element that is greater than its neighbors.
//
// Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
//
// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
// You may imagine that nums[-1] = nums[n] = -∞.
//
// Example 1:
//
//
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index number 2.
//
// Example 2:
//
//
//Input: nums = [1,2,1,3,5,6,4]
//Output: 1 or 5
//Explanation: Your function can return either index number 1 where the peak element is 2,
//             or index number 5 where the peak element is 6.
//
//
// Note:
//
// Your solution should be in logarithmic complexity.
// Related Topics Array Binary Search

import java.util.LinkedList;
import java.util.Queue;

public class Solution_162 {
    public static void main(String[] args) {
        Solution_162 solution = new Solution_162();
    }

    public int findPeakElement(int[] nums) {
        return 1;
    }

    public int mySolution_1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(nums.length - 1);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            int end = queue.poll();
            int mid = (start + end) / 2;
            if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid - 1 > start) {
                queue.add(start);
                queue.add(mid - 1);
            }
            if (mid + 1 < end) {
                queue.add(mid + 1);
                queue.add(end);
            }
        }
        return 0;
    }

    public int mySolution_2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return recursive_2(nums, 0, nums.length - 1);
    }

    public int recursive_2(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (mid == 0 && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
            return mid;
        } else if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        int result = recursive_2(nums, start, mid - 1);
        if (result == -1) {
            result = recursive_2(nums, mid + 1, end);
        }
        return result;
    }

    public int mySolution_3(int[] nums) {
        return recursive_3(nums, 0, nums.length - 1);
    }

    public int recursive_3(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return recursive_3(nums, l, mid);
        return recursive_3(nums, mid + 1, r);
    }

    public int mySolution_4(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}

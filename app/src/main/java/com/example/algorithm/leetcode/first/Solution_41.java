package com.example.algorithm.leetcode.first;
//Given an unsorted integer array, find the smallest missing positive integer.
//
// Example 1:
//
//
//Input: [1,2,0]
//Output: 3
//
//
// Example 2:
//
//
//Input: [3,4,-1,1]
//Output: 2
//
//
// Example 3:
//
//
//Input: [7,8,9,11,12]
//Output: 1
//
//
// Note:
//
// Your algorithm should run in O(n) time and uses constant extra space.
// Related Topics Array


import java.util.HashSet;
import java.util.Set;

public class Solution_41 {
    public static void main(String[] args) {
        Solution_41 solution = new Solution_41();
    }

    public int firstMissingPositive(int[] nums) {
        return 1;
    }

    public int mySolution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    public int mySolution_2(int[] nums) {
        int n = nums.length;
        // 基本情况
        int contains = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }
        if (contains == 0)
            return 1;
        // nums = [1]
        if (n == 1)
            return 2;
        // 用 1 替换负数，0，
        // 和大于 n 的数
        // 在转换以后，nums 只会包含
        // 正数
        for (int i = 0; i < n; i++) {
            if ((nums[i] <= 0) || (nums[i] > n)) {
                nums[i] = 1;
            }
        }

        // 使用索引和数字符号作为检查器
        // 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
        // 如果 nums[2] 是正数 表示数字 2 没有出现
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // 如果发现了一个数字 a - 改变第 a 个元素的符号
            // 注意重复元素只需操作一次
            if (a == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }

        // 现在第一个正数的下标
        // 就是第一个缺失的数
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }

}

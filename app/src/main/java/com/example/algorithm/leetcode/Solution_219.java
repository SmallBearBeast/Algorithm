package com.example.algorithm.leetcode;

//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
//
// 示例 1:
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true
//
// 示例 2:
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true
//
// 示例 3:
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false
// Related Topics 数组 哈希表

import java.util.HashSet;
import java.util.Set;

public class Solution_219 {
    public static void main(String[] args) {
        Solution_219 solution = new Solution_219();
        solution.mySolution_1(new int[]{
                1, 2, 3, 1, 2, 3
        }, 2);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return false;
    }

    public boolean mySolution_1(int[] nums, int k) {
        int start = 0, end = 0;
        Set<Integer> set = new HashSet<>();
        while (end < nums.length) {
            if (end - start <= k) {
                if (set.contains(nums[end])) {
                    return true;
                }
                set.add(nums[end]);
                end++;
            } else {
                set.remove(nums[start]);
                start++;
            }
        }
        return false;
    }

    public boolean mySolution_2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}

package com.example.algorithm.leetcode;
//给定一个未排序的整数数组，找出最长连续序列的长度。
//
// 要求算法的时间复杂度为 O(n)。
//
// 示例:
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
// Related Topics 并查集 数组

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_128 {
    public static void main(String[] args) {
        Solution_128 solution = new Solution_128();
        solution.mySolution_2(new int[]{
                0, -1
        });
    }

    public int longestConsecutive(int[] nums) {
        return 1;
    }


    public int mySolution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Boolean> visit = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length && count < nums.length; i++) {
            if (visit.get(nums[i]) != null) {
                continue;
            }
            int res = 1;
            int val = nums[i];
            visit.put(val, true);
            count++;
            while (set.contains(++val)) {
                visit.put(val, true);
                count++;
                res++;
            }
            val = nums[i];
            while (set.contains(--val)) {
                visit.put(val, true);
                count++;
                res++;
            }
            max = Math.max(res, max);
        }
        return max;
    }

    public int mySolution_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                cur ++;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }

}

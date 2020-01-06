package com.example.algorithm.leetcode;
//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// Related Topics 数组 回溯算法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_90 {
    public static void main(String[] args) {
        Solution_90 solution = new Solution_90();
        solution.mySolution_2(new int[]{
                2, 2, 2
        });
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return null;
    }

    public List<List<Integer>> mySolution_1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recursive(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void recursive(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            recursive(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> mySolution_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        int lastSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = (i > 0 && nums[i] == nums[i - 1]) ? lastSize: 0;
            int size = res.size();
            lastSize = size;
            for (int j = start; j < size; j++) {
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}

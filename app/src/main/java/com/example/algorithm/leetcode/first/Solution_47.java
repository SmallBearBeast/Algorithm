package com.example.algorithm.leetcode.first;
//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_47 {
    public static void main(String[] args) {
        Solution_47 solution = new Solution_47();
        solution.mySolution_1(new int[]{
                0, 1, 0, 0, 9
        });
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        return null;
    }

    public List<List<Integer>> mySolution_1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recursive_1(res, nums, 0);
        return res;
    }

    public void recursive_1(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length - 1) {
            add(res, nums);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (skip(nums, start, i)) {
                continue;
            }
            swap(nums, start, i);
            recursive_1(res, nums, start + 1);
            swap(nums, start, i);
        }
    }

    public boolean skip(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return true;
            }
        }
        return false;
    }

    public void add(List<List<Integer>> res, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        res.add(list);
    }

    public void swap(int[] nums, int start, int end) {
        if (start != end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    public List<List<Integer>> mySolution_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] marks = new boolean[nums.length];
        recursive_2(res, new ArrayList<Integer>(), nums, marks);
        return res;
    }

    public void recursive_2(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] marks) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (marks[i] || (i > 0 && nums[i] == nums[i - 1] && !marks[i - 1])) {
                continue;
            }
            marks[i] = true;
            temp.add(nums[i]);
            recursive_2(res, temp, nums, marks);
            marks[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}

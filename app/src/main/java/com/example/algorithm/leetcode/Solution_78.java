package com.example.algorithm.leetcode;
//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics Array Backtracking Bit Manipulation


import java.util.ArrayList;
import java.util.List;

public class Solution_78 {
    public static void main(String[] args) {
        Solution_78 solution = new Solution_78();
        solution.mySolution_2(new int[]{
                1, 2, 3, 4
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }



    public List<List<Integer>> mySolution_1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursive_1(0, nums, result, new ArrayList<Integer>());
        return result;
    }

    public void recursive_1(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            recursive_1(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> mySolution_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}

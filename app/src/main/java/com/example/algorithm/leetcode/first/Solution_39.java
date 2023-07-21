package com.example.algorithm.leetcode.first;
//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
// The same repeated number may be chosen from candidates unlimited number of times.
//
// Note:
//
//
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
//
//
// Example 1:
//
//
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
//
//
// Example 2:
//
//
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
// Related Topics Array Backtracking

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_39 {
    public static void main(String[] args) {
        Solution_39 solution = new Solution_39();
        int[] nums = {2, 2, 3, 5};
        solution.mySolution_1(nums, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }

    public void add(List<List<Integer>> result, List<Integer> sumList, int[] candidates, int target, int sum, int start) {
        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
            sumList.add(candidates[i]);
            if (sum + candidates[i] == target) {
                result.add(new ArrayList<>(sumList));
                sumList.remove(sumList.size() - 1);
                return;
            }
            add(result, sumList, candidates, target, sum + candidates[i], i);
            sumList.remove(sumList.size() - 1);
        }
    }

    public List<List<Integer>> mySolution(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        add(result, new ArrayList<Integer>(), candidates, target, 0, 0);
        return result;
    }

    public List<List<Integer>> mySolution_1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        recursive_1(res, candidates, new ArrayList<Integer>(), target, 0);
        return res;
    }

    public void recursive_1(List<List<Integer>> res, int[] candidates, List<Integer> temp, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            recursive_1(res, candidates, temp, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}

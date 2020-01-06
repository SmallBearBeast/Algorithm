package com.example.algorithm.leetcode;
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。
//
// 说明：
//
//
// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
// Related Topics 数组 回溯算法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_40 {
    public static void main(String[] args) {
        Solution_40 solution = new Solution_40();
        solution.mySolution_1(new int[]{
                2, 5, 2, 1, 2
        }, 5);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return null;
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
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            recursive_1(res, candidates, temp, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}

package com.example.algorithm.leetcode;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

public class Solution_77 {
    public static void main(String[] args) {
        Solution_77 solution = new Solution_77();
        solution.mySolution_2(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        return null;
    }

    public List<List<Integer>> mySolution_1(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        recursive_1(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }

    public void recursive_1(List<List<Integer>> res, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            recursive_1(res, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> mySolution_2(int n, int k) {
        // init first combination
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < k + 1; ++i) {
            nums.add(i);
        }
        nums.add(n + 1);
        List<List<Integer>> res = new ArrayList<>();
        int j = 0;
        while (j < k) {
            // add current combination
            res.add(new ArrayList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)) {
                nums.set(j, j + 1);
                j ++;
            }
            nums.set(j, nums.get(j) + 1);
        }
        return res;
    }

}

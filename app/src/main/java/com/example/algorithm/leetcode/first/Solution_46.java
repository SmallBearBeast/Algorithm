package com.example.algorithm.leetcode.first;
//Given a collection of distinct integers, return all possible permutations.
//
// Example:
//
//
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
//
// Related Topics Backtracking

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_46 {
    public static void main(String[] args) {
        Solution_46 solution = new Solution_46();
        solution.permute(new int[] {1, 2, 2, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        add(result, nums);
        while (true) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]){
                i --;
            }
            if (i == -1) {
                break;
            }
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j --;
            }
            swap(nums, i, j);
            reverse(nums, i + 1, nums.length - 1);
            add(result, nums);
        }
        return result;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }


    public void add(List<List<Integer>> result, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        result.add(list);
    }

    public List<List<Integer>> mySolution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        add(result, nums, 0, nums.length - 1);
        return result;
    }

    public void add(List<List<Integer>> result, int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
        }
        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            add(result, nums, start + 1, end);
            swap(nums, i, start);
        }
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}

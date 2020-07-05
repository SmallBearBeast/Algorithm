package com.example.algorithm.leetcode;
//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
// Note:
//
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
// Example 1:
//
//
//Input: [2,2,1]
//Output: 1
//
//
// Example 2:
//
//
//Input: [4,1,2,1,2]
//Output: 4
//
// Related Topics Hash Table Bit Manipulation

import java.util.HashSet;

public class Solution_136 {
    public static void main(String[] args) {
        Solution_136 solution = new Solution_136();
        solution.singleNumber(new int[]{
                4, 1, 2, 1, 2
        });
    }

    // 2∗(a+b+c)−(a+a+b+b+c)=c
    public int singleNumber(int[] nums) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            result = result + nums[i];
        }
        for (int num : set) {
            result = result - 2 * num;
        }
        return -result;
    }

    // 异或发
    public int mySolution(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

}

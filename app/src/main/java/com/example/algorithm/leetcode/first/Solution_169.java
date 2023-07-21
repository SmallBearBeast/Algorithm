package com.example.algorithm.leetcode.first;
//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.
//
// Example 1:
//
//
//Input: [3,2,3]
//Output: 3
//
// Example 2:
//
//
//Input: [2,2,1,1,1,2,2]
//Output: 2
//
// Related Topics Array Divide and Conquer Bit Manipulation

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_169 {
    public static void main(String[] args) {
        Solution_169 solution = new Solution_169();
        solution.mySolution_1(new int[]{
                2, 2, 1, 1, 1, 2, 2
        });
    }

    public int majorityElement(int[] nums) {
        return 1;
    }

    // hash
    public int mySolution_1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (!map.containsKey(nums[i])) {
                count = 1;
            } else {
                count = map.get(nums[i]) + 1;
            }
            if (count > nums.length / 2) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return 0;
    }

    public int mySolution_2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Boyer-Moore 投票算法
    public int mySolution_3(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (nums[i] == candidate) ? 1 : -1;
        }
        return candidate;
    }

}

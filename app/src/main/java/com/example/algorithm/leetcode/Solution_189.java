package com.example.algorithm.leetcode;
//Given an array, rotate the array to the right by k steps, where k is non-negative.
//
// Example 1:
//
//
//Input: [1,2,3,4,5,6,7] and k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//
// Example 2:
//
//
//Input: [-1,-100,3,99] and k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//
//
// Note:
//
//
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
// Could you do it in-place with O(1) extra space?
// Related Topics Array

public class Solution_189 {
    public static void main(String[] args) {
        Solution_189 solution = new Solution_189();
        solution.mySolution_1(new int[]{
                1, 2, 3, 4, 5, 6
        }, 2);
    }

    public void rotate(int[] nums, int k) {

    }

    // 环状替换
    public void mySolution_1(int[] nums, int k) {
        if (k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int temp = nums[i];
            int q = i;
            int j = (q - k + nums.length) % nums.length;
            while (i != j) {
                nums[q] = nums[j];
                q = j;
                j = (q - k + nums.length) % nums.length;
                count++;
            }
            nums[q] = temp;
            count++;
        }
    }

    // 反转法
    public void mySolution_2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

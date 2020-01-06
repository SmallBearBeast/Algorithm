package com.example.algorithm.leetcode;
//Implement next PERMUTATION, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
// The replacement must be in-place and use only constant extra memory.
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//
// 1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
// Related Topics Array

public class Solution_31 {
    public static void main(String[] args) {
        Solution_31 solution = new Solution_31();
        //int[] nums = {1, 5, 2, 1, 4, 3, 2};
        int[] nums = {1, 3, 2};
        //
        solution.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        mySolution(nums);
        String s = null;
    }

    public void mySolution(int[] nums) {
        int i = nums.length - 1;
        int j = nums.length - 1;
        int temp = 0;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i --;
        }
        if (i > 0) {
            while (j > i - 1 && nums[j] <= nums[i - 1]) {
                j --;
            }
            temp = nums[j];
            nums[j] = nums[i - 1];
            nums[i - 1] = temp;
        }
        j = nums.length - 1;
        while (i < j) {
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i ++;
            j --;
        }
    }
}

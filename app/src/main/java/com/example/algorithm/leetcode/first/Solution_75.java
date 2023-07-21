package com.example.algorithm.leetcode.first;
//Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
// Note: You are not suppose to use the library's sort function for this problem.
//
// Example:
//
//
//Input: [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//
// Follow up:
//
//
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
// Could you come up with a one-pass algorithm using only constant space?
//
// Related Topics Array Two Pointers Sort

public class Solution_75 {
    public static void main(String[] args) {
        Solution_75 solution = new Solution_75();
        solution.sortColors(new int[]{
                2, 0, 1
        });
    }

    public void sortColors(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else curr++;
        }
    }

    public void mySolution(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, index, start);
                start++;
            } else if (nums[index] == 2) {
                swap(nums, index, end);
                end--;
            }
            if (index < start || nums[index] == 1) {
                index++;
            }
        }
    }

    public void swap(int[] nums, int index_1, int index_2) {
        int temp = nums[index_1];
        nums[index_1] = nums[index_2];
        nums[index_2] = temp;
    }
}

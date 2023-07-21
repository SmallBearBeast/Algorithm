package com.example.algorithm.leetcode.first;
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Determine if you are able to reach the last index.
//
// Example 1:
//
//
//Input: [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//w
// Example 2:
//
//
//Input: [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum
//             jump length is 0, which makes it impossible to reach the last index.
//
// Related Topics Array Greedy

public class Solution_55 {
    public static void main(String[] args) {
        Solution_55 solution = new Solution_55();
        boolean result = solution.mySolution(new int[]{
                3, 2, 1, 0, 4
        });
        String s = null;
    }

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public boolean mySolution(int[] nums) {
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] > 0) {
                index--;
                continue;
            }
            if (nums[index] == 0) {
                int temp = index - 1;
                while (temp >= 0 && nums[temp] <= index - temp) {
                    temp--;
                }
                if (temp == -1) {
                    return false;
                }
                index = temp - 1;
            }
        }
        return true;
    }

}

package com.example.algorithm.offer;

//找出数组中重复的数字。
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
//示例 1：
//
//输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//         
//
//限制：
//
//2 <= n <= 100000

public class Solution_3 {
    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        solution.mySolution_2(new int[]{
                2, 3, 1, 0, 2, 5, 3
        });
    }

    public int findRepeatNumber(int[] nums) {
        return 1;
    }

    // hash法
    public int mySolution_1(int[] nums) {
        int[] set = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (set[nums[i]] >= 1) {
                return nums[i];
            }
            set[nums[i]]++;
        }
        return 0;
    }

    // 原数组hash法，不开辟新空间。
    public int mySolution_2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

}

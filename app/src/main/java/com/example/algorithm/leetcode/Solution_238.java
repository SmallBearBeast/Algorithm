package com.example.algorithm.leetcode;

//给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
// 示例:
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6]
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
// 进阶：
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
// Related Topics 数组

public class Solution_238 {
    public static void main(String[] args) {
        Solution_238 solution = new Solution_238();
        solution.mySolution_1(new int[] {
                1, 2, 3, 4, 0
        });
    }

    public int[] productExceptSelf(int[] nums) {
        return null;
    }

    public int[] mySolution_1(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = temp * result[i];
            temp = temp * nums[i];
        }
        return result;
    }

    public int[] mySolution_2(int[] nums) {
        return null;
    }

}

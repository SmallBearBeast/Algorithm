package com.example.algorithm.leetcode.first;

//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
//
//
// 给定 n 和 k，返回第 k 个排列。
//
// 说明：
//
//
// 给定 n 的范围是 [1, 9]。
// 给定 k 的范围是[1, n!]。
//
//
// 示例 1:
//
// 输入: n = 3, k = 3
//输出: "213"
//
//
// 示例 2:
//
// 输入: n = 4, k = 9
//输出: "2314"
//
// Related Topics 数学 回溯算法

public class Solution_60 {
    public static void main(String[] args) {
        Solution_60 solution = new Solution_60();
        solution.mySolution_1(3, 3);
    }

    public String getPermutation(int n, int k) {
        return null;
    }

    public String mySolution_1(int n, int k) {
        int[] nums = new int[n];
        int[] assists = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            assists[i] = 1;
        }
        for (int i = n - 3; i >= 0; i--) {
            assists[i] = assists[i + 1] * (n - i - 1);
        }
        for (int i = 0; i < n - 1; i++) {
            int remain = k % assists[i];
            k = k / assists[i];
            if (remain == 0) {
                top(nums, i, i + k - 1);
                reverse(nums, i + 1, n - 1);
                break;
            }
            if (remain == 1) {
                top(nums, i, i + k);
                break;
            }
            top(nums, i, i + k);
            k = remain;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(nums[i]);
        }
        return builder.toString();
    }

    public void top(int[] nums, int start, int top) {
        int temp = nums[top];
        while (start < top) {
            nums[top] = nums[top - 1];
            top --;
        }
        nums[start] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public String mySolution_2(int n, int k) {
        return null;
    }

}

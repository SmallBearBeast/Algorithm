package com.example.algorithm.leetcode;

//给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
//
// 示例 1:
//
// 输入: nums = [1, 5, 1, 1, 6, 4]
//输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
//
// 示例 2:
//
// 输入: nums = [1, 3, 2, 2, 3, 1]
//输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
//
// 说明:
//你可以假设所有输入都会得到有效的结果。
//
// 进阶:
//你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
// Related Topics 排序

import java.util.Arrays;

public class Solution_324 {
    public static void main(String[] args) {
        Solution_324 solution = new Solution_324();
        int[] result = new int[]{
                4, 5, 5, 6
//                1, 5, 1, 1, 6,
//                1, 1, 1, 2, 2, 2
//                1, 3, 2, 2, 3, 1
        };
        solution.mySolution_2(result);
        System.out.println("result = " + Arrays.toString(result));
    }

    public void wiggleSort(int[] nums) {

    }

    public void mySolution_1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i = i + 2) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i - 1] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
    }

    // 交错法
    public void mySolution_2(int[] nums) {
        int len = nums.length;
        int[] bak = Arrays.copyOf(nums, len);
        Arrays.sort(bak);
        int sStart = (len+1)/2;
        int bStart = len - 1;
        sStart--;
        for (int i = 0; i < len / 2; i++) {
            nums[2 * i] = bak[sStart--];
            nums[2 * i + 1] = bak[bStart--];

        }
        // 处理len(small) - len (big)=1;
        if (len % 2 != 0) {
            nums[len - 1] = bak[0];
        }
    }

}

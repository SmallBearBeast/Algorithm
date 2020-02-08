package com.example.algorithm.leetcode;
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法

import java.util.Arrays;

public class Solution_215 {
    public static void main(String[] args) {
        Solution_215 solution = new Solution_215();
        solution.mySolution_2(new int[]{
                3, 2, 3, 1, 2, 4, 5, 5, 6
        }, 4);
    }

    public int findKthLargest(int[] nums, int k) {
        return 1;
    }

    public int mySolution_1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 小顶堆排序
    public int mySolution_2(int[] nums, int k) {
        // 构建小顶堆
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, k);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[0] > nums[i]) {
                continue;
            }
            nums[0] = nums[i];
            adjustHeap(nums, 0, k);
        }
        return nums[0];
    }

    public void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (j + 1 < length && nums[j] > nums[j + 1]) {
                j++;
            }
            if (temp > nums[j]) {
                nums[i] = nums[j];
                i = j;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

}

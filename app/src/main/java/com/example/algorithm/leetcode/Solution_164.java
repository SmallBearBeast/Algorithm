package com.example.algorithm.leetcode;

//给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//
// 如果数组元素个数小于 2，则返回 0。
//
// 示例 1:
//
// 输入: [3,6,9,1]
//输出: 3
//解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
//
// 示例 2:
//
// 输入: [10]
//输出: 0
//解释: 数组元素个数小于 2，因此返回 0。
//
// 说明:
//
//
// 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
// 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。

import java.util.Arrays;

public class Solution_164 {
    public static void main(String[] args) {
        Solution_164 solution = new Solution_164();
        int result = solution.mySolution_2(new int[]{
                1, 1, 1, 2
        });
        System.out.println("result = " + result);
    }

    public int maximumGap(int[] nums) {
        return 1;
    }

    public int mySolution_1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, nums[i] - nums[i - 1]);
        }
        return result;
    }

    // 桶排序
    public int mySolution_2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max == min) {
            return 0;
        }
        int bucketSize = (max - min) / (nums.length);
        if (bucketSize == 0) {
            bucketSize = 1;
        }
        // 要+1
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / bucketSize;
            if (buckets[index] == null) {
                buckets[index] = new Bucket();
            }
            buckets[index].max = Math.max(buckets[index].max, nums[i]);
            buckets[index].min = Math.min(buckets[index].min, nums[i]);
        }
        int maxResult = 0;
        int firstValue = buckets[0].max;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] != null) {
                maxResult = Math.max(maxResult, buckets[i].min - firstValue);
                firstValue = buckets[i].max;
            }
        }
        return maxResult;
    }

    public class Bucket {
        public int max = Integer.MIN_VALUE;
        public int min = Integer.MAX_VALUE;
    }

}

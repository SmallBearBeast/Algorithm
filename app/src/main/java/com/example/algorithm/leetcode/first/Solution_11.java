package com.example.algorithm.leetcode.first;
/**
 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 返回容器可以储存的最大水量。
 说明：你不能倾斜容器。

 示例 1：
 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

 示例 2：
 输入：height = [1,1]
 输出：1

 提示：
 n == height.length
 2 <= n <= 105
 0 <= height[i] <= 104
**/

public class Solution_11 {
    public static void main(String[] args) {
        Solution_11 solution = new Solution_11();
        solution.mySolution_1(new int[]{
                10, 9, 8, 7, 6, 5, 4, 3, 2, 1
        });
    }

    public int maxArea(int[] height) {
        return 1;
    }

    public int mySolution_1(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = Math.min(height[end], height[start]) * (end - start);
        while (start < end) {
            while (start < end && height[start] <= height[end]) {
                max = Math.max(max, Math.min(height[end], height[start]) * (end - start));
                start++;
            }
            while (start < end && height[start] >= height[end]) {
                max = Math.max(max, Math.min(height[end], height[start]) * (end - start));
                end--;
            }
        }
        return max;
    }

    public int mySolution_2(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, Math.min(height[end], height[start]) * (end - start));
            if (height[start] < height[end]) {
                start ++;
            } else {
                end --;
            }
        }
        return max;
    }

}

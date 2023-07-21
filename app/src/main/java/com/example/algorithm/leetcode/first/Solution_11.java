package com.example.algorithm.leetcode.first;
//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
// Note: You may not slant the container and n is at least 2.
//
//
//
//
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//
//
//
// Example:
//
//
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics Array Two Pointers

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

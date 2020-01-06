package com.example.algorithm.leetcode;
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
// Example:
//
//
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
// Related Topics Array Two Pointers Stack

public class Solution_42 {
    public static void main(String[] args) {
        Solution_42 solution = new Solution_42();
        solution.mySolution_1(new int[]{
                5, 4, 1, 2
        });
    }

    public int trap(int[] height) {
        return 1;
    }

    public int mySolution_1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
        }
        return recursive_1(height, maxIndex, maxIndex);
    }

    public int recursive_1(int[] height, int start, int end) {
        if (start <= 1 && end >= height.length - 2) {
            return 0;
        }
        int water = 0;
        int maxEndIndex = end + 1;
        if (end < height.length - 2) {
            for (int i = maxEndIndex + 1; i < height.length; i++) {
                if (height[maxEndIndex] <= height[i]) {
                    maxEndIndex = i;
                }
            }
            for (int i = end + 1; i <= maxEndIndex - 1; i++) {
                water = water + height[maxEndIndex] - height[i];
            }
        }

        int maxStartIndex = start - 1;
        if (start >= 2) {
            for (int i = maxStartIndex - 1; i >= 0; i--) {
                if (height[maxStartIndex] <= height[i]) {
                    maxStartIndex = i;
                }
            }
            for (int i = start - 1; i >= maxStartIndex + 1; i--) {
                water = water + height[maxStartIndex] - height[i];
            }
        }
        return water + recursive_1(height, maxStartIndex, maxEndIndex);
    }

}

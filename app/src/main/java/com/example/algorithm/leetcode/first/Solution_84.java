package com.example.algorithm.leetcode.first;
//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//
//
// Example:
//
//
//Input: [2,1,5,6,2,3]
//Output: 10
//
// Related Topics Array Stack

import java.util.Stack;

public class Solution_84 {
    public static void main(String[] args) {
        Solution_84 solution_3 = new Solution_84();
        solution_3.mySolution_1(new int[]{
                2, 1, 5, 6, 2, 3
        });
    }

    public int largestRectangleArea(int[] heights) {
        return 1;
    }

    public int mySolution_1(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int right = i + 1;
            while (right < heights.length && heights[right] >= heights[i]) {
                right++;
            }
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            max = Math.max(max, (right - left - 1) * heights[i]);
        }
        return max;
    }

    public int mySolution_2(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int minIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (heights[minIndex] > heights[i]) {
                minIndex = i;
            }
        }
        return Math.max((end - start + 1) * heights[minIndex],
                Math.max(calculateArea(heights, start, minIndex - 1), calculateArea(heights, minIndex + 1, end)));
    }

    public int mySolution_3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }

}

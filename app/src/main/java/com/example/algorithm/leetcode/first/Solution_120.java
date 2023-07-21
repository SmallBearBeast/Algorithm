package com.example.algorithm.leetcode.first;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划

import java.util.ArrayList;
import java.util.List;

public class Solution_120 {
    public static void main(String[] args) {
        Solution_120 solution = new Solution_120();
        List<Integer> rowOneList = new ArrayList<>();
        rowOneList.add(2);
        List<Integer> rowTwoList = new ArrayList<>();
        rowTwoList.add(3);
        rowTwoList.add(4);
        List<Integer> rowThreeList = new ArrayList<>();
        rowThreeList.add(6);
        rowThreeList.add(5);
        rowThreeList.add(7);
        List<Integer> rowFourList = new ArrayList<>();
        rowFourList.add(4);
        rowFourList.add(1);
        rowFourList.add(8);
        rowFourList.add(3);

        List<List<Integer>> triangleList = new ArrayList<>();
        triangleList.add(rowOneList);
        triangleList.add(rowTwoList);
        triangleList.add(rowThreeList);
        triangleList.add(rowFourList);
        solution.mySolution_1(triangleList);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return 1;
    }

    public int mySolution_1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        List<Integer> lastRowList = triangle.get(triangle.size() - 1);
        int length = lastRowList.size();
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = lastRowList.get(i);
        }

        for (int i = length - 2; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            int size = temp.size();
            for (int j = 0; j < size; j++) {
                values[j] = temp.get(j) + Math.min(values[j], values[j + 1]);
            }
        }
        return values[0];
    }

    public int mySolution_2(List<List<Integer>> triangle) {
        return 1;
    }

}

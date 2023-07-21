package com.example.algorithm.leetcode.first;

//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 3
//输出: [1,3,3,1]
//
//
// 进阶：
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？
// Related Topics 数组

import java.util.ArrayList;
import java.util.List;

public class Solution_119 {
    public static void main(String[] args) {
        Solution_119 solution = new Solution_119();
        solution.mySolution_1(4);
    }

    public List<Integer> getRow(int rowIndex) {
        return null;
    }

    public List<Integer> mySolution_1(int rowIndex) {
        List<Integer> curList = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            curList.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curList.add(1);
                } else {
                    curList.add(preList.get(j) + preList.get(j - 1));
                }
            }
            preList.clear();
            preList.addAll(curList);
        }
        return curList;
    }

    public List<Integer> mySolution_2(int rowIndex) {
        return null;
    }

}

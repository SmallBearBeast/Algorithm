package com.example.algorithm.leetcode.first;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组

import java.util.ArrayList;
import java.util.List;

public class Solution_118 {
    public static void main(String[] args) {
        Solution_118 solution = new Solution_118();
    }

    public List<List<Integer>> generate(int numRows) {
        return null;
    }

    public List<List<Integer>> mySolution_1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preList = null;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                } else {
                    list.add(preList.get(j) + preList.get(j - 1));
                }
            }
            preList = list;
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> mySolution_2(int numRows) {
        return null;
    }

}

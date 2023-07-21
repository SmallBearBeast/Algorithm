package com.example.algorithm.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class Solution_89 {
    public static void main(String[] args) {
        Solution_89 solution = new Solution_89();
        solution.mySolution_1(2);
    }

    public List<Integer> grayCode(int n) {
        return null;
    }

    public List<Integer> mySolution_1(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int step = 1;
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) + step);
            }
            step = step << 1;
        }
        return res;
    }

    public List<Integer> mySolution_2(int n) {
        return null;
    }
}

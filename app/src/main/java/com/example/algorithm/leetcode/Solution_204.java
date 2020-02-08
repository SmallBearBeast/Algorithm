package com.example.algorithm.leetcode;

//统计所有小于非负整数 n 的质数的数量。
//
// 示例:
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//
// Related Topics 哈希表 数学

import java.util.ArrayList;
import java.util.List;

public class Solution_204 {
    public static void main(String[] args) {
        Solution_204 solution = new Solution_204();
        solution.mySolution_2(10);
    }

    public int countPrimes(int n) {
        return 1;
    }

    public int mySolution_1(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            int sqrt = (int) Math.sqrt(i);
            boolean success = true;
            for (int j = 0; j < list.size() && list.get(j) <= sqrt; j++) {
                if (i % list.get(j) == 0) {
                    success = false;
                    break;
                }
            }
            if (success) {
                list.add(i);
            }
        }
        return list.size();
    }

    // 帅选法
    public int mySolution_2(int n) {
        boolean[] tables = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!tables[i]) {
                for (int j = i + i; j < n; j = j + i) {
                    tables[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!tables[i]) {
                count ++;
            }
        }
        return count;
    }

}

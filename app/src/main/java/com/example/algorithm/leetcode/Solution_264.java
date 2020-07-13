package com.example.algorithm.leetcode;

//编写一个程序，找出第 n 个丑数。
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
// Related Topics 堆 数学 动态规划

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution_264 {
    public static void main(String[] args) {
        Solution_264 solution = new Solution_264();
        int result = solution.mySolution_1(284);
        System.out.println("result = " + result);
    }

    public int nthUglyNumber(int n) {
        return 1;
    }

    public int mySolution_1(int n) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> tempSet = new HashSet<>();
        set.add(1);
        treeSet.add(1);
        int count = 1;
        while (!set.isEmpty()) {
            tempSet.clear();
            for (Integer val : set) {
                if (val <= Integer.MAX_VALUE / 2) {
                    tempSet.add(val * 2);
                    treeSet.add(val * 2);
                    System.out.println(val * 2);
                    count++;
                }
                if (val <= Integer.MAX_VALUE / 3) {
                    tempSet.add(val * 3);
                    treeSet.add(val * 3);
                    count++;
                }
                if (val <= Integer.MAX_VALUE / 5) {
                    tempSet.add(val * 5);
                    treeSet.add(val * 5);
                    count++;
                }
            }
            set.clear();
            set.addAll(tempSet);
        }
        Integer[] array = new Integer[treeSet.size()];
        treeSet.toArray(array);
        return array[n - 1];
    }

    public int mySolution_2(int n) {
        return 1;
    }

}

package com.example.algorithm.leetcode.first;

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
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Solution_264 {
    public static void main(String[] args) {
        Solution_264 solution = new Solution_264();
        int result = solution.mySolution_4(1600);
        System.out.println("result = " + result);
    }

    public int nthUglyNumber(int n) {
        return 1;
    }

    // TreeSet做法
    public int mySolution_1(int n) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> tempSet = new HashSet<>();
        set.add(1);
        treeSet.add(1);
        while (!set.isEmpty()) {
            tempSet.clear();
            for (Integer val : set) {
                if (val <= Integer.MAX_VALUE / 2) {
                    tempSet.add(val * 2);
                    treeSet.add(val * 2);
                }
                if (val <= Integer.MAX_VALUE / 3) {
                    tempSet.add(val * 3);
                    treeSet.add(val * 3);
                }
                if (val <= Integer.MAX_VALUE / 5) {
                    tempSet.add(val * 5);
                    treeSet.add(val * 5);
                }
            }
            set.clear();
            set.addAll(tempSet);
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = treeSet.pollFirst();
        }
        return result;
    }

    // 效率不高的动态规划
    public int mySolution_2(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            long temp = Long.MAX_VALUE;
            for (int j = i - 1; j >= 1; j--) {
                if (dp[j] * 2 > dp[i - 1]) {
                    temp = Math.min(temp, dp[j] * 2);
                    continue;
                }
                if (dp[j] * 3 > dp[i - 1]) {
                    temp = Math.min(temp, dp[j] * 3);
                    continue;
                }
                if (dp[j] * 5 > dp[i - 1]) {
                    temp = Math.min(temp, dp[j] * 5);
                    continue;
                }
                break;
            }
            dp[i] = temp;
        }
        return (int) dp[n];
    }

    // 动态规划高效法
    public int mySolution_3(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int temp = 1;
        for (int i = 1; i < n; i++) {
            temp = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = temp;
            if (temp == nums[i2] * 2) {
                i2++;
            }
            if (temp == nums[i3] * 3) {
                i3++;
            }
            if (temp == nums[i5] * 5) {
                i5++;
            }
        }
        return nums[n - 1];
    }

    // 堆
    public int mySolution_4(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.add(1L);
        long result = 1;
        for (int i = 0; i < 1690; i++) {
            result = heap.poll();
            n --;
            if (n == 0) {
                break;
            }
            if (!set.contains(result * 2)) {
                heap.add(result * 2);
                set.add(result * 2);
            }
            if (!set.contains(result * 3)) {
                heap.add(result * 3);
                set.add(result * 3);
            }
            if (!set.contains(result * 5)) {
                heap.add(result * 5);
                set.add(result * 5);
            }
        }
        return (int) result;
    }

}

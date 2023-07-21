package com.example.algorithm.leetcode.first;

//找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
//
// 示例 1:
//
//
//输入:
//s = "aaabb", k = 3
//
//输出:
//3
//
//最长子串为 "aaa" ，其中 'a' 重复了 3 次。
//
//
// 示例 2:
//
//
//输入:
//s = "ababbc", k = 2
//
//输出:
//5
//
//最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
//
//


public class Solution_395 {
    public static void main(String[] args) {
        Solution_395 solution = new Solution_395();
        int result = solution.mySolution_1("ababbc", 2);
        System.out.println("result = " + result);
    }

    public int longestSubstring(String s, int k) {
        return 1;
    }

    // 分支递归法
    public int mySolution_1(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a'] ++;
        }
        int index = 0;
        while (index < s.length() && counts[s.charAt(index) - 'a'] >= k) {
            index ++;
        }
        if (index == s.length()) {
            return index;
        }
        int l = mySolution_1(s.substring(0, index), k);
        while (index < s.length() && counts[s.charAt(index) - 'a'] < k) {
            index ++;
        }
        int r = mySolution_2(s.substring(index), k);
        return Math.max(l, r);
    }

//    public int recursive_1(String s, int k) {
//
//    }

    public int mySolution_2(String s, int k) {
        return 1;
    }

}

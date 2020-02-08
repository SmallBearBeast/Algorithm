package com.example.algorithm.leetcode;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_3 {
    public static void main(String[] args) {
        Solution_3 solution_3 = new Solution_3();
        solution_3.mySolution_3("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        return mySolution(s);
    }

    // 滑动窗口
    public int mySolution_1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int length = s.length();
        int result = 0;
        while (start < length && end < length) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end ++;
                result = Math.max(end - start, result);
            } else {
                set.remove(s.charAt(start));
                start ++;
            }
        }
        return result;
    }

    // map优化的滑动窗口
    public int mySolution_2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            map.put(s.charAt(i), i);
            result = Math.max(i - start + 1, result);
        }
        return result;
    }

    // 数组优化的滑动窗口
    public int mySolution_3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] indexs = new int[128];
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = -1;
        }
        int start = 0;
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (indexs[s.charAt(i)] != -1) {
                start = Math.max(indexs[s.charAt(i)] + 1, start);
            }
            indexs[s.charAt(i)] = i;
            result = Math.max(i - start + 1, result);
        }
        return result;
    }

    public int mySolution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }
        int result = dp[0];
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= i - dp[i - 1]; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    break;
                }
                dp[i] ++;
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}

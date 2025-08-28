package com.example.algorithm.leetcode.second;

import com.example.algorithm.structure.SolutionUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。

示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

提示：
0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
 */

public class LeetCode_3 {
    public static void main(String[] args) {
        LeetCode_3_Solution_1 solution = new LeetCode_3_Solution_1();
        SolutionUtil.print(solution.lengthOfLongestSubstring("pwwkew"));
    }

    // 滑动窗口法，通过双指针过滤重复判断
    private static class LeetCode_3_Solution_1 {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int right = 0;
            int longestSubStrLength = 0;
            Set<Character> set = new HashSet<>();
            while (right < s.length()) {
                if (!set.contains(s.charAt(right))) {
                    set.add(s.charAt(right));
                    right++;
                } else {
                    longestSubStrLength = Math.max(longestSubStrLength, right - left);
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            return Math.max(longestSubStrLength, right - left);
        }
    }

    // Map优化的滑动窗口，Map用来判断重复字符的同时也记录最新重复字符的位置。
    private static class LeetCode_3_Solution_2 {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int right = 0;
            int longestSubStrLength = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (right < s.length()) {
                if (map.containsKey(s.charAt(right))) {
                    // 这边需要用max是因为，map可能匹配到之前冗余的字符。
                    left = Math.max(left, map.get(s.charAt(right)) + 1);
                }
                longestSubStrLength = Math.max(longestSubStrLength, right - left + 1);
                map.put(s.charAt(right), right);
                right++;
            }
            return longestSubStrLength;
        }
    }

    // 数组优化的滑动窗口，利用char字符值来作为hash桶的位置index。
    // 前提是给定字符串是assci编码
    private static class LeetCode_3_Solution_3 {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int right = 0;
            int longestSubStrLength = 0;
            int[] hashes = new int[128];
            // 不能使用0作为hash桶空的标识，因为数组第一个下标是0。
            Arrays.fill(hashes, -1);
            while (right < s.length()) {
                if (hashes[s.charAt(right)] != -1) {
                    // 这边需要用max是因为，map可能匹配到之前冗余的字符。
                    left = Math.max(left, hashes[s.charAt(right)] + 1);
                }
                longestSubStrLength = Math.max(longestSubStrLength, right - left + 1);
                hashes[s.charAt(right)] = right;
                right++;
            }
            return longestSubStrLength;
        }
    }
}

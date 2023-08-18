package com.example.algorithm.leetcode.second;

import com.example.algorithm.structure.SolutionUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
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

public class Solution_3 {
    public static void main(String[] args) {
        Solution_3 solution_module = new Solution_3();
        SolutionUtil.print(solution_module.mySolution_1("pwwkew"));
    }

    // 滑动窗口法，本质就是判断每一个字符开头组成的最大无重复子串。
    public int mySolution_1(String s) {
        int start = 0;
        int end = 0;
        int longestSubStrLength = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();
        while (end < length) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end ++;
            } else {
                longestSubStrLength = Math.max(longestSubStrLength, end - start);
                set.remove(s.charAt(start));
                start ++;
            }
        }
        return Math.max(longestSubStrLength, end - start);
    }

    // Map优化的滑动窗口，Map用来判断重复字符的同时也记录重复字符的位置。
    public int mySolution_2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int length = s.length();
        int longestSubStrLength = 0;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                // 这边需要用max是因为，map可能匹配到之前冗余的字符。
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            map.put(s.charAt(i), i);
            longestSubStrLength = Math.max(i - start + 1, longestSubStrLength);
        }
        return longestSubStrLength;
    }

    // 数组优化的滑动窗口，利用char字符值来作为hash桶的位置index。
    public int mySolution_3(String s) {
        int[] hashes = new int[128];
        int start = 0;
        int length = s.length();
        Arrays.fill(hashes, -1);
        int longestSubStrLength = 0;
        for (int i = 0; i < length; i++) {
            if (hashes[s.charAt(i)] != -1) {
                // 这边需要用max是因为，hash可能匹配到之前冗余的字符。
                start = Math.max(hashes[s.charAt(i)] + 1, start);
            }
            hashes[s.charAt(i)] = i;
            longestSubStrLength = Math.max(i - start + 1, longestSubStrLength);
        }
        return longestSubStrLength;
    }
}

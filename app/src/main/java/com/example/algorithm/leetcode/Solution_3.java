package com.example.algorithm.leetcode;
//Given a string, find the length of the longest substring without repeating characters.
//
//
// Example 1:
//
//
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
//
// Example 2:
//
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
//
// Example 3:
//
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//
//
// Related Topics Hash Table Two Pointers String Sliding Window

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_3 {
    public static void main(String[] args) {
        Solution_3 solution_3 = new Solution_3();
        solution_3.lengthOfLongestSubstring_3("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        return mySolution(s);
    }

    // 滑动窗口
    public int lengthOfLongestSubstring_1(String s) {
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
    public int lengthOfLongestSubstring_2(String s) {
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

    public int lengthOfLongestSubstring_3(String s) {
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

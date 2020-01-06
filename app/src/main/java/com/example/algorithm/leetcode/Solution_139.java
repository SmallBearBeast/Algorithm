package com.example.algorithm.leetcode;
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
// Note:
//
//
// The same word in the dictionary may be reused multiple times in the segmentation.
// You may assume the dictionary does not contain duplicate words.
//
//
// Example 1:
//
//
//Input: s = "leetcode", wordDict = ["leet", "code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
//
//
// Example 2:
//
//
//Input: s = "applepenapple", wordDict = ["apple", "pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//             Note that you are allowed to reuse a dictionary word.
//
//
// Example 3:
//
//
//Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//Output: false
//
// Related Topics Dynamic Programming

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution_139 {
    public static void main(String[] args) {
        Solution_139 solution_3 = new Solution_139();
//        boolean result = solution_3.mySolution_2("aaaaaaaaaaaaaaaaab", Arrays.asList(
//                "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"
//        ));
        boolean result = solution_3.mySolution_4("applepenapple", Arrays.asList(
                "apple", "pen"
        ));
        String s = null;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    public boolean mySolution_1(String s, List<String> wordDict) {
        return recursive(s, wordDict);
    }

    public boolean mySolution_2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (String word : wordDict) {
                int index = s.indexOf(word, i);
                if (index == i && i + word.length() - 1 < dp.length) {
                    dp[i + word.length() - 1] = true;
                }
            }
            while (i < dp.length && !dp[i]) {
                i++;
            }
        }
        return dp[dp.length - 1];
    }

    public boolean mySolution_3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // 使用宽度优先搜索
    public boolean mySolution_4(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    // 超时
    public boolean recursive(String s, List<String> wordDict) {
        for (String word : wordDict) {
            int index = s.indexOf(word);
            if (index == 0 && (index + word.length() == s.length() || recursive(s.substring(index + word.length()), wordDict))) {
                return true;
            }
        }
        return false;
    }


}

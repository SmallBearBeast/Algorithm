package com.example.algorithm.leetcode.first;

//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。
//
// 说明：
//
//
// 分隔时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
//
//
// 示例 2：
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
//
// Related Topics 动态规划 回溯算法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_140 {
    public static void main(String[] args) {
        Solution_140 solution = new Solution_140();
//        solution.mySolution_3("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        solution.mySolution_3("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return null;
    }

    // 递归回溯超时
    public List<String> mySolution_1(String s, List<String> wordDict) {
        List<List<String>> result = new ArrayList<>();
        recursive_1(s, new HashSet<>(wordDict), 0, new Boolean[s.length()], new ArrayList<String>(), result);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            StringBuilder builder = new StringBuilder();
            List<String> temp = result.get(i);
            for (int j = 0; j < temp.size(); j++) {
                builder.append(temp.get(j));
                if (j < temp.size() - 1) {
                    builder.append(" ");
                }
            }
            list.add(builder.toString());
        }
        return list;
    }

    public boolean recursive_1(String s, Set<String> wordDict, int start, Boolean[] visit, List<String> list, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return true;
        }
//        if (visit[start] != null) {
//            list.add(s.substring(start));
//            result.add(new ArrayList<>(list));
//            list.remove(list.size() - 1);
//            return visit[start];
//        }
        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (wordDict.contains(word)) {
                list.add(word);
                if (recursive_1(s, wordDict, i, visit, list, result)) {
                    visit[start] = true;
                }
                list.remove(list.size() - 1);
            }
        }
        if (visit[start] == null) {
            visit[start] = false;
        }
        return false;
    }

    public List<String> mySolution_2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> initList = new ArrayList<>();
        initList.add(new ArrayList<String>());
        map.put(0, initList);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (map.containsKey(j) && wordDictSet.contains(word)) {
                    List<List<String>> list = map.get(j);
                    List<List<String>> newList = map.get(i);
                    if (newList == null) {
                        newList = new ArrayList<>();
                        map.put(i, newList);
                    }
                    for (List<String> strings : list) {
                        List<String> tempList = new ArrayList<>(strings);
                        tempList.add(word);
                        newList.add(tempList);
                    }
                }
            }
        }
        List<List<String>> result = map.get(s.length());
        if (result == null) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            StringBuilder builder = new StringBuilder();
            List<String> temp = result.get(i);
            for (int j = 0; j < temp.size(); j++) {
                builder.append(temp.get(j));
                if (j < temp.size() - 1) {
                    builder.append(" ");
                }
            }
            list.add(builder.toString());
        }
        return list;
    }

    public List<String> mySolution_3(String s, List<String> wordDict) {
        List<String> result = recursive_3(s, new HashSet<>(wordDict), 0);
        return result;
    }

    public Map<Integer, List<String>> wordMap = new HashMap<>();
    public List<String> recursive_3(String s, Set<String> wordDict, int start) {
        if (wordMap.containsKey(start)) {
            return wordMap.get(start);
        }

        List<String> curList = new ArrayList<>();
        if (start == s.length()) {
            curList.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordDict.contains(word)) {
                List<String> nextList = recursive_3(s, wordDict, end);
                wordMap.put(start, curList);
                for (String ss : nextList) {
                    curList.add(end == s.length() ? word + ss : word + " " + ss);
                }
            }
        }
        return curList;
    }
}

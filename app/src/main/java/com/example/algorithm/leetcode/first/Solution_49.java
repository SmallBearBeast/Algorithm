package com.example.algorithm.leetcode.first;
//Given an array of strings, group anagrams together.
//
// Example:
//
//
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// Note:
//
//
// All inputs will be in lowercase.
// The order of your output does not matter.
//
// Related Topics Hash Table String

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_49 {
    public static void main(String[] args) {
        Solution_49 solution = new Solution_49();
        String[] strs = new String[] {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        solution.groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Set[] sets = new HashSet[strs.length];
        boolean[] checks = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            sets[i] = new HashSet();
            sets[i].addAll(Arrays.asList(strs[i].toCharArray()));
        }
        for (int i = 0; i < strs.length; i++) {
            if (checks[i]) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (sets[i].equals(sets[j])) {
                    list.add(strs[j]);
                    checks[j] = true;
                }
            }
            result.add(list);
        }
        return result;
    }

    public List<List<String>> mySolution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] letters = strs[i].toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }


}

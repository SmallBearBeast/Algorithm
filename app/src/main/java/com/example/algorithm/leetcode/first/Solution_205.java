package com.example.algorithm.leetcode.first;

//给定两个字符串 s 和 t，判断它们是否是同构的。
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
//
// 示例 1:
//
// 输入: s = "egg", t = "add"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "foo", t = "bar"
//输出: false
//
// 示例 3:
//
// 输入: s = "paper", t = "title"
//输出: true
//
// 说明:
//你可以假设 s 和 t 具有相同的长度。
// Related Topics 哈希表

import java.util.HashMap;
import java.util.Map;

public class Solution_205 {
    public static void main(String[] args) {
        Solution_205 solution = new Solution_205();
        boolean result = solution.mySolution_1("ab", "aa");
        System.out.println("result = " + result);
    }

    public boolean isIsomorphic(String s, String t) {
        return false;
    }

    public boolean mySolution_1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();
        Map<Character, Boolean> existMap = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);
            if (charMap.get(charS) == null) {
                if (existMap.get(charT) != null) {
                    return false;
                }
                existMap.put(charT, true);
                charMap.put(charS, charT);
            } else if (charMap.get(charS) != charT) {
                return false;
            }
        }
        return true;
    }

    // 左到右遍历 右到左遍历
    public boolean mySolution_2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        return helper(s, t) && helper(t, s);
    }

    public boolean helper(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);
            if (charMap.get(charS) == null) {
                charMap.put(charS, charT);
            } else if (charMap.get(charS) != charT) {
                return false;
            }
        }
        return true;
    }

    public boolean mySolution_3(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}

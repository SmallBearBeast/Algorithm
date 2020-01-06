package com.example.algorithm.leetcode;
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
// 返回 s 所有可能的分割方案。
//
// 示例:
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//]
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.List;

public class Solution_131 {
    public static void main(String[] args) {
        Solution_131 solution = new Solution_131();
        solution.mySolution_1("aab");
    }

    public List<List<String>> partition(String s) {
        return null;
    }

    public List<List<String>> mySolution_1(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        recursive_1(res, s, 0, s.length() - 1, new ArrayList<String>());
        return res;
    }

    public void recursive_1(List<List<String>> res, String origin, int start, int end, List<String> temp) {
        if (start > end) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= end; i++) {
            if (!isPalindrome(origin, start, i)) {
                continue;
            }
            temp.add(origin.substring(start, i + 1));
            recursive_1(res, origin, i + 1, end, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

}

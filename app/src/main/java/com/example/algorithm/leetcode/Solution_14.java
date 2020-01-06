package com.example.algorithm.leetcode;

//Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
//
//Input: ["flower","flow","flight"]
//Output: "fl"
//
//
// Example 2:
//
//
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//
//
// Note:
//
// All given inputs are in lowercase letters a-z.
// Related Topics String

public class Solution_14 {
    public static void main(String[] args) {
        Solution_14 solution = new Solution_14();
        int[] nums = {0, 0, 0, 0, 0, 0};
        solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs.length;
        String result = strs[0];
        for (int i = 1; i < length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty()) {
                    return "";
                }
            }
        }
        return result;
    }

    public String mySolution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}

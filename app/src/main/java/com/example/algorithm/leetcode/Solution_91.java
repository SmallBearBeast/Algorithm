package com.example.algorithm.leetcode;
//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// Given a non-empty string containing only digits, determine the total number of ways to decode it.
//
// Example 1:
//
//
//Input: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//
//
// Example 2:
//
//
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
// Related Topics String Dynamic Programming

import java.util.List;
import java.util.Map;

public class Solution_91 {
    public static void main(String[] args) {
        Solution_91 solution = new Solution_91();
        solution.mySolution("1");
    }

    public int numDecodings(String s) {
        return 1;
    }

    public int mySolution(String s) {
        int length = s.length();
        if (length > 0 && s.charAt(0) == '0') {
            return 0;
        }
        int first = 1;
        int second = 1;
        int result = 1;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    result = first;
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')){
                result = second + first;
            }
            first = second;
            second = result;
        }
        return result;
    }

    public void add(Map<Integer, Character> map, List<String> result, int[] nums, int index, StringBuilder builder) {
        if (index == nums.length) {
            result.add(builder.toString());
            return;
        }
        builder.append(map.get(nums[index]));
        add(map, result, nums, index + 1, builder);
        builder.setLength(builder.length() - 1);
        if (index < nums.length - 1 && nums[index] * 10 + nums[index + 1] <= 26) {
            builder.append(map.get(nums[index] * 10 + nums[index + 1]));
            add(map, result, nums, index + 2, builder);
            builder.setLength(builder.length() - 1);
        }
    }

    public int recursive(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        int result = 0;
        if (s.charAt(index) != '0') {
            result = recursive(s, index + 1);
        }
        if (index < s.length() - 1 && s.charAt(index) != '0') {
            if ((s.charAt(index) - '0') * 10 + s.charAt(index + 1) - '0' <= 26) {
                result = result + recursive(s, index + 2);
            }
        }
        return result;
    }
}

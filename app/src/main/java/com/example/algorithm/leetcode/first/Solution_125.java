package com.example.algorithm.leetcode.first;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串

public class Solution_125 {
    public static void main(String[] args) {
        Solution_125 solution = new Solution_125();
        boolean result = solution.isPalindrome("1b1");
        System.out.println("result = " + result);
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !isValid(s.charAt(start))) {
                start ++;
            }
            while (start < end && !isValid(s.charAt(end))) {
                end --;
            }
            if (start < end && !isAlphaEqual(s.charAt(start), s.charAt(end))) {
                return false;
            } else {
                start ++;
                end --;
            }
        }
        return true;
    }

    public boolean isValid(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public boolean isAlphaEqual(char ch1, char ch2) {
        return ch1 == ch2 || (((ch1 >= 'A' && ch1 <= 'Z') || (ch1 >= 'a' && ch1 <= 'z'))
                && ((ch2 >= 'A' && ch2 <= 'Z') || (ch2 >= 'a' && ch2 <= 'z'))
                && Math.abs(ch1 - ch2) == 32);
    }

    public boolean mySolution_1(String s) {
        s = s.toLowerCase();
        StringBuilder builder  = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString().equals(builder.reverse().toString());
    }

    public boolean mySolution_2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

}

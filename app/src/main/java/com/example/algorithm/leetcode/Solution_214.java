package com.example.algorithm.leetcode;

//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
//
// 示例 1:
//
// 输入: "aacecaaa"
//输出: "aaacecaaa"
//
//
// 示例 2:
//
// 输入: "abcd"
//输出: "dcbabcd"
// Related Topics 字符串

public class Solution_214 {
    public static void main(String[] args) {
        Solution_214 solution = new Solution_214();
        String result = solution.mySolution_3("aacecaaa");
        System.out.println("result = " + result);
    }

    public String shortestPalindrome(String s) {
        return null;
    }

    public String mySolution_1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            start = 0;
            end = i;
            boolean isPalindrome = true;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    isPalindrome = false;
                    break;
                }
                start ++;
                end --;
            }
            if (isPalindrome) {
                end = i;
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        return builder.append(s.substring(end + 1)).reverse().append(s).toString();
    }


    public String mySolution_2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0;
        int end = 0;
        int index = s.length() - 1;
        char firstCh = s.charAt(0);
        while (index >= 0) {
            start = 0;
            end = index;
            boolean isPalindrome = true;
            int lastIndex = index;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    isPalindrome = false;
                    break;
                }
                if (s.charAt(end) == firstCh) {
                    lastIndex = end;
                }
                start ++;
                end --;
            }
            if (isPalindrome) {
                end = index;
                break;
            }
            if (lastIndex != index) {
                index = lastIndex;
            } else {
                index = end - 1;
            }
        }
        StringBuilder builder = new StringBuilder();
        return builder.append(s.substring(end + 1)).reverse().append(s).toString();
    }

    public String mySolution_3(String s) {
        int[] pmt = pmt(s + "#" + new StringBuilder(s).reverse().toString());
        return new StringBuilder().append(s.substring(pmt[pmt.length - 1])).reverse().append(s).toString();
    }

    public int[] pmt(String pat) {
        int[] pmt = new int[pat.length()];
        int i = 1;
        int j = 0;
        while (i < pmt.length) {
            if (pat.charAt(i) == pat.charAt(j)) {
                pmt[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    i ++;
                } else {
                    j = pmt[j - 1];
                }
            }
        }
        return pmt;
    }
}

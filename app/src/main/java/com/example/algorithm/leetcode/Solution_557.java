package com.example.algorithm.leetcode;

//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
// 示例 1:
//
//
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
//
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
// Related Topics 字符串

public class Solution_557 {
    public static void main(String[] args) {
        Solution_557 solution = new Solution_557();
        solution.mySolution_1("Let's take LeetCode contest");
    }

    public String reverseWords(String s) {
        return null;
    }

    public String mySolution_1(String s) {
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(strs[i].toCharArray()).reverse();
            res.append(builder);
            if (i < strs.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public String mySolution_2(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, left, i - 1);
                left = i + 1;
            }
        }
        reverse(chars, left, chars.length - 1);
        return new String(chars);
    }

    public char[] reverse(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left ++;
            right --;
        }
        return chars;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left ++;
            right --;
        }
    }

}

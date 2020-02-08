package com.example.algorithm.leetcode;

//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
//
// 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
//
//
//
// 示例:
//
// 输入: "Hello World"
//输出: 5
//
// Related Topics 字符串

public class Solution_58 {
    public static void main(String[] args) {
        Solution_58 solution = new Solution_58();
    }

    public int lengthOfLastWord(String s) {
        return 1;
    }

    public int mySolution_1(String s) {
        String[] strs = s.split(" ");
        return strs.length == 0 ? 0 : strs[strs.length - 1].length();
    }

    public int mySolution_2(String s) {
        int length = s.length();
        int res = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res ++;
            } else if (res > 0) {
                return res;
            }
        }
        return res;
    }

}

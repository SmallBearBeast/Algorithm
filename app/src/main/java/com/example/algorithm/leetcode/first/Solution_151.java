package com.example.algorithm.leetcode.first;

//给定一个字符串，逐个翻转字符串中的每个单词。
//
//
//
// 示例 1：
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
//
//
// 示例 2：
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//
//
// 示例 3：
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
//
//
// 说明：
//
//
// 无空格字符构成一个单词。
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
//
//
// 进阶：
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
// Related Topics 字符串

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_151 {
    public static void main(String[] args) {
        Solution_151 solution = new Solution_151();
        solution.mySolution_1("the  the");
    }

    public String reverseWords(String s) {
        return null;
    }

    public String mySolution_1(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            builder.append(strs[i]);
            if (i > 0 && !strs[i].isEmpty()) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public String mySolution_2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

}

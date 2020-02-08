package com.example.algorithm.offer;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//示例 1：
//输入：s="We are happy." 
//输出："We%20are%20happy."
//限制：
//0<=s 的长度<=10000

public class Solution_5 {
    public static void main(String[] args) {
        Solution_5 solution = new Solution_5();
    }

    public String replaceSpace(String s) {
        return null;
    }

    public String mySolution_1(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return s.replace(" ", "%20");
    }

    public String mySolution_2(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

}

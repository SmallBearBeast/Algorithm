package com.example.algorithm.leetcode.first;

//给定两个二进制字符串，返回他们的和（用二进制表示）。
//
// 输入为非空字符串且只包含数字 1 和 0。
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
// Related Topics 数学 字符串

public class Solution_67 {
    public static void main(String[] args) {
        Solution_67 solution = new Solution_67();
    }

    public String addBinary(String a, String b) {
        return null;
    }

    // 逐位计算
    public String mySolution_1(String a, String b) {
        int index = 0;
        int step = 0;
        char charA;
        char charB;
        int lengthA = a.length();
        int lengthB = b.length();
        StringBuilder builder = new StringBuilder();
        while(index < lengthA && index < lengthB) {
            charA = a.charAt(lengthA - index - 1);
            charB = b.charAt(lengthB - index - 1);
            if (charA == charB) {
                builder.append(step);
                if (charA == '0') {
                    step = 0;
                } else {
                    step = 1;
                }
            } else {
                if (step == 1) {
                    builder.append(0);
                    step = 1;
                } else {
                    builder.append(1);
                    step = 0;
                }
            }
            index ++;
        }
        if (index == lengthA) {
            while (index < lengthB) {
                charB = b.charAt(lengthB - index - 1);
                if (step == 0) {
                    builder.append(charB);
                } else {
                    if (charB == '1') {
                        builder.append(0);
                        step = 1;
                    } else {
                        builder.append(1);
                        step = 0;
                    }
                }
                index ++;
            }
        }
        if (index == lengthB) {
            while (index < lengthA) {
                charA = a.charAt(lengthA - index - 1);
                if (step == 0) {
                    builder.append(charA);
                } else {
                    if (charA == '1') {
                        builder.append(0);
                        step = 1;
                    } else {
                        builder.append(1);
                        step = 0;
                    }
                }
                index ++;
            }
        }
        if (step == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }

    // 逐位计算，先确定大小，奇数偶数判断。
    public String mySolution_2(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        if (lengthA > lengthB) {
            return mySolution_2(b, a);
        }
        int index = 0;
        int step = 0;
        StringBuilder builder = new StringBuilder();
        while(index < lengthB) {
            if (index < lengthA && a.charAt(lengthA - index - 1) == '1') {
                step ++;
            }
            if (index < lengthB && b.charAt(lengthB - index - 1) == '1') {
                step ++;
            }
            builder.append(step % 2);
            step = step >> 1;
            index ++;
        }
        if (step == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }
}

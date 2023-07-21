package com.example.algorithm.leetcode.first;

//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
// 示例 1:
//
// 输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释:
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2:
//
// 输入: word1 = "intention", word2 = "execution"
//输出: 5
//解释:
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
// Related Topics 字符串 动态规划

import java.util.ArrayList;
import java.util.List;

public class Solution_72 {
    public static void main(String[] args) {
        Solution_72 solution = new Solution_72();
        solution.mySolution_1("horse", "ros");
    }

    public int minDistance(String word1, String word2) {
        return 1;
    }

    // 动态规划
    public int mySolution_1(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < dp.length; i ++) {
            dp[i][0] = i;
        }
        for(int i = 0; i < dp[0].length; i ++) {
            dp[0][i] = i;
        }
        for(int i = 1; i < dp.length; i ++) {
            for(int j = 1; j < dp[0].length; j ++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1] - 1);
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int mySolution_2(String word1, String word2) {
        int res = recursive(word1, word2, 0, 0, 0, 0);
        return 1;
    }

    public int recursive(String word1, String word2, int start1, int start2, int lastStart1, int lastStart2) {
        if (start1 == word1.length()) {
            return word2.length() - start2;
        }
        if (start2 == word2.length()) {
            return word1.length() - start1;
        }
        int count_2 = 0;
        char ch = word1.charAt(start1);
        int length = word2.length();
        int index = start2;
        while (index < length) {
            if (word2.charAt(index) == ch) {
                count_2 = Math.max(index - start2, start1 - lastStart1) + recursive(word1, word2, start1 + 1, index + 1, start1, start2);
                break;
            }
            index++;
        }
        if (index == length) {
            count_2 = recursive(word1, word2, start1 + 1, start2, start1, start2);
        }

        int count_1 = 0;
        ch = word2.charAt(start2);
        length = word1.length();
        index = start1;
        while (index < length) {
            if (word1.charAt(index) == ch) {
                count_1 = Math.max(index - start1, start2 - lastStart2) + recursive(word1, word2, index + 1, start2 + 1, start1, start2);
                break;
            }
            index++;
        }
        if (index == length) {
            count_1 = recursive(word1, word2, start1, start2 + 1, start1, start2);
        }
        return Math.min(count_1, count_2);
    }

    public int forward(String word1, String word2) {
        int len_1 = word1.length();
        int len_2 = word2.length();
        int tempIndex = 0;
        List<Integer> list_1 = new ArrayList<>();
        List<Integer> list_2 = new ArrayList<>();
        list_1.add(-1);
        list_2.add(-1);
        for (int i = 0; i < len_2; i++) {
            char ch = word2.charAt(i);
            int j = tempIndex;
            while (j < len_1) {
                if (word1.charAt(j) == ch) {
                    list_1.add(j);
                    list_2.add(i);
                    break;
                }
                j ++;
            }
            if (j < len_1) {
                tempIndex = j + 1;
            }
        }
        list_1.add(len_1);
        list_2.add(len_2);
        int size = list_1.size();
        int res = 0;
        for (int i = 1; i < size; i++) {
            res = res + Math.max(Math.abs(list_1.get(i) - list_1.get(i - 1)), Math.abs(list_2.get(i) - list_2.get(i - 1))) - 1;
        }
        return res;
    }

    public int backward(String word1, String word2) {
        int len_1 = word1.length();
        int len_2 = word2.length();
        int tempIndex = len_1 - 1;
        List<Integer> list_1 = new ArrayList<>();
        List<Integer> list_2 = new ArrayList<>();
        list_1.add(len_1);
        list_2.add(len_2);
        for (int i = len_2 - 1; i >= 0; i--) {
            char ch = word2.charAt(i);
            int j = tempIndex;
            while (j >= 0) {
                if (word1.charAt(j) == ch) {
                    list_1.add(j);
                    list_2.add(i);
                    break;
                }
                j --;
            }
            if (j >= 0) {
                tempIndex = j - 1;
            }
        }
        list_1.add(-1);
        list_2.add(-1);
        int size = list_1.size();
        int res = 0;
        for (int i = 1; i < size; i++) {
            res = res + Math.max(Math.abs(list_1.get(i - 1) - list_1.get(i)), Math.abs(list_2.get(i - 1) - list_2.get(i))) - 1;
        }
        return res;
    }
}

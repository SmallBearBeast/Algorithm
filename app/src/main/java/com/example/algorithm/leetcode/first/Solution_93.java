package com.example.algorithm.leetcode.first;
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
// 示例:
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"]
// Related Topics 字符串 回溯算法

import java.util.ArrayList;
import java.util.List;

public class Solution_93 {
    public static void main(String[] args) {
        Solution_93 solution = new Solution_93();
//        solution.mySolution("25525511135");
        solution.mySolution("010010");
    }

    public List<String> restoreIpAddresses(String s) {
        return null;
    }

    public List<String> mySolution(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        recursive(res, s, 4, new StringBuilder());
        return res;
    }

    public void recursive(List<String> res, String s, int frequency, StringBuilder builder) {
        if (s.length() < frequency || s.length() > frequency * 3) {
            return;
        }
        if (frequency == 0 && s.isEmpty()) {
            res.add(builder.substring(0, builder.length() - 1));
            return;
        }
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            if (i == 2) {
                if (s.charAt(0) == '0') {
                    continue;
                }
            }
            if (i == 3) {
                if (s.charAt(0) == '0') {
                    continue;
                }
                if (s.charAt(0) > '2' || (s.charAt(0) == '2' && s.charAt(1) > '5')
                        || (s.charAt(0) == '2' && s.charAt(1) == '5' && s.charAt(2) > '5')) {
                    continue;
                }
            }
            builder.append(s.substring(0, i)).append(".");
            recursive(res, s.substring(i), frequency - 1, builder);
            builder.setLength(builder.length() - i - 1);
        }
    }
}

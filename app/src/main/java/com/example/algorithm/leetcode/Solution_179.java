package com.example.algorithm.leetcode;
//Given a list of non negative integers, arrange them such that they form the largest number.
//
// Example 1:
//
//
//Input: [10,2]
//Output: "210"
//
// Example 2:
//
//
//Input: [3,30,34,5,9]
//Output: "9534330"
//
//
// Note: The result may be very large, so you need to return a string instead of an integer.
// Related Topics Sort

import java.util.Arrays;
import java.util.Comparator;

public class Solution_179 {
    public static void main(String[] args) {
        Solution_179 solution = new Solution_179();
        solution.mySolution_2(new int[]{
                3, 30, 34, 5, 9, 0, 33, 4
        });
    }

    public String largestNumber(int[] nums) {
        return "";
    }

    public String mySolution_1(int[] nums) {
        int maxLevel = 0;
        int[] levels = new int[nums.length];
        int[] firsts = new int[nums.length];
        int[][] news = new int[10][1];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while (temp != 0) {
                levels[i]++;
                firsts[i] = temp;
                temp = temp / 10;
            }
            maxLevel = Math.max(maxLevel, levels[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int base = 1;
            int temp = 0;
            for (int j = 0; j < maxLevel - levels[i]; j++) {
                temp = temp + firsts[i] * base;
                base = base * 10;
            }
            news[firsts[i]][0] = news[firsts[i]][0] + maxLevel - levels[i];
            nums[i] = temp + nums[i] * base;
        }

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 10 == 0) {
                continue;
            }
            int temp = nums[i] % 10;
            while (news[temp][0] > 0) {
                news[temp][0] --;
                nums[i] = nums[i] / 10;
                if (nums[i] < 10 && nums[i] % 10 != temp) {
                    break;
                }
            }

        }

        StringBuilder builder = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            builder.append(nums[i]);
        }
        return builder.toString();
    }

    public String mySolution_2(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < numStrs.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String second, String first) {
                String tempFirst = first + second;
                String tempSecond = second + first;
                return tempFirst.compareTo(tempSecond);
            }
        });
        if (numStrs[0].equals("0")) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numStrs.length; i++) {
            builder.append(numStrs[i]);
        }
        return builder.toString();
    }
}

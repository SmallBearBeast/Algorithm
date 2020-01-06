package com.example.algorithm.leetcode;
//Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
//
// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
//
// You may assume the integer does not contain any leading zero, except the number 0 itself.
//
// Example 1:
//
//
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//
//
// Example 2:
//
//
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// Related Topics Array

public class Solution_66 {
    public static void main(String[] args) {
        Solution_66 solution_3 = new Solution_66();
    }

    public int[] plusOne(int[] digits) {
        return null;
    }

    public int[] mySolution(int[] digits) {
        int step = 0;
        int value = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            value = (digits[i] + step) % 10;
            step = (digits[i] + step) / 10;
            digits[i] = value;
        }
        if (step == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
    }
}

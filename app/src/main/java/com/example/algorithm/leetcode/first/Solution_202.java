package com.example.algorithm.leetcode.first;

//Write an algorithm to determine if a number is "happy".
//
// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
// Example:
//
//
//Input: 19
//Output: true
//Explanation:
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// Related Topics Hash Table Math


import java.util.HashSet;
import java.util.Set;

public class Solution_202 {
    public static void main(String[] args) {
        Solution_202 solution = new Solution_202();
    }

    public boolean isHappy(int n) {
        return false;
    }

    public boolean mySolution_1(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = n;
        int result = 0;
        while (true) {
            while (temp > 0) {
                n = temp % 10;
                temp = temp / 10;
                result = result + n * n;
            }
            if (result == 1) {
                return true;
            }
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            temp = result;
            result = 0;
        }
    }

    int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    boolean mySolution_2(int n) {
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

}

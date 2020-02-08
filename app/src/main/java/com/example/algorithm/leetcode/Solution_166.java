package com.example.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_166 {
    public static void main(String[] args) {
        Solution_166 solution = new Solution_166();
        solution.mySolution_1(1, 49);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        return null;
    }

    public String mySolution_1(int numerator, int denominator) {
        long tempNumerator = Math.abs((long)numerator);
        long tempDenominator = Math.abs((long)denominator);
        StringBuilder builder = new StringBuilder();
        builder.append(tempNumerator / tempDenominator);
        long data = tempNumerator % tempDenominator;
        long temp = 1;
        if (data != 0) {
            Set<Long> set = new HashSet<>();
            builder.append(".");
            while (data * 10 < tempDenominator) {
                data = data * 10;
                builder.append(0);
            }
            data = data * 10;
            long start = data / tempDenominator;
            set.add(data / tempDenominator);
            builder.append(data / tempDenominator);
            data = data % tempDenominator;
            while (true) {
                while (data * 10 < tempDenominator) {
                    data = data * 10;
                    builder.append(0);
                }
                data = data * 10;
                set.add(data / tempDenominator);
                builder.append(data / tempDenominator);
                data = data % tempDenominator;
                if (start == data / tempDenominator) {
                    int size = set.size();
                    for (int i = 0; i < size; i++) {

                    }
                }
            }
        }
        return builder.toString();
    }

    public String mySolution_2(int numerator, int denominator) {
        return null;
    }

}

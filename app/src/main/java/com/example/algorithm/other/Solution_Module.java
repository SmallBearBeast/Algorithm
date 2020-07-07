package com.example.algorithm.other;

import java.util.Random;

public class Solution_Module {
    public static void main(String[] args) {
        Solution_Module solution = new Solution_Module();
        solution.mySolution_1(5);
    }

    public int minDistance(String word1, String word2) {
        return 1;
    }


    public int[] mySolution_1(int n) {
        int[] result = new int[n];
        Random random = new Random();
        for (int i = 0; i < result.length; i++) {
            int val = random.nextInt(n) + 1;
            if (result[val - 1] < 0) {
                continue;
            }
            result[i] = val;
            if (result[val - 1] > 0) {
                result[val - 1] = -1 * result[val - 1];
            }
        }
        return result;
    }

    public int mySolution_2(String word1, String word2) {
        return 1;
    }
}

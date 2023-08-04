package com.example.algorithm;

import java.util.Arrays;

public class Solution_Other {
    public static void main(String[] args) {
        Solution_Other solutionOther = new Solution_Other();

        int num = 101;
        System.out.println("1到" + num + "的素数一共有" + solutionOther.countPrimes(num) + "个");


    }

    // 求1到n有几个素数。
    private int countPrimes(int n) {
        boolean[] isPrim = new boolean[n + 1];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrim[i]) {
                count ++;
            }
        }
        return count;
    }
}

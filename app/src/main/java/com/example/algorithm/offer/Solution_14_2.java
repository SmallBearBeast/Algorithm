package com.example.algorithm.offer;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//示例 1：
//输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//示例 2:
//输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//提示：
//2 <= n <= 58

public class Solution_14_2 {
    public static void main(String[] args) {
        Solution_14_2 solution = new Solution_14_2();
        solution.mySolution_2(120);
    }

    public int cuttingRope(int n) {
        return 1;
    }

    // 动态规划法
    public int mySolution_1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = i >> 1;
            for (int j = 1; j <= temp; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }


    // 贪心法循环求余
    public int mySolution_2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        long res = 1;
        for (int i = 0; i < a - 1; i++) {
            res = (res * 3) % 1000000007;
        }
        if (b == 0) {
            return (int) ((res * 3) % 1000000007);
        }
        if (b == 1) {
            return (int) ((res * 4) % 1000000007);
        }
        return (int) ((res * 6) % 1000000007);
    }

    // 循环求余
    public int remainder_1(int x, int a, int p) {
        int res = 1;
        for (int i = 0; i < a; i++) {
            res = (res * x) % p;
        }
        return res;
    }

    // 快速幂求余
    public int remainder_2(int x, int a, int p) {
        int res = 1;
        while (a > 0) {
            if (a % 2 == 1) {
                res = (res * x) % p;
            }
            x = (x * x) % p;
            a = a >> 1;
        }
        return 1;
    }

    // 贪心法快速幂
    public int mySolution_3(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        int p = 1000000007;
        long res = 1;
        long x = 3;
        a --;
        while (a > 0) {
            if (a % 2 == 1) {
                res = (res * x) % p;
            }
            x = (x * x) % p;
            a = a >> 1;
        }
        if (b == 0) {
            return (int) ((res * 3) % 1000000007);
        }
        if (b == 1) {
            return (int) ((res * 4) % 1000000007);
        }
        return (int) ((res * 6) % 1000000007);
    }

}

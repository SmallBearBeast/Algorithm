package com.example.algorithm.leetcode;

public class Solution_KMP {
    public static void main(String[] args) {
        Solution_KMP solution = new Solution_KMP();
        int result = solution.kmp("ababababca", "bca");
        System.out.println("result = " + result);
    }

    public int kmp(String txt, String pat) {
        int[] pmt = pmt(pat);
        int txtIndex = 0;
        int patIndex = 0;
        while (txtIndex < txt.length() && patIndex < pat.length()) {
            if (txt.charAt(txtIndex) == pat.charAt(patIndex)) {
                txtIndex ++;
                patIndex ++;
            } else {
                if (patIndex == 0) {
                    txtIndex ++;
                } else {
                    patIndex = pmt[patIndex - 1];
                }
            }
        }
        if (patIndex == pat.length()) {
            return txtIndex - patIndex;
        }
        return -1;
    }

    /**
     * 获取PMT
     */
    public int[] pmt(String pat) {
        int[] pmt = new int[pat.length()];
        int i = 1;
        while (i < pmt.length) {
            int j = 0;
            while (i < pmt.length && pat.charAt(i) == pat.charAt(j)) {
                pmt[i] = j + 1;
                i ++;
                j ++;
            }
            i ++;
        }
        return pmt;
    }
}

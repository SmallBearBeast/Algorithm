package com.example.algorithm.leetcode.first;
//Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
//
//
//
// Example 1:
//
//
//Input: 00000000000000000000000000001011
//Output: 3
//Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
//
//
// Example 2:
//
//
//Input: 00000000000000000000000010000000
//Output: 1
//Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
//
//
// Example 3:
//
//
//Input: 11111111111111111111111111111101
//Output: 31
//Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
//
//
//
// Note:
//
//
// Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
// In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
//
//
//
//
// Follow up:
//
// If this function is called many times, how would you optimize it?
// Related Topics Bit Manipulation

/*
>> 是带符号右移，若左操作数是正数，则高位补“0”，若左操作数是负数，则高位补“1”.
<< 将左操作数向左边移动，并且在低位补0.
>>> 是无符号右移，无论左操作数是正数还是负数，在高位都补“0”
*/
public class Solution_191 {
    public static void main(String[] args) {
        Solution_191 solution = new Solution_191();
        solution.mySolution_1(3);
    }

    public int hammingWeight(int n) {
        return 1;
    }

    public int mySolution_1(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >>> 1;
        }
        return res;
    }

    public int mySolution_2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }

    public int mySolution_3(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }
}

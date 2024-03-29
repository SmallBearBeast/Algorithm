package com.example.algorithm.leetcode.first;

//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
//
//
//
// 示例 1：
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
//
//
// 示例 2：
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"]
// Related Topics 双指针 字符串

public class Solution_344 {
    public static void main(String[] args) {
        Solution_344 solution = new Solution_344();
    }

    public void reverseString(char[] s) {

    }

    public void mySolution_1(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start ++;
            end --;
        }
    }

    public void mySolution_2(char[] s) {
        recursive_2(s, 0, s.length - 1);
    }

    public void recursive_2(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        recursive_2(s, start + 1, end - 1);
    }
}

package com.example.algorithm.leetcode.first;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,3,2]
//输出: 3
//
//
// 示例 2:
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99
// Related Topics 位运算

// TODO: 2020-02-03 Understand
public class Solution_137 {
    public static void main(String[] args) {
        Solution_137 solution = new Solution_137();
        solution.mySolution_1(new int[]{
                2, 2, 3, 2
        });
    }

    public int singleNumber(int[] nums) {
        return 1;
    }

    public int mySolution_1(int[] nums) {
        int one = 0, two = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            one = ~two & (one ^ num);
            two = ~one & (two ^ num);
        }
        return one;
    }

}

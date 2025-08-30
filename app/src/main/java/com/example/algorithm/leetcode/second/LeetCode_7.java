package com.example.algorithm.leetcode.second;

/*
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。

示例 1：
输入：x = 123
输出：321

示例 2：
输入：x = -123
输出：-321

示例 3：
输入：x = 120
输出：21

示例 4：
输入：x = 0
输出：0

提示：
-231 <= x <= 231 - 1
 */
public class LeetCode_7 {
    public static void main(String[] args) {
        LeetCode_7_Solution_1 solution_1 = new LeetCode_7_Solution_1();
        System.out.println(solution_1.reverse(Integer.MIN_VALUE));
    }
}

class LeetCode_7_Solution_1 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            // 可以简化为res > Integer.MAX_VALUE / 10，因为当明 x 的位数与 INT_MAX 的位数相同，且要推入的数字 digit 为 x 的最高位。由于 x 不超过 INT_MAX，因此 digit 不会超过 INT_MAX 的最高位，即 digit≤2
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x = x / 10;
        }
        return res;
    }
}

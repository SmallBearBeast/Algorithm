package com.example.algorithm.leetcode.second;

public class Solution_55 {
    public static void main(String[] args) {
        Solution_55 solution_55 = new Solution_55();
        boolean result = solution_55.mySolution_1(new int[] {
                1, 1, 1, 0
        });
        System.out.println(result);
    }

    // 正向贪心遍历法。
    public boolean mySolution_1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        int arriveIndex = 0;
        for(int i = 0; i < length; i ++) {
            if (i <= arriveIndex) {
                arriveIndex = Math.max(arriveIndex, i + nums[i]);
                if (arriveIndex >= length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return arriveIndex >= length - 1;
    }

    // 反向贪心遍历法。
    public boolean mySolution_2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}

package com.example.algorithm.leetcode;

public class Solution_213 {
    public static void main(String[] args) {
        Solution_213 solution = new Solution_213();
        int result = solution.mySolution_2(new int[]{
                0, 3, 2, 0
        });

        System.out.println("result = " + result);
    }

    public int rob(int[] nums) {
        return 1;
    }

    // n2遍历，需要记录是否包含首个，垃圾解法其实只需要遍历两次即可
    public int mySolution_1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            int curValue = 0;
            int lastValue = 0;
            boolean curContain = false;
            boolean lastContain = false;
            for (int j = 0; j < nums.length; j++) {
                int index = (i + j) % nums.length;
                int temp = curValue;
                boolean tempContain = curContain;
                if (lastValue + nums[index] >= curValue) {
                    curValue = lastValue + nums[index];
                    if (j == 0) {
                        curContain = true;
                    } else {
                        curContain = lastContain;
                    }
                }
                lastValue = temp;
                lastContain = tempContain;
            }
            if (lastValue != curValue && curContain) {
                curValue = Math.max(curValue - nums[i], lastValue);
            }
            maxValue = Math.max(maxValue, curValue);
        }
        return maxValue;
    }

    // 两次遍历
    public int mySolution_2(int[] nums) {
        int firstCurValue = 0;
        int firstLastValue = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = firstCurValue;
            firstCurValue = Math.max(firstLastValue + nums[i], firstCurValue);
            firstLastValue = temp;
        }
        int secondCurValue = 0;
        int secondLastValue = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = secondCurValue;
            secondCurValue = Math.max(secondLastValue + nums[i], secondCurValue);
            secondLastValue = temp;
        }
        return Math.max(firstCurValue, secondCurValue);
    }
}

package com.example.algorithm.leetcode.second;

import com.example.algorithm.structure.SolutionUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution_735 {
    public static void main(String[] args) {
        Solution_735 solution_735 = new Solution_735();
        int[] result = solution_735.mySolution_1(new int[]{5, 10 , -5});
        SolutionUtil.print(Arrays.toString(result));
    }

    // 栈+alive状态判断
    public int[] mySolution_1(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean alive = true;
            if (asteroids[i] < 0) {
                while (alive && !stack.isEmpty()) {
                    int value = stack.peekLast();
                    if (value <= 0) {
                        break;
                    }
                    alive = -asteroids[i] > value;
                    if (-asteroids[i] >= value) {
                        stack.removeLast();
                    }
                }
            }
            if (alive) {
                stack.addLast(asteroids[i]);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.removeLast();
        }
        return result;
    }
}

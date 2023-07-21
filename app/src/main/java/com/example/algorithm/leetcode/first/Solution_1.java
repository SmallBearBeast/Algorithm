package com.example.algorithm.leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */

public class Solution_1 {
    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] result = solution_1.mySolution_2(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }

    // O(n2)
    public int[] mySolution_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] mySolution_2(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int anotherKey = target - nums[i];
            if (map.containsKey(anotherKey)) {
                List<Integer> anotherIndexList = map.get(anotherKey);
                int size = anotherIndexList.size();
                for (int j = 0; j < size; j++) {
                    int anotherIndex = anotherIndexList.get(j);
                    if (anotherIndex != i) {
                        return new int[]{i, anotherIndex};
                    }
                }
            }
        }
        return new int[]{};
    }

    public int[] mySolution_3(int[] nums, int target) {
        int[] originNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int[] values = new int[2];
        while (startIndex < endIndex) {
            int sum = nums[startIndex] + nums[endIndex];
            if (sum == target) {
                values[0] = nums[startIndex];
                values[1] = nums[endIndex];
                break;
            } else if (sum > target) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < originNums.length; i++) {
            if (result[0] == Integer.MIN_VALUE && values[0] == originNums[i]) {
                result[0] = i;
            } else if (result[1] == Integer.MIN_VALUE && values[1] == originNums[i]) {
                result[1] = i;
            }
        }
        return result;
    }

    // 哈希表
    public int[] mySolution_4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {
        return mySolution_4(nums, target);
    }
}

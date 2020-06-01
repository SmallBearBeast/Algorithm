package com.example.algorithm.leetcode;

//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//
// 说明:
//
//
// 返回的下标值（index1 和 index2）不是从零开始的。
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//
//
// 示例:
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// Related Topics 数组 双指针 二分查找

public class Solution_167 {
    public static void main(String[] args) {
        Solution_167 solution = new Solution_167();
        solution.mySolution_1(new int[]{
                2, 3, 4
        }, 6);
    }

    public int[] twoSum(int[] numbers, int target) {
        return null;
    }

    public int[] mySolution_1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            int start = i + 1;
            int end = numbers.length - 1;
            if (temp < numbers[start] || temp > numbers[end]) {
                continue;
            }
            while (start <= end) {
                int mid = (start + end) >> 1;
                if (numbers[mid] == temp) {
                    return new int[]{
                            i + 1, mid + 1
                    };
                } else if (numbers[mid] > temp) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return null;
    }

    public int[] mySolution_2(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] < target) {
                start++;
            } else if (numbers[start] + numbers[end] > target) {
                end --;
            } else {
                return new int[]{
                    start + 1, end + 1
                };
            }
        }
        return null;
    }

}

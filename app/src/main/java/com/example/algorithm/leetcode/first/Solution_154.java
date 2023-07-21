package com.example.algorithm.leetcode.first;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 注意数组中可能存在重复的元素。
//
// 示例 1：
//
// 输入: [1,3,5]
//输出: 1
//
// 示例 2：
//
// 输入: [2,2,2,0,1]
//输出: 0
//
// 说明：
//
//
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
//
// Related Topics 数组 二分查找

public class Solution_154 {
    public static void main(String[] args) {
        Solution_154 solution = new Solution_154();
        int result = solution.mySolution_1(new int[] {
                0, 1, 1, 0
        });
        System.out.println("result = " + result);
    }

    public int findMin(int[] nums) {
        return 1;
    }

    public int mySolution_1(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end && nums[start] == nums[0] && nums[end] == nums[0]) {
            start ++;
            end --;
        }
        if (start > 0 && start <= end) {
            if (nums[start] != nums[0] && nums[end] != nums[0]) {
                start --;
            }
        }
        int compareStart = nums[start];
        int compareEnd = nums[end];
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > compareEnd) {
                start = mid + 1;
            } else if (nums[mid] < compareStart) {
                end = mid;
            } else {
                return nums[start];
            }
        }
        return nums[start];
    }

    public int mySolution_2(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end])
                end = mid;
            else if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end -= 1;
        }
        return nums[start];
    }

}

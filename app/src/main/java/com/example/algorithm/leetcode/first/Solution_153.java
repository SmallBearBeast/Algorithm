package com.example.algorithm.leetcode.first;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 你可以假设数组中不存在重复元素。
//
// 示例 1:
//
// 输入: [3,4,5,1,2]
//输出: 1
//
// 示例 2:
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0
// Related Topics 数组 二分查找

public class Solution_153 {
    public static void main(String[] args) {
        Solution_153 solution = new Solution_153();
        int result = solution.mySolution_2(new int[] {
                1, 0
        });
        System.out.println("result = " + result);
    }

    public int findMin(int[] nums) {
        return 1;
    }

    public int mySolution_1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    // 二分法
    public int mySolution_2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                start = mid + 1;
            } else if (nums[mid] < nums[0]) {
                end = mid;
            } else {
                return nums[start];
            }
        }
        return nums[start];
    }

    // 最优解，兼容重复元素场景。
    public int mySolution_3(int[] nums) {
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

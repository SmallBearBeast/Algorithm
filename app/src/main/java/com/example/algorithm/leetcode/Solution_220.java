package com.example.algorithm.leetcode;

//在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的
//绝对值也小于等于 ķ 。
//
// 如果存在则返回 true，不存在返回 false。
//
//
//
// 示例 1:
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true
//
// 示例 2:
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true
//
// 示例 3:
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false
// Related Topics 排序 Ordered Map

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution_220 {
    public static void main(String[] args) {
        Solution_220 solution = new Solution_220();
        boolean result = solution.mySolution_4(new int[]{
                2, 0, -2,
        }, 2, 1);
        System.out.println("result = " + result);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return false;
    }

    // 超时
    public boolean mySolution_1(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 超时
    public boolean mySolution_2(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 利用二叉搜索树TreeSet处理
    public boolean mySolution_3(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = treeSet.ceiling((long) nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t) {
                return true;
            }
            Long floor = treeSet.floor((long) nums[i]);
            if (floor != null && nums[i] - floor <= t) {
                return true;
            }
            treeSet.add((long) nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    // 当size = 3, 0, 1, 2 -> 0, -1, -2, -3 -> -1
    public long getIndex(long num, long size) {
        return num < 0 ? (num + 1) / size - 1 : num / size;
    }

    // 桶思想
    public boolean mySolution_4(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        long size = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long index = getIndex(nums[i], size);
            if (map.containsKey(index)) {
                return true;
            }
            if (map.containsKey(index - 1) && Math.abs((long)nums[i] - map.get(index - 1)) <= t) {
                return true;
            }
            if (map.containsKey(index + 1) && Math.abs((long)nums[i] - map.get(index + 1)) <= t) {
                return true;
            }
            map.put(index, (long) nums[i]);
            if (i >= k) {
                map.remove(getIndex(nums[i - k], size));
            }
        }
        return false;
    }
}

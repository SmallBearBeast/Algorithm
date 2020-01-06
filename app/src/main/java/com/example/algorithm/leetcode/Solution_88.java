package com.example.algorithm.leetcode;
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
// Note:
//
//
// The number of elements initialized in nums1 and nums2 are m and n respectively.
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//
//
// Example:
//
//
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// Related Topics Array Two Pointers

public class Solution_88 {
    public static void main(String[] args) {
        Solution_88 solution_3 = new Solution_88();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i --;
            } else if (nums1[i] < nums2[j]){
                nums1[k] = nums2[j];
                j --;
            }
            k --;
        }
        if (i < 0) {
            System.arraycopy(nums1, 0, nums2, 0, j + 1);
        }
    }

    public void mySolution(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i == m && j < n) {
                result[k] = nums2[j];
                j ++;
            } else if (j == n && i < m) {
                result[k] = nums1[i];
                i ++;
            } else if (nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                i ++;
            } else if (nums1[i] > nums2[j]){
                result[k] = nums2[j];
                j ++;
            }
            k ++;
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }

}

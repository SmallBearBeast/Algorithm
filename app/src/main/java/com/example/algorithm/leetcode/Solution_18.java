package com.example.algorithm.leetcode;

//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
// Note:
//
// The solution set must not contain duplicate quadruplets.
//
// Example:
//
//
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
// Related Topics Array Hash Table Two Pointers


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_18 {

    public static void main(String[] args) {
        Solution_18 solution = new Solution_18();
        // int[] nums = {1, 0, -1, 0, -2, 2};
        // 0
        int[] nums = {0, 1, 5, 0, 1, 5, 5, -4};
        // 11
        solution.mySolution(nums, 11);
    }

    // https://leetcode-cn.com/problems/4sum/solution/ji-bai-9994de-yong-hu-you-dai-ma-you-zhu-shi-by-yo/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> mySolution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int start, end, sum;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                start = j + 1;
                end = nums.length - 1;
                while (start < end) {
                    sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                    }
                    if (sum > target) {
                        do {
                            end--;
                        } while (start < end && nums[end] == nums[end + 1]);
                    } else if (sum < target) {
                        do {
                            start++;
                        } while (start < end && nums[start] == nums[start - 1]);
                    } else {
                        do {
                            end--;
                        } while (start < end && nums[end] == nums[end + 1]);
                        do {
                            start++;
                        } while (start < end && nums[start] == nums[start - 1]);
                    }
                }
            }
        }
        return result;
    }

    // https://leetcode-cn.com/problems/4sum/solution/kshu-zhi-he-by-kukubao207/
    // k sum
    public static ArrayList<List<Integer>> kSum(int nums[], int target, int k, int start){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(start>=nums.length)
            return res;
        if(k==2){
            int l = start, h = nums.length-1;
            while(l<h){
                if(nums[l]+nums[h]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[h]);
                    res.add(list);
                    while(l<h&&nums[l]==nums[l+1])
                        l++;
                    while(l<h&&nums[h]==nums[h-1])
                        h--;
                    l++;
                    h--;
                }else if(nums[l]+nums[h]<target)
                    l++;
                else
                    h--;
            }
            return res;
        }
        if(k>2){
            for(int i=start;i<nums.length-k+1;i++){
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if(temp!=null) {
                    for (List<Integer> l : temp) {
                        l.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while(i<nums.length-1&&nums[i]==nums[i+1]){
                    i++;
                }
            }
            return res;
        }
        return res;
    }
}

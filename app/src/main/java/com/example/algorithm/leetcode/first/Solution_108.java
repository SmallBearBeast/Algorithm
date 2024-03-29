package com.example.algorithm.leetcode.first;
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索

import com.example.algorithm.structure.TreeNode;

public class Solution_108 {
    public static void main(String[] args) {
        Solution_108 solution = new Solution_108();
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }

    public TreeNode mySolution_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return recursive_1(nums, 0, nums.length - 1);
    }

    public TreeNode recursive_1(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursive_1(nums, start, mid - 1);
        root.right = recursive_1(nums, mid + 1, end);
        return root;
    }
}

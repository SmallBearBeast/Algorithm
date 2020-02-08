package com.example.algorithm.leetcode;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
// Related Topics 树 深度优先搜索

import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

public class Solution_110 {
    public static void main(String[] args) {
        Solution_110 solution = new Solution_110();
        solution.mySolution_1(SolutionUtil.createTree(new Integer[] {
                3,
                9, 20,
                null, null, 15, 7
        }));
    }

    public boolean isBalanced(TreeNode root) {
        return false;
    }

    public boolean mySolution_1(TreeNode root) {
        return recursive_1(root) != -1;
    }

    public boolean mySolution_2(TreeNode root) {
        return false;
    }

    public int recursive_1(TreeNode root) {
        if (root != null) {
            int left = recursive_1(root.left);
            int right = recursive_1(root.right);
            if (left == -1 || right == -1 || Math.abs(right - left) > 1) {
                return -1;
            }
            return Math.max(right, left) + 1;
        }
        return 0;
    }

}

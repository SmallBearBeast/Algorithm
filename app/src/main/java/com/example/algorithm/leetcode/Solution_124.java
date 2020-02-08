package com.example.algorithm.leetcode;

//给定一个非空二叉树，返回其最大路径和。
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
//
// 示例 1:
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
//
//
// 示例 2:
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42
// Related Topics 树 深度优先搜索

import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

public class Solution_124 {
    public static void main(String[] args) {
        Solution_124 solution = new Solution_124();
        solution.mySolution_1(SolutionUtil.createTree(new Integer[]{
                -1,
                -1, 3
        }));
    }

    public int maxPathSum(TreeNode root) {
        return 0;
    }

    public int mySolution_1(TreeNode root) {
        recursive_1(root);
        return res;
    }

    public int mySolution_2(TreeNode root) {
        return 0;
    }

    public int res = Integer.MIN_VALUE;

    public int recursive_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(recursive_1(root.left), 0);
        int right = Math.max(recursive_1(root.right), 0);
        res = Math.max(res, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}

package com.example.algorithm.leetcode.first;

//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
//
// 说明：
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
//
// 示例 1:
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3
//
// 进阶：
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
// Related Topics 树 二分查找


import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.Stack;

public class Solution_230 {
    public static void main(String[] args) {
        Solution_230 solution = new Solution_230();
        solution.mySolution_2(SolutionUtil.createTree(new Integer[] {
                5,
                3, 6,
                2, 4, null, null,
                1, null, null, null, null, null, null, null
        }), 5);
    }

    public int kthSmallest(TreeNode root, int k) {
        return 1;
    }

    public int mySolution_1(TreeNode root, int k) {
        recursive_1(root, k);
        return value;
    }

    public int mySolution_2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() >= 1) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return 0;
    }

    public int index = 0;
    public int value = 0;
    public void recursive_1(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        recursive_1(root.left, k);
        if (index == k) {
            return;
        }
        index ++;
        if (index == k) {
            value = root.val;
            return;
        }
        recursive_1(root.right, k);
    }
}

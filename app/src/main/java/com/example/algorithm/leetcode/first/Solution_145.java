package com.example.algorithm.leetcode.first;

//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树


import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_145 {
    public static void main(String[] args) {
        Solution_145 solution = new Solution_145();
        solution.mySolution_2(SolutionUtil.createTree(new Integer[]{
                1,
                null, 2,
                null, null, 3, null
        }));
    }

    public List<Integer> e(TreeNode root) {
        return null;
    }

    public List<Integer> mySolution_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive_1(root, result);
        return result;
    }

    public void recursive_1(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursive_1(root.left, result);
            recursive_1(root.right, result);
            result.add(root.val);
        }
    }


    public List<Integer> mySolution_2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastNode = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == lastNode) {
                stack.pop();
                result.add(root.val);
                lastNode = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return result;
    }

}

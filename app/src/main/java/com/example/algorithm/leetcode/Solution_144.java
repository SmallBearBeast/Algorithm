package com.example.algorithm.leetcode;

//给定一个二叉树，返回它的 前序 遍历。
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
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树

import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_144 {
    public static void main(String[] args) {
        Solution_144 solution = new Solution_144();
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }

    public List<Integer> mySolution_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive_1(root, result);
        return result;
    }

    public void recursive_1(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            recursive_1(root.left, result);
            recursive_1(root.right, result);
        }
    }

    public List<Integer> mySolution_2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

}

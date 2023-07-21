package com.example.algorithm.leetcode.first;
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
//
//
//
//
// Example 1:
//
//
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
//
//
// Example 2:
//
//
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
//
// Related Topics Tree Depth-first Search


import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class Solution_98 {
    public static void main(String[] args) {
        Solution_98 solution_3 = new Solution_98();
        TreeNode root = SolutionUtil.createTree(new Integer[]{
                5,
                1, 4,
                null, null, 3, 6
        });
        solution_3.mySolution_1(root);
    }

    public boolean isValidBST(TreeNode root) {
        return false;
    }

    // 自顶向下递归法
    public boolean recursive(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!recursive(node.left, lower, val)) {
            return false;
        }
        if (!recursive(node.right, val, upper)) {
            return false;
        }
        return true;
    }

    public boolean mySolution_1(TreeNode root) {
        return recursive(root, null, null);
    }

    private LinkedList<TreeNode> stack = new LinkedList();
    private LinkedList<Integer> uppers = new LinkedList();
    private LinkedList<Integer> lowers = new LinkedList();

    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    // 层序遍历法
    public boolean mySolution_2(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);
        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();
            if (root == null) {
                continue;
            }
            val = root.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

    // 中序遍历法，利用bst中序有序。
    public boolean mySolution_3(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}

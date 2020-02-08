package com.example.algorithm.leetcode;
//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
//return its zigzag level order traversal as:
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics Stack Tree Breadth-first Search

import com.example.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_103 {
    public static void main(String[] args) {
        Solution_103 solution = new Solution_103();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return null;
    }

    public List<List<Integer>> mySolution(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack_1 = new Stack<>();
        Stack<TreeNode> stack_2 = new Stack<>();
        stack_1.add(root);
        while (!stack_1.isEmpty()) {
            List<Integer> list_1 = new ArrayList<>();
            while (!stack_1.isEmpty()) {
                TreeNode node = stack_1.pop();
                list_1.add(node.val);
                if (node.left != null) {
                    stack_2.add(node.left);
                }
                if (node.right != null) {
                    stack_2.add(node.right);
                }
            }
            if (!list_1.isEmpty()) {
                result.add(list_1);
            }

            List<Integer> list_2 = new ArrayList<>();
            while (!stack_2.isEmpty()) {
                TreeNode node = stack_2.pop();
                list_2.add(node.val);
                if (node.right != null) {
                    stack_1.add(node.right);
                }
                if (node.left != null) {
                    stack_1.add(node.left);
                }
            }
            if (!list_2.isEmpty()) {
                result.add(list_2);
            }
        }
        return result;
    }
}

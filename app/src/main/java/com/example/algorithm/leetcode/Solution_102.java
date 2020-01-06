package com.example.algorithm.leetcode;
//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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
//return its level order traversal as:
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics Tree Breadth-first Search

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_102 {
    public static void main(String[] args) {
        Solution_102 solution = new Solution_102();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }

    public List<List<Integer>> mySolution_1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> mySolution_2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        recursive_2(root, 0);
        return result;
    }

    public void recursive_2(TreeNode root, int level) {
        if (level == result.size()) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            recursive_2(root.left, level + 1);
        }
        if (root.right != null) {
            recursive_2(root.right, level + 1);
        }
    }

    public List<List<Integer>> mySolution_3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        recursive_3(queue);
        return result;
    }

    public void recursive_3(LinkedList<TreeNode> queue) {
        if (queue.isEmpty()) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        int count = queue.size();
        for (int i = 0; i < count; i++) {
            TreeNode node = queue.removeFirst();
            list.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        result.add(list);
        recursive_3(queue);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

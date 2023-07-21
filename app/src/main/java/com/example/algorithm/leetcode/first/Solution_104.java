package com.example.algorithm.leetcode.first;
//Given a binary tree, find its maximum depth.
//
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given binary tree [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// return its depth = 3.
// Related Topics Tree Depth-first Search

import com.example.algorithm.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_104 {
    public static void main(String[] args) {
        Solution_104 solution = new Solution_104();
    }

    public int maxDepth(TreeNode root) {
        return 1;
    }

    public int mySolution_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(mySolution_1(root.left), mySolution_1(root.right));
    }

    public int mySolution_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result ++;
        }
        return result;
    }
}

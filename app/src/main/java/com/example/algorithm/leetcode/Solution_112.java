package com.example.algorithm.leetcode;
//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given the below binary tree and sum = 22,
//
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
//
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
// Related Topics Tree Depth-first Search

import java.util.LinkedList;
import java.util.Queue;

public class Solution_112 {
    public static void main(String[] args) {
        Solution_112 solution = new Solution_112();
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return false;
    }

    public boolean mySolution_1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return recursive_1(root, sum);
    }

    public boolean recursive_1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return recursive_1(root.left, sum - root.val) || recursive_1(root.right, sum - root.val);
    }

    public boolean mySolution_2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        treeQueue.add(root);
        sumQueue.add(sum);
        while (!treeQueue.isEmpty()) {
            TreeNode node = treeQueue.poll();
            int val = sumQueue.poll();
            if (node.left == null && node.right == null && node.val == val) {
                return true;
            }
            if (node.left != null) {
                treeQueue.add(node.left);
                sumQueue.add(val - node.left.val);
            }
            if (node.right != null) {
                treeQueue.add(node.right);
                sumQueue.add(val - node.right.val);
            }
        }
        return false;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode createTree(Integer[] nodes) {
        int index = 0;
        TreeNode root = new TreeNode(nodes[index]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (index < nodes.length - 1) {
            TreeNode node = queue.removeFirst();
            if (nodes[index + 1] != null) {
                TreeNode left = new TreeNode(nodes[index + 1]);
                node.left = left;
                queue.addLast(left);
            }
            if (nodes[index + 2] != null) {
                TreeNode right = new TreeNode(nodes[index + 2]);
                node.right = right;
                queue.addLast(right);
            }
            index = index + 2;
        }
        return root;
    }
}

package com.example.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Temp {
    public static void main(String[] args) {
        Solution_Temp solution = new Solution_Temp();
    }

    public int climbStairs(int n) {
        return 1;
    }

    public int mySolution(int n) {
        return 1;
    }

    public boolean isSameTree_1(TreeNode tree_1, TreeNode tree_2) {
        if (tree_1 == null && tree_2 == null) {
            return true;
        }
        if (tree_1 != null && tree_2 != null && tree_1.val == tree_2.val) {
            return isSameTree_1(tree_1.left, tree_2.left) && isSameTree_1(tree_1.right, tree_2.right);
        }
        return false;
    }

    public boolean isSameTree_2(TreeNode tree_1, TreeNode tree_2) {
        if (tree_1 == null && tree_2 == null) {
            return true;
        }
        if (tree_1 != null && tree_2 != null) {
            Queue<TreeNode> queue_1 = new LinkedList<>();
            Queue<TreeNode> queue_2 = new LinkedList<>();
            queue_1.add(tree_1);
            queue_2.add(tree_2);
            while (!queue_1.isEmpty() && !queue_2.isEmpty()) {
                TreeNode node_1 = queue_1.poll();
                TreeNode node_2 = queue_2.poll();
                if (node_1.left != null) {
                    queue_1.add(node_1.left);
                }
                if (node_1.right != null) {
                    queue_1.add(node_1.left);
                }
                if (node_2.left != null) {
                    queue_2.add(node_2.left);
                }
                if (node_2.right != null) {
                    queue_2.add(node_2.left);
                }
                if (node_1.val != node_2.val) {
                    return false;
                }
            }
            return queue_1.isEmpty() && queue_2.isEmpty();
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

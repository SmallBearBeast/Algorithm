package com.example.algorithm.leetcode.first;
//Given two binary trees, write a function to check if they are the same or not.
//
// Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
//
// Example 1:
//
//
//Input:     1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//Output: true
//
//
// Example 2:
//
//
//Input:     1         1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//Output: false
//
//
// Example 3:
//
//
//Input:     1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//Output: false
//
// Related Topics Tree Depth-first Search

import com.example.algorithm.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_100 {
    public static void main(String[] args) {
        Solution_100 solution = new Solution_100();
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return false;
    }

    public boolean mySolution_1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return mySolution_1(p.left, q.left) && mySolution_1(p.right, q.right);
        }
        return false;
    }

    public boolean mySolution_2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue_1 = new LinkedList<>();
        Queue<TreeNode> queue_2 = new LinkedList<>();
        queue_1.add(p);
        queue_2.add(q);
        while (!queue_1.isEmpty() && !queue_2.isEmpty()) {
            TreeNode node_1 = queue_1.poll();
            TreeNode node_2 = queue_2.poll();
            if (node_1 == null && node_2 == null) {
                continue;
            }
            if (node_1 != null && node_2 != null && node_1.val == node_2.val) {
                queue_1.add(node_1.left);
                queue_2.add(node_2.left);
                queue_1.add(node_1.right);
                queue_2.add(node_2.right);
                continue;
            }
            return false;
        }
        return true;
    }
}

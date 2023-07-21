package com.example.algorithm.leetcode.first;
//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// But the following [1,2,2,null,3,null,3] is not:
//
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// Note:
//Bonus points if you could solve it both recursively and iteratively.
// Related Topics Tree Depth-first Search Breadth-first Search

import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_101 {
    public static void main(String[] args) {
        Solution_101 solution = new Solution_101();
        TreeNode root = SolutionUtil.createTree(new Integer[]{
                1,
                2, 2,
                null, 2, null, 2
        });
        solution.mySolution_2(root);
    }

    public boolean isSymmetric(TreeNode root) {
        return true;
    }

    public boolean mySolution_1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public boolean equalTreeNode(TreeNode node_1, TreeNode node_2) {
        if (node_1 == node_2) {
            return true;
        }
        return node_1 != null && node_2 != null && node_1.val == node_2.val;
    }


    public boolean mySolution_2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recursive_2(root.left, root.right);
    }

    public boolean recursive_2(TreeNode node_1, TreeNode node_2) {
        if (node_1 == node_2) {
            return true;
        }
        if (node_1 != null && node_2 != null && node_1.val == node_2.val) {
            return recursive_2(node_1.left, node_2.right)
                    && recursive_2(node_1.right, node_2.left);
        }
        return false;
    }
}

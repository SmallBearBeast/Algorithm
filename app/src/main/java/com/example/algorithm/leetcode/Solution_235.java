package com.example.algorithm.leetcode;

import com.example.algorithm.structure.TreeNode;

public class Solution_235 {
    public static void main(String[] args) {
        Solution_235 solution = new Solution_235();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    // 递归
    public TreeNode mySolution_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return mySolution_1(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return mySolution_1(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode mySolution_2(TreeNode root, TreeNode p, TreeNode q) {
        // Value of p
        int pVal = p.val;
        // Value of q;
        int qVal = q.val;
        // Start from the root node of the tree
        TreeNode node = root;
        // Traverse the tree
        while (node != null) {
            // Value of ancestor/parent node.
            int parentVal = node.val;
            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }

}

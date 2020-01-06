package com.example.algorithm.leetcode;
//Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
//You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3]
//
// Return the following binary tree:
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics Array Tree Depth-first Search

import java.util.HashMap;
import java.util.Map;

public class Solution_106 {
    public static void main(String[] args) {
        Solution_106 solution = new Solution_106();
        solution.mySolution(new int[]{
                9, 3, 15, 20, 7
        }, new int[]{
                9, 15, 7, 20, 3
        });
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return null;
    }

    public TreeNode mySolution(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(postorder, 0, inorder.length - 1, inorder.length, map);
    }

    public TreeNode recursive(int[] postorder, int inStart, int postStart, int length, Map<Integer, Integer> map) {
        if (length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int tempIndex = map.get(postorder[postStart]);
        root.left = recursive(postorder, inStart, postStart - (length - (tempIndex - inStart)), tempIndex - inStart, map);
        root.right = recursive(postorder, tempIndex + 1, postStart - 1, length - (tempIndex - inStart + 1), map);
        return root;
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

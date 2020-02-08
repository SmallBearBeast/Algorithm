package com.example.algorithm.leetcode;
//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
//
// Example:
//
//
//Input: 3
//Output:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//Explanation:
//The above output corresponds to the 5 unique BST's shown below:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
// Related Topics Dynamic Programming Tree

import com.example.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_95 {
    public static void main(String[] args) {
        Solution_95 solution = new Solution_95();
        solution.mySolution(3);
    }

    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    public List<TreeNode> mySolution(int n) {
        recursive(1, n);
        return null;
    }

    public List<TreeNode> recursive(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = recursive(start, i - 1);
            List<TreeNode> rightList = recursive(i + 1, end);
            for(TreeNode left : leftList) {
                for(TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}

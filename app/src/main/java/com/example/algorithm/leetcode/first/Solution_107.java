package com.example.algorithm.leetcode.first;

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索


import com.example.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_107 {
    public static void main(String[] args) {
        Solution_107 solution = new Solution_107();
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return null;
    }

    public List<List<Integer>> mySolution_1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> tempResult = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            size = queue.size();
            tempResult.add(list);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = tempResult.size() - 1; i >= 0; i--) {
            result.add(tempResult.get(i));
        }
        return result;
    }

    public List<List<Integer>> mySolution_2(TreeNode root) {
        return null;
    }

}

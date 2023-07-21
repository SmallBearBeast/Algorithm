package com.example.algorithm.leetcode.first;
//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
// /  \    / \
//7    2  5   1
//
//
// Return:
//
//
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics Tree Depth-first Search

import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution_113 {
    public static void main(String[] args) {
        Solution_113 solution = new Solution_113();
        TreeNode tree = SolutionUtil.createTree(new Integer[] {
                1,
                1, 1,
                1, 1, 1, 1
        });
        solution.mySolution_3(tree, 3);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return null;
    }

    public List<List<Integer>> mySolution_1(TreeNode root, int sum) {
        return recursive_1(root, sum);
    }

    public List<List<Integer>> recursive_1(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null && root.val == sum) {
            List<List<Integer>> lists = new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            list.add(root.val);
            lists.add(list);
            return lists;
        }
        List<List<Integer>> sumPath = new LinkedList<>();
        List<List<Integer>> leftPath = recursive_1(root.left, sum - root.val);
        for(List<Integer> list: leftPath) {
            list.add(0, root.val);
            sumPath.add(list);
        }
        List<List<Integer>> rightPath = recursive_1(root.right, sum - root.val);
        for(List<Integer> list: rightPath) {
            list.add(0, root.val);
            sumPath.add(list);
        }
        return sumPath;
    }

    public List<List<Integer>> mySolution_2(TreeNode root, int sum) {
        recursive_2(root, sum);
        return lists;
    }

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public void recursive_2(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            list.add(root.val);
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        recursive_2(root.left, sum - root.val);
        recursive_2(root.right, sum - root.val);
        list.remove(list.size() - 1);
    }

    // 后序遍历法
    public List<List<Integer>> mySolution_3(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode last = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                temp.add(node.val);
                sum = sum - node.val;
                node = node.left;
            }
            node = stack.peek();
            if (node.right != null && node.right != last) {
                node = node.right;
            } else {
                node = stack.pop();
                if (node.left == null && node.right == null && sum == 0) {
                    result.add(new ArrayList<>(temp));
                }
                sum = sum + node.val;
                temp.remove(temp.size() - 1);
                last = node;
                node = null;
            }
        }
        return result;
    }

}

package com.example.algorithm.leetcode;

import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_129 {
    public static void main(String[] args) {
        Solution_129 solution = new Solution_129();
        solution.mySolution_2(SolutionUtil.createTree(new Integer[] {
                1, 2, 3
        }));
    }

    public int sumNumbers(TreeNode root) {
        return 1;
    }

    // 层序遍历法
    public int mySolution_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(root);
        sumQueue.add(root.val);
        int result = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int value = sumQueue.poll();
            if (node.left == null && node.right == null) {
                result = result + value;
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                sumQueue.add(value * 10 + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                sumQueue.add(value * 10 + node.right.val);
            }
        }
        return result;
    }

    public int result;
    public int mySolution_2(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int value) {
        if (root != null) {
            value = root.val + 10 * value;
            if (root.left == null && root.right == null) {
                result = result + value;
            } else {
                dfs(root.left, value);
                dfs(root.right, value);
            }
        }
    }

}

package com.example.algorithm.leetcode;

import com.example.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution_Temp {
    public static void main(String[] args) {
        Solution_Temp solution = new Solution_Temp();
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        list.addAll(list.size(), Arrays.asList(6, 7, 8));
        list.add(9);
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
}

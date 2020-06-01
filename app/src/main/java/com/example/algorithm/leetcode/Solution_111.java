package com.example.algorithm.leetcode;

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import com.example.algorithm.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_111 {
    public static void main(String[] args) {
        Solution_111 solution = new Solution_111();
    }

    public int minDepth(TreeNode root) {
        return 1;
    }

    public int mySolution_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return recursive_1(root);
    }

    public int recursive_1(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.min(recursive_1(root.left), recursive_1(root.right));
    }

    public int mySolution_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();
        int level = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            size = queue.size();
            level ++;
        }
        return 0;
    }
}

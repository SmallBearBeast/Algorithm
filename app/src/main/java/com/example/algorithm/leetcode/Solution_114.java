package com.example.algorithm.leetcode;
//Given a binary tree, flatten it to a linked list in-place.
//
// For example, given the following tree:
//
//
//    1
//   / \
//  2   5
// / \   \
//3   4   6
//
//
// The flattened tree should look like:
//
//
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
//
// Related Topics Tree Depth-first Search

import java.util.LinkedList;
import java.util.Stack;

public class Solution_114 {
    public static void main(String[] args) {
        Solution_114 solution = new Solution_114();
        TreeNode root = solution.createTree(new Integer[] {
                1,
                2, 5,
//                3, 4, null, 6
        });
        solution.mySolution_2(root);
    }

    public void flatten(TreeNode root) {

    }

    // 递归实现
    public void mySolution_1(TreeNode root) {
        recursive_1(root);
    }

    public TreeNode recursive_1(TreeNode root){
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode lastNode = null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            lastNode = recursive_1(left);
            lastNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (right != null) {
            lastNode = recursive_1(right);
        }
        return lastNode;
    }

    // 前序遍历实现
    public void mySolution_2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (pre != null) {
                pre.right = node;
                pre.left = null;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            pre = node;
        }
    }

    public void mySolution_3(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }


    private TreeNode pre = null;
    // 后续遍历递归实现（也不叫后序遍历吧）
    public void mySolution_4(TreeNode root) {
        if (root == null)
            return;
        mySolution_4(root.right);
        mySolution_4(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode createTree(Integer[] nodes) {
        int index = 0;
        TreeNode root = new TreeNode(nodes[index]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (index < nodes.length - 1) {
            TreeNode node = queue.removeFirst();
            if (nodes[index + 1] != null) {
                TreeNode left = new TreeNode(nodes[index + 1]);
                node.left = left;
                queue.addLast(left);
            } else {
                queue.addLast(null);
            }
            if (nodes[index + 2] != null) {
                TreeNode right = new TreeNode(nodes[index + 2]);
                node.right = right;
                queue.addLast(right);
            } else {
                queue.addLast(null);
            }
            index = index + 2;
        }
        return root;
    }
}

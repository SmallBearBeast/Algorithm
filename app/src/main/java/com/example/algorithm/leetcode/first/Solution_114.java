package com.example.algorithm.leetcode.first;
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

import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.Stack;

public class Solution_114 {
    public static void main(String[] args) {
        Solution_114 solution = new Solution_114();
        TreeNode root = SolutionUtil.createTree(new Integer[] {
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
    // 后续遍历递归实现（也叫后序遍历吧）
    public void mySolution_4(TreeNode root) {
        if (root == null)
            return;
        mySolution_4(root.right);
        mySolution_4(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}

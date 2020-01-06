package com.example.algorithm.leetcode;
//Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
//You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]
//
// Return the following binary tree:
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics Array Tree Depth-first Search

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Solution_105 {
    public static void main(String[] args) {
        Solution_105 solution = new Solution_105();
        solution.mySolution(new int[]{
                1, 2, 3
        }, new int[]{
                2, 3, 1
        });
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    // 递归写法
    public TreeNode mySolution(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(preorder, 0, 0, preorder.length, map);
    }

    public TreeNode recursive(int[] preorder, int preStart, int inStart, int length, Map<Integer, Integer> map) {
        if (length < 1) {
            return null;
        }
        int tempIndex = map.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = recursive(preorder, preStart + 1, inStart, tempIndex - inStart, map);
        root.right = recursive(preorder, preStart + tempIndex - inStart + 1, tempIndex + 1, length - (tempIndex - inStart + 1), map);
        return root;
    }

    // 非递归写法
    public TreeNode mySolution_2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> roots = new Stack<TreeNode>();
        int pre = 0;
        int in = 0;
        //先序遍历第一个值作为根节点
        TreeNode curRoot = new TreeNode(preorder[pre]);
        TreeNode root = curRoot;
        roots.push(curRoot);
        pre++;
        //遍历前序遍历的数组
        while (pre < preorder.length) {
            //出现了当前节点的值和中序遍历数组的值相等，寻找是谁的右子树
            if (curRoot.val == inorder[in]) {
                //每次进行出栈，实现倒着遍历
                while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                    curRoot = roots.peek();
                    roots.pop();
                    in++;
                }
                //设为当前的右孩子
                curRoot.right = new TreeNode(preorder[pre]);
                //更新 curRoot
                curRoot = curRoot.right;
                roots.push(curRoot);
                pre++;
            } else {
                //否则的话就一直作为左子树
                curRoot.left = new TreeNode(preorder[pre]);
                curRoot = curRoot.left;
                roots.push(curRoot);
                pre++;
            }
        }
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
            }
            if (nodes[index + 2] != null) {
                TreeNode right = new TreeNode(nodes[index + 2]);
                node.right = right;
                queue.addLast(right);
            }
            index = index + 2;
        }
        return root;
    }
}

package com.example.algorithm.offer;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//例如，给出
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//返回如下的二叉树：
//3
/// \
//9  20
///  \
//15   7
//限制：
//0 <= 节点个数 <= 5000

import com.example.algorithm.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_7 {
    public static void main(String[] args) {
        Solution_7 solution = new Solution_7();
        TreeNode root = solution.mySolution_2(new int[]{
                3, 9, 20, 15, 7
        }, new int[]{
                9, 3, 15, 20, 7
        });
        root = null;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    public TreeNode mySolution_1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return recursive_1(preorder, 0, 0, preorder.length, inOrderMap);
    }

    // 递归法，分之思想，主要寻找前序和中序对应序列的起始点。
    public TreeNode recursive_1(int[] preorder, int preStart, int inStart, int length, Map<Integer, Integer> inOrderMap) {
        if (length < 1) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(preorder[preStart]);
        }
        int index = inOrderMap.get(preorder[preStart]);
        TreeNode node = new TreeNode(preorder[preStart]);
        node.left = recursive_1(preorder, preStart + 1, inStart, index - inStart, inOrderMap);
        node.right = recursive_1(preorder, preStart + index - inStart + 1, index + 1, length - (index - inStart) - 1, inOrderMap);
        return node;
    }

    // 迭代法，利用栈。
    public TreeNode mySolution_2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}

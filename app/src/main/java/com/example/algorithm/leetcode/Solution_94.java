package com.example.algorithm.leetcode;
//Given a binary tree, return the inorder traversal of its nodes' values.
//
// Example:
//
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2]
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
// Related Topics Hash Table Stack Tree


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


public class Solution_94 {
    public static void main(String[] args) {
        Solution_94 solution = new Solution_94();
        TreeNode root = solution.createTree(new Integer[] {
                1,
                2, 3,
                4, 5, 6, 7,
                null, 9, null, null, null, null, null, null,
                null, null, 10, null, null, null, null, null, null, null, null, null, null, null, null, null
        });
        System.out.println(solution.preorderTraversal_1(root).toString());
        System.out.println(solution.preorderTraversal_2(root).toString());
        System.out.println(solution.inorderTraversal_1(root).toString());
        System.out.println(solution.inorderTraversal_2(root).toString());
        System.out.println(solution.postorderTraversal_1(root).toString());
        System.out.println(solution.postorderTraversal_2(root).toString());
    }

    public int climbStairs(int n) {
        return 1;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode node = root;
        while (!stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;

        }
        return result;
    }

    // https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
    // 颜色标记法-一种通用且简明的树遍历方法

    // https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
    // 莫里斯遍历

    // 前序遍历递归实现
    public List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderRecursive_1(result, root);
        return result;
    }

    public void preorderRecursive_1(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderRecursive_1(result, root.left);
        preorderRecursive_1(result, root.right);
    }

    // 前序遍历非递归实现
    public List<Integer> preorderTraversal_2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }

    // 中序遍历递归实现
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderRecursive_1(result, root);
        return result;
    }

    public void inorderRecursive_1(List<Integer> result, TreeNode root) {
        if (root != null) {
            inorderRecursive_1(result, root.left);
            result.add(root.val);
            inorderRecursive_1(result, root.right);
        }
    }

    // 中序遍历非递归实现
    public List<Integer> inorderTraversal_2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;

        }
        return result;
    }

    // 后序遍历递归实现
    public List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderRecursive_1(result, root);
        return result;
    }

    public void postorderRecursive_1(List<Integer> result, TreeNode root) {
        if (root != null) {
            postorderRecursive_1(result, root.left);
            postorderRecursive_1(result, root.right);
            result.add(root.val);
        }
    }

    // 后序遍历非递归实现
    public List<Integer> postorderTraversal_2(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode last = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right != null && node.right != last) {
                node = node.right;
            } else {
                node = stack.pop();
                result.add(node.val);
                last = node;
                node = null;
            }
        }
        return result;
    }

    // 层序遍历
    public List<Integer> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            result.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return result;
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

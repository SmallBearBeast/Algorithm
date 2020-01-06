package com.example.algorithm.leetcode;
//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
//
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
// Initially, all next pointers are set to NULL.
//
//
//
// Follow up:
//
//
// You may only use constant extra space.
// Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
//
//
//
// Example 1:
//
//
//
//
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
//
//
//
// Constraints:
//
//
// The number of nodes in the given tree is less than 4096.
// -1000 <= node.val <= 1000
//
// Related Topics Tree Depth-first Search

import java.util.LinkedList;
import java.util.Queue;

public class Solution_116 {
    public static void main(String[] args) {
        Solution_116 solution = new Solution_116();
    }

    public Node connect(Node root) {
        return null;
    }

    public Node mySolution_1(Node root) {
        if (root == null) {
            return null;
        }
        int levelCount = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = null;
            for (int i = 0; i < levelCount; i++) {
                if (node == null) {
                    node = queue.poll();
                } else {
                    node.next = queue.poll();
                    node = node.next;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelCount = levelCount * 2;
        }
        return root;
    }

    public Node mySolution_2(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start.left != null) {
            Node pre = start, cur = pre.next;
            while (pre != null) {
                pre.left.next = pre.right;
                if (cur != null) {
                    pre.right.next = cur.left;
                }
                // 下一趟
                pre = cur;
                if (cur != null) {
                    cur = cur.next;
                }
            }
            start = start.left;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}

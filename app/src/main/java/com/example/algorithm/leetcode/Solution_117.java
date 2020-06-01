package com.example.algorithm.leetcode;

//给定一个二叉树
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//
//
// 示例：
//
//
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
//
//
//
// 提示：
//
//
// 树中的节点数小于 6000
// -100 <= node.val <= 100
//
//
//
//
//
//
// Related Topics 树 深度优先搜索

import com.example.algorithm.structure.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_117 {
    public static void main(String[] args) {
        Solution_117 solution = new Solution_117();
    }

    public Node connect(Node root) {
        return null;
    }

    public Node mySolution_1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = queue.size();
        while (!queue.isEmpty()) {
            Node node = null;
            for (int i = 0; i < count; i++) {
                if (node == null) {
                    node = queue.poll();
                } else {
                    node.next = queue.poll();
                    node = node.next;
                }
                if (node != null && node.left != null) {
                    queue.add(node.left);
                }
                if (node != null && node.right != null) {
                    queue.add(node.right);
                }
            }
            count = queue.size();
        }
        return root;
    }

    public Node mySolution_2(Node root) {
        if (root == null) {
            return null;
        }
        Node head = root;
        while (head.left != null || head.right != null) {
            Node pre = head, next = pre.next;
            Node temp = pre.left;
            if (temp != null) {
                temp = pre.right;
            }
            while (pre != null) {
                if (pre.left != null && pre.left != temp) {
                    temp.next = pre.left;
                    temp = temp.next;
                } else if (pre.right != null && pre.right != temp) {
                    temp.next = pre.right;
                    temp = temp.next;
                }
                pre = next;
                if (pre != null) {
                    next = pre.next;
                }
            }
//            while (head.)
        }
        return null;
    }

}

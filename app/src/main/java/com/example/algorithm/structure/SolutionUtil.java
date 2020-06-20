package com.example.algorithm.structure;


import java.util.LinkedList;
import java.util.Queue;

public class SolutionUtil {
    public static TreeNode createTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        nodeQueue.add(root);
        indexQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int index = indexQueue.poll();
            if (2 * index + 1 < nodes.length && nodes[2 * index + 1] != null) {
                TreeNode left = new TreeNode(nodes[2 * index + 1]);
                node.left = left;
                nodeQueue.add(left);
                indexQueue.add(2 * index + 1);
            }
            if (2 * index + 2 < nodes.length && nodes[2 * index + 2] != null) {
                TreeNode right = new TreeNode(nodes[2 * index + 2]);
                node.right = right;
                nodeQueue.add(right);
                indexQueue.add(2 * index + 2);
            }
        }
        return root;
    }

    public static ListNode createLink(int[] datas) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 0; i < datas.length; i++) {
            temp.next = new ListNode(datas[i]);
            temp = temp.next;
        }
        return head.next;
    }
}

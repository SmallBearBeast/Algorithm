package com.example.algorithm.structure;


import java.util.LinkedList;

public class SolutionUtil {
    public static TreeNode createTree(Integer[] nodes) {
        int index = 0;
        TreeNode root = new TreeNode(nodes[index]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (index < nodes.length - 1 && !queue.isEmpty()) {
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

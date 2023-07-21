package com.example.algorithm.leetcode.first;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 深度优先搜索 链表

public class Solution_109 {
    public static void main(String[] args) {
        Solution_109 solution = new Solution_109();
        ListNode listNode = SolutionUtil.createLink(new int[] {
                -10, -3, 0, 5, 9
        });
        TreeNode root = solution.mySolution_1(listNode);
        root = null;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }

    // 递归法
    public TreeNode mySolution_1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count ++;
            temp = temp.next;
        }

        int[] values = new int[count];
        temp = head;
        int i = 0;
        while (temp != null) {
            values[i] = temp.val;
            temp = temp.next;
            i ++;
        }
        return createBST(values, 0, count - 1);
    }

    public TreeNode mySolution_2(ListNode head) {
        return null;
    }


    public TreeNode createBST(int[] values, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(values[start]);
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(values[mid]);
        node.left = createBST(values, start, mid - 1);
        node.right = createBST(values, mid + 1, end);
        return node;
    }
}

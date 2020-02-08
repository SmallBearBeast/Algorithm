package com.example.algorithm.leetcode;
//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
// Example 1:
//
//
//Input: 1->2->3->3->4->4->5
//Output: 1->2->5
//
//
// Example 2:
//
//
//Input: 1->1->1->2->3
//Output: 2->3
//
// Related Topics Linked List

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

public class Solution_82 {
    public static void main(String[] args) {
        Solution_82 solution = new Solution_82();
        ListNode link = SolutionUtil.createLink(new int[]{
                1, 2, 3, 3, 4, 4, 5
        });
        solution.mySolution(link);
    }

    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    public ListNode mySolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        while (head != null) {
            boolean done = false;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                done = true;
            }
            if (!done) {
                pre.next = new ListNode(head.val);
                pre = pre.next;
            }
            head = head.next;
        }
        return res.next;
    }
}

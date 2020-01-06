package com.example.algorithm.leetcode;
//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// Example 1:
//
//
//Input: 1->1->2
//Output: 1->2
//
//
// Example 2:
//
//
//Input: 1->1->2->3->3
//Output: 1->2->3
//
// Related Topics Linked List

public class Solution_83 {
    public static void main(String[] args) {
        Solution_83 solution = new Solution_83();
    }

    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    public ListNode mySolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head;
        ListNode pre = head;
        head = head.next;
        while (head != null) {
            if (pre.val == head.val) {
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

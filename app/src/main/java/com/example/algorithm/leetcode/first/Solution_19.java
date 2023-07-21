package com.example.algorithm.leetcode.first;
//Given a linked list, remove the n-th node from the end of list and return its head.
//
// Example:
//
//
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->5.
//
//
// Note:
//
// Given n will always be valid.
//
// Follow up:
//
// Could you do this in one pass?
// Related Topics Linked List Two Pointers

import com.example.algorithm.structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Solution_19 {
    public static void main(String[] args) {
        Solution_19 solution = new Solution_19();
//        solution.mySolution("23");
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    public ListNode mySolution(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (n >= 0 && first != null) {
            first = first.next;
            n --;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

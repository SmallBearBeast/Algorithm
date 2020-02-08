package com.example.algorithm.leetcode;
//Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//
//
// Example:
//
//
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
// Related Topics Linked List

import com.example.algorithm.structure.ListNode;

public class Solution_24 {
    public static void main(String[] args) {
        Solution_24 solution = new Solution_24();
//        solution.mySolution("23");
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode mySolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = head;
        ListNode end = head.next;
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        while (start != null && end != null) {
            start.next = end.next;
            end.next = start;
            pre.next = end;
            pre = start;
            start = start.next;
            end = start == null ? null : start.next;
        }
        return head.next;
    }
}

package com.example.algorithm.leetcode;
//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Example:
//
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
//
// Related Topics Linked List Math

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Solution_2 {
    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int step = 0;
        int val = 0;
        while (l1 != null || l2 != null) {
            val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + step;
            temp.next = new ListNode(val % 10);
            step = val / 10;
            temp = temp.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (step > 0) {
            temp.next = new ListNode(1);
        }
        return result.next;
    }

    public ListNode mySolution(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int step = 0;
        while (l1 != null && l2 != null) {
            temp.next = new ListNode((l1.val + l2.val + step) % 10);
            step = (l1.val + l2.val + step) / 10;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            temp.next = new ListNode((l1.val + step) % 10);
            step = (l1.val + step) / 10;
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = new ListNode((l2.val + step) % 10);
            step = (l2.val + step) / 10;
            l2 = l2.next;
            temp = temp.next;
        }
        if (step > 0) {
            temp.next = new ListNode(1);
        }
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

package com.example.algorithm.leetcode;

//Reverse a singly linked list.
//
// Example:
//
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
//
//
// Follow up:
//
// A linked list can be reversed either iteratively or recursively. Could you implement both?
// Related Topics Linked List

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

public class Solution_206 {
    public static void main(String[] args) {
        Solution_206 solution = new Solution_206();
        ListNode list = SolutionUtil.createLink(new int[] {
                1, 2, 3, 4, 5
        });
        solution.mySolution_1(list);
    }

    public ListNode reverseList(ListNode head) {
        return null;
    }

    public ListNode mySolution_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        while (head != null) {
            ListNode next  = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        return pre.next;
    }

    public ListNode mySolution_2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode mySolution_3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = mySolution_3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

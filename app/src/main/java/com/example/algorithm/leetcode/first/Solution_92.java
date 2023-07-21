package com.example.algorithm.leetcode.first;
//Reverse a linked list from position m to n. Do it in one-pass.
//
// Note: 1 ≤ m ≤ n ≤ length of list.
//
// Example:
//
//
//Input: 1->2->3->4->5->NULL, m = 2, n = 4
//Output: 1->4->3->2->5->NULL
//
// Related Topics Linked List


import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

public class Solution_92 {
    public static void main(String[] args) {
        Solution_92 solution = new Solution_92();
        ListNode list = SolutionUtil.createLink(new int[] {
                1, 2, 3, 4, 5
        });
        solution.mySolution_1(list, 2, 3);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        return null;
    }

    public ListNode mySolution_1(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode res = pre;
        while (m > 1) {
            pre = head;
            head = head.next;
            m --;
            n --;
        }

        ListNode reverseStart = new ListNode(0);
        ListNode reverseEnd = head;
        while (n > 0) {
            ListNode next = head.next;
            head.next = reverseStart.next;
            reverseStart.next = head;
            head = next;
            n --;
        }
        pre.next = reverseStart.next;
        reverseEnd.next = head;
        return res.next;
    }

    public ListNode mySolution_2(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}

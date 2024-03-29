package com.example.algorithm.leetcode.first;

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


    // 双指针反转法。
    public ListNode mySolution_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 递归法
    public ListNode mySolution_2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = mySolution_2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

package com.example.algorithm.leetcode.second;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

public class Solution_206 {
    public static void main(String[] args) {
        Solution_206 solution_206 = new Solution_206();
        ListNode result = solution_206.mySolution_1(SolutionUtil.createLink(new int[]{
                1, 2, 3, 4, 5
        }));
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

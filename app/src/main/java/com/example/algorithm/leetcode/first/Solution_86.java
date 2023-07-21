package com.example.algorithm.leetcode.first;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

public class Solution_86 {
    public static void main(String[] args) {
        Solution_86 solution = new Solution_86();
        solution.mySolution_2(SolutionUtil.createLink(new int[]{
                1, 4, 3, 2, 5, 2
        }), 3);
    }

    public ListNode partition(ListNode head, int x) {
        return null;
    }

    public ListNode mySolution_1(ListNode head, int x) {
        ListNode temp = head;
        ListNode end = null, start = null;
        while (temp != null) {
            ListNode node = temp.next;
            if (temp.val >= x) {
                end = temp;
            } else {
                if (start == null) {
                    if (end != null) {
                        end.next = temp.next;
                        temp.next = head;
                        head = temp;
                    }
                } else if (end != null) {
                    end.next = temp.next;
                    temp.next = start.next;
                    start.next = temp;
                }
                start = temp;
            }
            temp = node;
        }
        return head;
    }

    // 双指针哑结点尾插法
    public ListNode mySolution_2(ListNode head, int x) {
        ListNode temp = head;
        ListNode end = new ListNode(0);
        ListNode start = new ListNode(0);
        start.next = end;
        ListNode res = start;
        while (temp != null) {
            ListNode node = temp.next;
            if (temp.val >= x) {
                end.next = temp;
                temp.next = null;
                end = temp;
            } else {
                temp.next = start.next;
                start.next = temp;
                start = temp;
            }
            temp = node;
        }
        start.next = start.next.next;
        return res.next;
    }

}

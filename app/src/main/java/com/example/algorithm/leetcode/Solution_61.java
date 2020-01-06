package com.example.algorithm.leetcode;
//Given a linked list, rotate the list to the right by k places, where k is non-negative.
//
// Example 1:
//
//
//Input: 1->2->3->4->5->NULL, k = 2
//Output: 4->5->1->2->3->NULL
//Explanation:
//rotate 1 steps to the right: 5->1->2->3->4->NULL
//rotate 2 steps to the right: 4->5->1->2->3->NULL
//
//
// Example 2:
//
//
//Input: 0->1->2->NULL, k = 4
//Output: 2->0->1->NULL
//Explanation:
//rotate 1 steps to the right: 2->0->1->NULL
//rotate 2 steps to the right: 1->2->0->NULL熊
//rotate 3 steps to the right: 0->1->2->NULL
//rotate 4 steps to the right: 2->0->1->NULL
// Related Topics Linked List Two Pointers

public class Solution_61 {
    public static void main(String[] args) {
        Solution_61 solution = new Solution_61();
        ListNode link = solution.createLink(new int[]{
                1,
        });
        solution.mySolution(link, 2 + 5 + 5);
    }

    public ListNode rotateRight(ListNode head, int k) {
        return null;
    }

    public ListNode mySolution(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int count = 0;
        ListNode end = null;
        while (temp != null) {
            end = temp;
            temp = temp.next;
            count ++;
        }
        k = k % count;
        end.next = head;
        for (int i = 0; i < count - k; i++) {
            end = end.next;
        }
        ListNode res = end.next;
        end.next = null;
        return res;
    }

    public ListNode createLink(int[] datas) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 0; i < datas.length; i++) {
            temp.next = new ListNode(datas[i]);
            temp = temp.next;
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

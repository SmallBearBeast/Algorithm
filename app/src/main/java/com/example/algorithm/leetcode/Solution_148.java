package com.example.algorithm.leetcode;
//Sort a linked list in O(n log n) time using constant space complexity.
//
// Example 1:
//
//
//Input: 4->2->1->3
//Output: 1->2->3->4
//
//
// Example 2:
//
//
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5
// Related Topics Linked List Sort

public class Solution_148 {
    public static void main(String[] args) {
        Solution_148 solution = new Solution_148();
        ListNode head = solution.createLink(new int[] {
                -1, 5, 3, 4, 0
        });
        solution.mySolution_1(head);
        String s = null;
    }

    public ListNode sortList(ListNode head) {
        return null;
    }

    public ListNode mySolution_1(ListNode head) {
        return mergeSort(head, linkNum(head));
    }

    public int linkNum(ListNode head) {
        int num = 0;
        while (head != null) {
            head = head.next;
            num ++;
        }
        return num;
    }

    public ListNode mergeSort(ListNode head, int num) {
        if (num == 1) {
            head.next = null;
            return head;
        }
        int half = num / 2;
        ListNode start = head;
        for (int i = 1; i < half; i++) {
            head = head.next;
        }
        ListNode end = head.next;
        head.next = null;
        head = end;
        for (int i = half + 1; i < num; i++) {
            head = head.next;
        }
        head.next = null;
        return mergeLink(mergeSort(start, half), mergeSort(end, num - half));
    }

    public ListNode mergeLink(ListNode start, ListNode end) {
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        pre.next = start;
        while (start != null && end != null) {
            if (start.val > end.val) {
                start = end;
                end = end.next;
                start.next = pre.next;
                pre.next = start;
            }
            pre = start;
            start = start.next;
        }
        if (start == null) {
            pre.next = end;
        }
        return head.next;
    }

    public ListNode mySolution_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
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

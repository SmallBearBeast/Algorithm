package com.example.algorithm.leetcode;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学

import com.example.algorithm.structure.ListNode;

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

    public ListNode mySolution_1(ListNode l1, ListNode l2) {
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
}

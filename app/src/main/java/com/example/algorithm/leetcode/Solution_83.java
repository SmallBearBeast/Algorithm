package com.example.algorithm.leetcode;

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表

import com.example.algorithm.structure.ListNode;

public class Solution_83 {
    public static void main(String[] args) {
        Solution_83 solution = new Solution_83();
    }

    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    public ListNode mySolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head;
        ListNode pre = head;
        head = head.next;
        while (head != null) {
            if (pre.val == head.val) {
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return res;
    }
}

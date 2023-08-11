package com.example.algorithm.leetcode.second;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

public class Solution_92 {
    public static void main(String[] args) {
        Solution_92 solution_92 = new Solution_92();
        ListNode node = solution_92.mySolution_2(SolutionUtil.createLink(new int[] {
                1, 2, 3, 4, 5
        }), 1, 5);
        System.out.println(SolutionUtil.toListNodeStr(node));
    }

    // 头结点（保证有值，省略掉判空）+普通反转链表法。
    public ListNode mySolution_1(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode reverseHead = dummyNode;
        for (int i = 1; i < left; i++) {
            reverseHead = head;
            head = head.next;
        }
        ListNode prev = null;
        ListNode next = null;
        while (left <= right) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            left ++;
        }
        if (reverseHead.next != null) {
            reverseHead.next.next = head;
        }
        reverseHead.next = prev;
        return dummyNode.next;
    }

    // 头插法
    public ListNode mySolution_2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode reverseHead = dummyNode;
        for (int i = 1; i < left; i++) {
            reverseHead = reverseHead.next;
        }
        head = reverseHead.next;
        ListNode next = null;
        while (left < right) {
            next = head.next;
            head.next = next.next;
            next.next = reverseHead.next;
            reverseHead.next = next;
            left ++;
        }
        return dummyNode.next;
    }

    // 递归法
    // TODO: 2023/8/11  
}

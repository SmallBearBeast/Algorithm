package com.example.algorithm.leetcode;

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 示例 :
//
// 给定这个链表：1->2->3->4->5
//
// 当 k = 2 时，应当返回: 2->1->4->3->5
//
// 当 k = 3 时，应当返回: 3->2->1->4->5
//
// 说明 :
//
//
// 你的算法只能使用常数的额外空间。
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// Related Topics 链表

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

import java.util.LinkedList;
import java.util.Stack;

public class Solution_25 {
    public static void main(String[] args) {
        Solution_25 solution = new Solution_25();
        solution.mySolution_2(SolutionUtil.createLink(new int[] {
                1, 2, 3, 4, 5
        }), 5);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }

    // 多指针遍历法
    public ListNode mySolution_1(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode node = new ListNode(0);
        ListNode first = node;
        ListNode second = node;
        ListNode nextFirst = null;
        ListNode nextSecond = null;
        node.next = head;
        while (second != null) {
            for (int i = 0; i < k && second != null; i++) {
                second = second.next;
            }
            if (second != null) {
                nextFirst = first.next;
                nextSecond = second.next;
                reverse(nextFirst, second);
                first.next = second;
                nextFirst.next = nextSecond;
                first = nextFirst;
                second = first;
            }
        }
        return node.next;
    }

    public void reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode next = null;
        while (pre != end) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
    }

    // 栈
    public ListNode mySolution_2(ListNode head, int k) {
        ListNode root = new ListNode(0);
        ListNode temp = root;
        root.next = head;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            for (int i = 0; i < k && head != null; i++) {
                stack.push(head);
                head = head.next;
            }
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    ListNode node = stack.pop();
                    temp.next = node;
                    temp = node;
                }
                temp.next = head;
            }
        }
        return root.next;
    }


    // 两两交换k，不是翻转。
    public ListNode mySolution_3(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode node = new ListNode(0);
        ListNode first = node;
        ListNode second = node;
        ListNode nextFirst = null;
        ListNode nextSecond = null;
        ListNode temp = null;
        node.next = head;
        k --;
        while (second != null) {
            for (int i = 0; i < k && second != null; i++) {
                second = second.next;
            }
            if (second != null && second.next != null) {
                nextFirst = first.next;
                nextSecond = second.next;
                second.next = nextFirst;
                first.next = nextSecond;
                temp = nextSecond.next;
                nextSecond.next = nextFirst.next;
                nextFirst.next = temp;
                first = nextFirst;
                second = first;
            }
        }
        return node.next;
    }

}

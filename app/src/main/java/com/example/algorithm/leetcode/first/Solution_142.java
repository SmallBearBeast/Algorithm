package com.example.algorithm.leetcode.first;
//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
// To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
//
// Note: Do not modify the linked list.
//
//
//
// Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the second node.
//
//
//
//
// Example 2:
//
//
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the first node.
//
//
//
//
// Example 3:
//
//
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
//
//
//
//
//
//
// Follow-up:
//Can you solve it without using extra space?
// Related Topics Linked List Two Pointers

import com.example.algorithm.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution_142 {
    public static void main(String[] args) {
        Solution_142 solution = new Solution_142();

        ListNode head = solution.createCircleLink(new int[] {
                3, 2, 0, -4
        }, 1);

        solution.mySolution_2(head);
    }

    public ListNode createCircleLink(int[] datas, int index) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode cycleNode = null;
        for (int i = 0; i < datas.length; i++) {
            temp.next = new ListNode(datas[i]);
            temp = temp.next;
            if (i == index) {
                cycleNode = temp;
            }
        }
        temp.next = cycleNode;
        return head.next;
    }

    public ListNode detectCycle(ListNode head) {
        return null;
    }

    // 快慢指针法
    public ListNode mySolution_1(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (second != null) {
            second = second.next != null ? second.next.next : null;
            first = first.next;
            if (first == second) {
                break;
            }
        }
        if (second == null) {
            return null;
        }
        ListNode third = head;
        while (third != second) {
            third = third.next;
            second = second.next;
        }
        return third;
    }

    public ListNode mySolution_2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            ListNode next = head.next;
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = next;
        }
        return null;
    }
}

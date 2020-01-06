package com.example.algorithm.leetcode;
//Given a linked list, determine if it has a cycle in it.
//
// To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
//
//
//
//
// Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the second node.
//
//
//
//
//
//
// Example 2:
//
//
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the first node.
//
//
//
//
//
//
// Example 3:
//
//
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
//
//
//
//
//
//
//
// Follow up:
//
// Can you solve it using O(1) (i.e. constant) memory?
// Related Topics Linked List Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class Solution_141 {
    public static void main(String[] args) {
        Solution_141 solution_3 = new Solution_141();
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean mySolution(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
            if (first == second) {
                return true;
            }
            first = first.next;
            second = second.next != null ? second.next.next : null;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

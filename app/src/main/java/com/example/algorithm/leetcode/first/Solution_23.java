package com.example.algorithm.leetcode.first;
//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
// Example:
//
//
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
//
// Related Topics Linked List Divide and Conquer Heap

import com.example.algorithm.structure.ListNode;

public class Solution_23 {
    public static void main(String[] args) {
        Solution_23 solution_3 = new Solution_23();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    public ListNode mySolution_1(ListNode[] lists) {
        ListNode head = null;
        for (int i = 0; i < lists.length; i++) {
            head = mergeTwo_1(head, lists[i]);
        }
        return head;
    }

    public ListNode mySolution_2(ListNode[] lists) {
        for (int i = 1; i < lists.length; i++) {
            mergeTwo_2(lists[0], lists[i]);
        }
        return lists[0];
    }

    // 用优先队列优化逐一比较法
    public ListNode mySolutionn_3(ListNode[] lists) {
        return null;
    }

    // 数组排序法
    public ListNode mySolutionn_4(ListNode[] lists) {
        return null;
    }

    // 分治
    public ListNode mySolutionn_5(ListNode[] lists) {
        if (lists == null | lists.length == 0) {
            return null;
        }
        int length = lists.length;
        int interval = 1;
        while (interval < length) {
            for (int i = 0; i + interval < length; i = i + interval * 2) {
                lists[i] = mergeTwo_1(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }
        return lists[0];
    }



    public ListNode mergeTwo_1(ListNode node_1, ListNode node_2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (node_1 != null || node_2 != null) {
            if (node_1 == null) {
                p.next = node_2;
                return head.next;
            }
            if (node_2 == null) {
                p.next = node_1;
                return head.next;
            }
            if (node_1.val < node_2.val) {
                p.next = new ListNode(node_1.val);
                node_1 = node_1.next;
            } else if (node_1.val > node_2.val) {
                p.next = new ListNode(node_2.val);
                node_2 = node_2.next;
            } else {
                p.next = new ListNode(node_1.val);
                p = p.next;
                p.next = new ListNode(node_2.val);
                node_1 = node_1.next;
                node_2 = node_2.next;
            }
            p = p.next;
        }
        return head.next;
    }

    public void mergeTwo_2(ListNode head, ListNode merge) {
        ListNode node = null;
        while (head != null && merge != null) {
            if (head.val <= merge.val) {
                node = head;
                head = head.next;
            }  else {
                node = merge;
                merge = merge.next;
                node.next = head.next;
                head.next = node;
                head = head.next.next;
            }
        }
        if (head == null && node != null) {
            node.next = merge;
        }
    }
}

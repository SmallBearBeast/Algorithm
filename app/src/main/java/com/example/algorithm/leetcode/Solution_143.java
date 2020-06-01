package com.example.algorithm.leetcode;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

import java.util.ArrayList;
import java.util.List;

public class Solution_143 {
    public static void main(String[] args) {
        Solution_143 solution = new Solution_143();
        ListNode head = SolutionUtil.createLink(new int[]{
                1, 2, 3, 4
        });
        solution.mySolution_2(head);
    }

    public void reorderList(ListNode head) {

    }

    public void mySolution_1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 快慢指针
        ListNode first = head;
        ListNode second = head;
        while (second.next != null && second.next.next != null) {
            second = second.next.next;
            first = first.next;
        }
        if (second.next != null) {
            second = second.next;
        }

        // 链表反转
        ListNode next = first.next;
        first.next = null;
        ListNode temp = null;
        while (next != null) {
            temp = next.next;
            next.next = first;
            first = next;
            next = temp;
        }

        // 双指针操作
        first = head;
        ListNode firstTemp = null;
        ListNode secondTemp = null;
        while (first != second && first != null && second != null) {
            firstTemp = first.next;
            secondTemp = second.next;
            first.next = second;
            second.next = firstTemp;
            second = secondTemp;
            first = firstTemp;
        }

    }

    // List存储法
    public void mySolution_2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int end = list.size() - 1;
        int start = 0;
        while (start < end) {
            list.get(start).next = list.get(end);
            start ++;
            if (start < end) {
                list.get(end).next = list.get(start);
            }
            end --;
        }
        list.get(start).next = null;
    }

    // 递归法
    public void mySolution_3(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count ++;
            temp = temp.next;
        }
        recursive_3(head, count);
    }

    public ListNode recursive_3(ListNode head, int count) {
        if (count == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (count == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        ListNode tail = recursive_3(head.next, count - 2);
        ListNode subHead = head.next;
        head.next = tail;
        ListNode outTail = tail.next;
        tail.next = subHead;
        return outTail;
    }
}

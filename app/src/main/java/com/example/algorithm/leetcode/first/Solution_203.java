package com.example.algorithm.leetcode.first;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表

public class Solution_203 {
    public static void main(String[] args) {
        Solution_203 solution = new Solution_203();
        solution.mySolution_1(SolutionUtil.createLink(new int[] {
                1, 2, 6, 3, 4, 5, 6
        }), 6);
    }

    public ListNode removeElements(ListNode head, int val) {
        return null;
    }

    public ListNode mySolution_1(ListNode head, int val) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode second = head;
        head = first;
        while (second != null) {
            if (second.val == val) {
                first.next = second.next;
            } else {
                first = second;
            }
            second = second.next;
        }
        return head.next;
    }

    public ListNode mySolution_2(ListNode head, int val) {
        return null;
    }

}

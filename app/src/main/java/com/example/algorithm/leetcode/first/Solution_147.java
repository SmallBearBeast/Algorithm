package com.example.algorithm.leetcode.first;

//对链表进行插入排序。
//
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//
//
// 插入排序算法：
//
//
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
// 重复直到所有输入数据插入完为止。
//
//
//
//
// 示例 1：
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
//
//
// 示例 2：
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
//
// Related Topics 排序 链表

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

public class Solution_147 {
    public static void main(String[] args) {
        Solution_147 solution = new Solution_147();
        solution.mySolution_1(SolutionUtil.createLink(new int[] {
               4, 2, 1, 3
        }));
    }

    public ListNode insertionSortList(ListNode head) {
        return null;
    }

    public ListNode mySolution_1(ListNode head) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode insert = head;
            head = head.next;
            insert.next = null;
            ListNode temp = result;
            while (temp.next != null && temp.next.val < insert.val) {
                temp = temp.next;
            }
            if (temp.next != null) {
                insert.next = temp.next;
            }
            temp.next = insert;
        }
        return result.next;
    }

    public ListNode mySolution_2(ListNode head) {
        ListNode lastTemp = null;
        ListNode result = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode insert = head;
            head = head.next;
            insert.next = null;
            ListNode temp = (lastTemp != null && lastTemp.val <= insert.val) ? lastTemp : result;
            while (temp.next != null && temp.next.val < insert.val) {
                temp = temp.next;
            }
            lastTemp = temp;
            if (temp.next != null) {
                insert.next = temp.next;
            }
            temp.next = insert;
        }
        return result.next;
    }

}

package com.example.algorithm.leetcode.first;

//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

public class Solution_234 {
    public static void main(String[] args) {
        Solution_234 solution = new Solution_234();
        solution.mySolution_1(SolutionUtil.createLink(new int[] {
                1, 2, 3, 2, 1
        }));
    }

    public boolean isPalindrome(ListNode head) {
        return false;
    }

    // 快慢指针找中点，反转后半段链表不使用额外空间
    public boolean mySolution_1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode first = head;
        ListNode second = head;
        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }
        second = reverse(first.next);
        first.next = null;
        first = head;
        while (second != null && first != null) {
            if (second.val != first.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private ListNode reverse(ListNode first) {
        ListNode third = null;
        ListNode second = null;
        while (first != null) {
            second = first.next;
            first.next = third;
            third = first;
            first = second;
        }
        return third;
    }

    public boolean mySolution_2(ListNode head) {
        return false;
    }
}

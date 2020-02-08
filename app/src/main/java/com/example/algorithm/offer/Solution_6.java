package com.example.algorithm.offer;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//示例 1：
//输入：head = [1,3,2]
//输出：[2,3,1]
//限制：
//0 <= 链表长度 <= 10000

import com.example.algorithm.structure.ListNode;

import java.util.Stack;

public class Solution_6 {
    public static void main(String[] args) {
        Solution_6 solution = new Solution_6();
    }

    public int[] reversePrint(ListNode head) {
        return null;
    }

    public int[] mySolution_1(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count ++;
        }
        int[] res = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; i--) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }

    // 栈
    public int[] mySolution_2(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}

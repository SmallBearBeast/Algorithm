package com.example.algorithm;

import com.example.algorithm.structure.ListNode;
import com.example.algorithm.structure.SolutionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Nathan.wei@ringcentral.com 
public class RingCentral {
    public static void main(String[] args) {
        RingCentral ringCentral = new RingCentral();
//        ringCentral.print(new int[] {
//
//        });

        // 123
        ListNode listNodeA = SolutionUtil.createLink(new int[] {
              3, 2, 1
        });
        // 678
        ListNode listNodeB = SolutionUtil.createLink(new int[] {
                8, 7, 6
        });
        ListNode node = ringCentral.getSum(listNodeA, listNodeB);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public void print(int[] datas) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < datas.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tempList = new ArrayList<>(result.get(j));
                tempList.add(datas[i]);
                result.add(tempList);
            }
        }
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }



    public ListNode getSum(ListNode listNodeA, ListNode listNodeB) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int step = 0;
        while (listNodeA != null && listNodeB != null) {
            int val = step + listNodeA.val + listNodeB.val;
            step = val / 10;
            head.next = new ListNode(val % 10);
            head = head.next;
            listNodeA = listNodeA.next;
            listNodeB = listNodeB.next;
        }

        if (listNodeA == null) {
            while (listNodeB != null) {
                head.next = new ListNode((listNodeB.val + step) % 10);
                step = (listNodeB.val + step) / 10;
                listNodeB = listNodeB.next;
            }
        }
        while (listNodeA != null) {
            head.next = new ListNode((listNodeA.val + step) % 10);
            step = (listNodeA.val + step) / 10;
            listNodeA = listNodeA.next;
        }

        if (step == 1) {
            head.next = new ListNode(1);
        }
        return result.next;
    }

}

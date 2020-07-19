package com.example.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Other {
    public static void main(String[] args) {
        Other other = new Other();
//        int[] result = new int[] {
//                14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 15
//        };
//        other.quickSort(result, 0, result.length - 1);
//        System.out.println("result = " + Arrays.toString(result));
//
//        Stack<Integer> stack = new Stack<>();
//        stack.push(100);
//        stack.push(200);
//        stack.push(300);
//        System.out.println("stack.size = " + stack.size());
//
//        // 后面遍历可以remove，不会出现数组越界问题。
//        int size = stack.size();
//        for (int i = size - 1; i >= 0; i--) {
//            int val = stack.get(i);
//            stack.pop();
//            size --;
//            System.out.println("val = " + val);
//        }
//        System.out.println("stack.size = " + stack.size());

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(10);
        heap.add(5);
        heap.add(8);
        heap.add(15);
        heap.add(3);
        System.out.println("heap.poll = " + heap.poll());
    }


    public void quickSort(int[] datas, int start, int end) {
        if (start >= end) {
            return;
        }
        int tempStart = start;
        int tempEnd = end;
        while (tempStart < tempEnd) {
            int temp = tempStart;
            while (tempEnd > temp && datas[temp] <= datas[tempEnd]) {
                tempEnd --;
            }
            swap(datas, temp, tempEnd);
            temp = tempEnd;
            while (tempStart < temp && datas[tempStart] <= datas[temp]) {
                tempStart ++;
            }
            swap(datas, temp, tempStart);
        }
        quickSort(datas, start, tempStart - 1);
        quickSort(datas, tempEnd + 1, end);
    }

    public void swap(int[] datas, int index_1, int index_2) {
        int temp = datas[index_1];
        datas[index_1] = datas[index_2];
        datas[index_2] = temp;
    }

}

package com.example.algorithm.leetcode.first;
//Given a collection of intervals, merge all overlapping intervals.
//
// Example 1:
//
//
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
// Related Topics Array Sort

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution_56 {
    public static void main(String[] args) {
        Solution_56 solution = new Solution_56();
        int[][] intervals = new int[][]{
                {1, 4}, {0, 4}
        };
        solution.mySolution(intervals);
    }

    public int[][] merge(int[][] intervals) {
        return null;
    }

    public int[][] mySolution(int[][] intervals) {
        Node[] nodes = new Node[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            nodes[i] = new Node();
            nodes[i].x = intervals[i][0];
            nodes[i].y = intervals[i][1];
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < nodes.length; i++) {
            if (stack.isEmpty()) {
                stack.push(nodes[i]);
                continue;
            }
            Node node = stack.peek();
            if (node.y < nodes[i].x) {
                stack.push(nodes[i]);
                continue;
            }
            node.y = Math.max(node.y, nodes[i].y);
        }
        int[][] result = new int[stack.size()][2];
        for (int i = result.length - 1; i >= 0; i--) {
            Node node = stack.pop();
            result[i][0] = node.x;
            result[i][1] = node.y;
        }
        return result;
    }

    public static class Node {
        int x;
        int y;
    }

}

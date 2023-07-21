package com.example.algorithm.leetcode.first;
//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
// Return a deep copy of the list.
//
// The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//
//
// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
//
//
//
// Example 1:
//
//
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// Example 2:
//
//
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
//
//
// Example 3:
//
//
//
//
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
//
//
// Example 4:
//
//
//Input: head = []
//Output: []
//Explanation: Given linked list is empty (null pointer), so return null.
//
//
//
// Constraints:
//
//
// -10000 <= Node.val <= 10000
// Node.random is null or pointing to a node in the linked list.
// Number of Nodes will not exceed 1000.
//
// Related Topics Hash Table Linked List

import java.util.HashMap;
import java.util.Map;

public class Solution_138 {
    public static void main(String[] args) {
        Solution_138 solution = new Solution_138();
        Node node = solution.createNodeLink(new Integer[][]{
                {7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}
        });
        solution.mySolution_4(node);
    }

    public Node copyRandomList(Node head) {
        return null;
    }

    public Node mySolution_1(Node head) {
        if (head == null) {
            return null;
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        Node[] nodes = new Node[count];
        int[] randoms = new int[count];

        temp = head;
        int i = 0;
        while (temp != null) {
            nodes[i] = new Node(temp.val);
            Node random = temp.random;
            if (random == null) {
                randoms[i] = -1;
            } else {
                Node first = head;
                int j = 0;
                while (first != null && first != random) {
                    first = first.next;
                    j++;
                }
                randoms[i] = j;
            }
            temp = temp.next;
            i++;
        }

        for (int j = 0; j < count; j++) {
            nodes[j].next = j == count - 1 ? null : nodes[j + 1];
            if (randoms[j] != -1) {
                nodes[j].random = nodes[randoms[j]];
            }
        }
        return nodes[0];
    }


    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    // 图回溯
    public Node mySolution_2(Node head) {
        if (head == null) {
            return null;
        }
        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }
        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val);
        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        this.visitedHash.put(head, node);
        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = mySolution_2(head.next);
        node.random = mySolution_2(head.random);
        return node;
    }

    // map
    public Node mySolution_3(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node result = new Node(0);
        Node temp = result;
        Node root = head;
        while (root != null) {
            temp.next = new Node(root.val);
            temp = temp.next;
            map.put(root, temp);
            root = root.next;
        }
        root = head;
        temp = result.next;
        while (root != null) {
            temp.random = root.random == null ? null : map.get(root.random);
            root = root.next;
            temp = temp.next;
        }
        return result.next;
    }

    // 倍增法
    public Node mySolution_4(Node head) {
        if (head == null) {
            return null;
        }
        Node first = head;
        Node second = null;
        while (first != null) {
            second = new Node(first.val);
            second.next = first.next;
            first.next = second;
            first = second.next;
        }
        first = head;
        second = first.next;
        while (first != null) {
            second.random = first.random != null ? first.random.next : null;
            first = second.next;
            second = first != null ? first.next : null;
        }
        first = head;
        second = first.next;
        Node result = second;
        while (first != null) {
            first.next = second.next;
            first = first.next;
            second.next = first == null ? null : first.next;
            second = second.next;
        }
        return result;
    }

    public Node createNodeLink(Integer[][] datas) {
        Node[] nodes = new Node[datas.length];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node(datas[i][0]);
            }
            if (i < nodes.length - 1) {
                nodes[i + 1] = new Node(datas[i + 1][0]);
                nodes[i].next = nodes[i + 1];
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            if (datas[i][1] != null) {
                nodes[i].random = nodes[datas[i][1]];
            }
        }
        return nodes[0];
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

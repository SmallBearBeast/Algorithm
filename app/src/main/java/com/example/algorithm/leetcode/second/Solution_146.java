package com.example.algorithm.leetcode.second;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution_146 {
    public static void main(String[] args) {
        Solution_146 solution_module = new Solution_146();
        solution_module.mySolution_1();
    }

    public void mySolution_1() {

    }


    // 常规实现
    private static class LRUCache {

        private final int capacity;
        private LRUNode head;
        private LRUNode tail;
        private final Map<Integer, LRUNode> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            LRUNode node = map.get(key);
            if (node != null) {
                moveToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                LRUNode node = map.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                insertNode(key, value);
                trimToCapacity();
            }
        }

        private void insertNode(int key, int value) {
            LRUNode node = new LRUNode(key, value);
            map.put(key, node);
            if (head != null) {
                node.next = head;
                head.prev = node;
            } else {
                tail = node;
            }
            head = node;
        }

        private void moveToHead(LRUNode node) {
            if (node == null || node == head) {
                return;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node == tail) {
                tail = node.prev;
            }
            head.prev = node;
            node.prev = null;
            node.next = head;
            head = node;
        }

        private void trimToCapacity() {
            while (tail != null && map.size() > capacity) {
                map.remove(tail.key);
                LRUNode preNode = tail.prev;
                if (preNode != null) {
                    preNode.next = null;
                    tail.prev = null;
                    tail.next = null;
                    tail = preNode;
                } else {
                    tail = null;
                    head = null;
                }
            }
        }
    }

    private static class LRUNode {
        LRUNode prev;
        LRUNode next;
        int key;
        int value;

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 继承LinkedHashMap，重写removeEldestEntry来实现。
    private static class LRUCache_1 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache_1(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

        public int get(int key) {
            Integer integer = super.get(key);
            return integer == null ? -1 : integer;
        }

        public void put(int key, int value) {
            super.put(key, value);
        }
    }
}


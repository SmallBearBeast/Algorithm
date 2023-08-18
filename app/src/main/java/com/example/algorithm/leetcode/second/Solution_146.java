package com.example.algorithm.leetcode.second;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
//
// 进阶:
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
// 示例:
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//
// Related Topics 设计

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


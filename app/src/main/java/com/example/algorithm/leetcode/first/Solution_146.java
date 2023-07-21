package com.example.algorithm.leetcode.first;

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
        Solution_146 solution = new Solution_146();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(2, 0.75f, true);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.get(2);

        LRUCache_1 cache = new LRUCache_1(3 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5, 5);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
    }

    static class LRUCache {
        private Map<Integer, Node> mMap;
        private int mCapacity;
        private int mLength;
        private Node mFirst;
        private Node mLast;

        public LRUCache(int capacity) {
            mCapacity = capacity;
            mMap = new HashMap<>(capacity);
        }

        public int get(int key) {
            Node node = mMap.get(key);
            adjustNode(node);
            return node == null ? -1 : node.val;
        }

        public void put(int key, int value) {
            if (mCapacity > 0 && mLength <= mCapacity) {
                Node node = mMap.get(key);
                if (node == null) {
                    node = new Node(key, value);
                    mLength++;
                }
                node.val = value;
                adjustNode(node);
                mMap.put(key, node);
            }
        }

        private void adjustNode(Node node) {
            if (node == null) {
                return;
            }
            if (node == mFirst) {
                return;
            }
            if (mFirst == null) {
                mFirst = node;
                mLast = node;
            } else {
                if (node == mLast) {
                    mLast = node.before;
                }
                if (node.before != null) {
                    node.before.after = node.after;
                }
                if (node.after != null) {
                    node.after.before = node.before;
                }
                node.before = null;
                node.after = null;
                mFirst.before = node;
                node.after = mFirst;
                mFirst = node;
                while (mLength > mCapacity) {
                    mMap.remove(mLast.key);
                    mLast = mLast.before;
                    mLast.after = null;
                    mLength--;
                }
            }
        }

        class Node {
            Node after;
            Node before;
            int val;
            int key;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    static class LRUCache_1 extends LinkedHashMap<Integer, Integer> {
        private int mCapacity;

        public LRUCache_1(int capacity) {
            super(capacity, 0.75f, true);
            mCapacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
            return size() > mCapacity;
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

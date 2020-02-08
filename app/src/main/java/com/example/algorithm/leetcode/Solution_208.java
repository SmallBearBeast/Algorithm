package com.example.algorithm.leetcode;

//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树

public class Solution_208 {
    public static void main(String[] args) {
        Solution_208 solution = new Solution_208();
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        trie.search("apps");
        trie.search("app");
        trie.search("ad");
//       ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
//        [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
    }

    static class Trie {
        public int count;
        public Trie[] tries;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            tries = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null) {
                return;
            }
            Trie temp = this;
            for (int i = 0; i < word.length(); i++) {
                if (temp.tries[word.charAt(i) - 'a'] == null) {
                    temp.tries[word.charAt(i) - 'a'] = new Trie();
                }
                temp = temp.tries[word.charAt(i) - 'a'];
            }
            temp.count++;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            Trie temp = this;
            for (int i = 0; i < word.length(); i++) {
                temp = temp.tries[word.charAt(i) - 'a'];
                if (temp == null) {
                    return false;
                }
            }
            return temp.count > 0;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null) {
                return false;
            }
            Trie temp = this;
            for (int i = 0; i < prefix.length(); i++) {
                temp = temp.tries[prefix.charAt(i) - 'a'];
                if (temp == null) {
                    return false;
                }
            }
            return true;
        }
    }
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}

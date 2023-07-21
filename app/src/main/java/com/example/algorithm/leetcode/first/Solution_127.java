package com.example.algorithm.leetcode.first;
//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//
//
// Note:
//
//
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
//
//
// Example 1:
//
//
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
//
//
// Example 2:
//
//
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
//
//
//
//
// Related Topics Breadth-first Search

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_127 {
    public static void main(String[] args) {
        Solution_127 solution = new Solution_127();
        List<String> list = new ArrayList<String>() {{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
        }};
        solution.mySolution_2("hit", "cog", list);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 1;
    }

    public class Pair<F, S> {
        public final F first;
        public final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public int mySolution(String beginWord, String endWord, List<String> wordList) {
        // Since all words are of same length.
        int L = beginWord.length();
        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, List<String>> allComboDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        }

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));
        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.first;
            int level = node.second;
            for (int i = 0; i < L; i++) {
                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    private int L;
    private HashMap<String, ArrayList<String>> allComboDict;

    private int visitWordNode(
            Queue<Pair<String, Integer>> Q,
            HashMap<String, Integer> visited,
            HashMap<String, Integer> othersVisited) {
        Pair<String, Integer> node = Q.remove();
        String word = node.first;
        int level = node.second;

        for (int i = 0; i < this.L; i++) {

            // Intermediate words for current word
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

            // Next states are all the words which share the same intermediate state.
            for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                // If at any point if we find what we are looking for
                // i.e. the end word - we can return with the answer.
                if (othersVisited.containsKey(adjacentWord)) {
                    return level + othersVisited.get(adjacentWord);
                }

                if (!visited.containsKey(adjacentWord)) {

                    // Save the level as the value of the dictionary, to save number of hops.
                    visited.put(adjacentWord, level + 1);
                    Q.add(new Pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }

    public int mySolution_2(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Since all words are of same length.
        this.L = beginWord.length();

        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformations =
                        this.allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                this.allComboDict.put(newWord, transformations);
            }
        }

        // Queues for birdirectional BFS
        // BFS starting from beginWord
        Queue<Pair<String, Integer>> Q_begin = new LinkedList<>();
        // BFS starting from endWord
        Queue<Pair<String, Integer>> Q_end = new LinkedList<>();
        Q_begin.add(new Pair(beginWord, 1));
        Q_end.add(new Pair(endWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Integer> visitedBegin = new HashMap<>();
        HashMap<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {
            // One hop from begin word
            int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
            if (ans > -1) {
                return ans;
            }
            // One hop from end word
            ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
            if (ans > -1) {
                return ans;
            }
        }
        return 0;
    }
}

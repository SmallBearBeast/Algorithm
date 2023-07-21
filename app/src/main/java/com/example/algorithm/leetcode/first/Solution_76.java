package com.example.algorithm.leetcode.first;
//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
// Example:
//
//
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
//
//
// Note:
//
//
// If there is no such window in S that covers all characters in T, return the empty string "".
// If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
//
// Related Topics Hash Table Two Pointers String Sliding Window


import java.util.HashMap;
import java.util.Map;

public class Solution_76 {
    public static void main(String[] args) {
        Solution_76 solution = new Solution_76();
        solution.mySolution_1("ADOBECODEBANC", "ABC");
    }

    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        //用来存储滑动窗口中的值(注意还有小写的)
        int[]hash = new int[256];
        //最小子串的长度
        int minlength = s.length();
        //最小子串
        String results = "";
        for(char smallt:tt)
        {
            hash[smallt-'0']++;
        }
        int left = 0;
        int right = 0;
        int count = tt.length;
        for(;right<ss.length;right++)
        {
            hash[ss[right]-'0']--;
            //说明当前的字符存在于T中，且当前滑动窗口中还需要该字符
            //后面这个且的意思就是比如我的T为ABC，我只有第一次遇到A才会count--，而第二次就不会了，
            if(hash[ss[right]-'0']>=0)
            {
                count--;
            }
            //right又遇到了left处的字符（特指遇到T中存在的），或left处的字符不是T中需要的，就右移左指针直到找到需要的或者left=right
            while(left<right&&hash[ss[left]-'0']<0)
            {
                hash[ss[left]-'0']++;
                left++;
            }
            //这里大于等于是防止最小覆盖子串就是s其本身
            if(count==0&&minlength>=right-left+1)
            {
                minlength = right-left+1;
                results = s.substring(left,right+1);
            }
        }
        return results;
    }

    // 滑动窗口
    public String mySolution_1(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int length = t.length();
        for (int i = 0; i < length; i++) {
            int val = tMap.containsKey(t.charAt(i)) ? tMap.get(t.charAt(i)) + 1 : 1;
            tMap.put(t.charAt(i), val);
        }
        length = s.length();
        int start = 0, end = 0;
        int bestStart = 0, bestEnd = Integer.MAX_VALUE;
        while (end <= length) {
            if (checkMap(sMap, tMap)) {
                if (end - start < bestEnd - bestStart) {
                    bestEnd = end;
                    bestStart = start;
                }
                char startCh = s.charAt(start);
                if (sMap.containsKey(startCh)) {
                    sMap.put(startCh, sMap.get(startCh) - 1);
                }
                start ++;
            } else if (end < length){
                char endCh = s.charAt(end);
                if (tMap.containsKey(endCh)) {
                    int val = sMap.containsKey(endCh) ? sMap.get(endCh) + 1 : 1;
                    sMap.put(endCh, val);
                }
                end++;
            } else if (end == length) {
                break;
            }
        }
        if (bestEnd == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(bestStart, bestEnd);
    }

    public boolean checkMap(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (entry.getValue() < tMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    // 优化
    public String mySolution_2(String s, String t) {
        return null;
    }

}

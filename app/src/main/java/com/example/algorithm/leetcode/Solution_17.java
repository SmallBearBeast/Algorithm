package com.example.algorithm.leetcode;
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
// Example:
//
//
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// Note:
//
// Although the above answer is in lexicographical order, your answer could be in any order you want.
// Related Topics String Backtracking


import java.util.ArrayList;
import java.util.List;

public class Solution_17 {
    public static void main(String[] args) {
        Solution_17 solution = new Solution_17();
        solution.mySolution("23");
    }

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) {
            return new ArrayList<String>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letter_map = {
                " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for(int i=0;i<digits.length();i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letter_map[digits.charAt(i)-'0'];
            int size = res.size();
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for(int j=0;j<size;j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for(int k=0;k<letters.length();k++) {
                    res.add(tmp+letters.charAt(k));
                }
            }
        }
        return res;
    }

    public List<String> mySolution(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        char[][] data = new char[10][];
        char[] letters = digits.toCharArray();
        data[2] = new char[]{'a', 'b', 'c'};
        data[3] = new char[]{'d', 'e', 'f'};
        data[4] = new char[]{'g', 'h', 'i'};
        data[5] = new char[]{'j', 'k', 'l'};
        data[6] = new char[]{'m', 'n', 'o'};
        data[7] = new char[]{'p', 'q', 'r', 's'};
        data[8] = new char[]{'t', 'u', 'v'};
        data[9] = new char[]{'w', 'x', 'y', 'z'};
        for (int i = 0; i < letters.length; i++) {
            result = mergePhoneLetter(result, data[letters[i] - '0']);
        }
        return result;
    }

    private List<String> mergePhoneLetter(List<String> mergeList, char[] mergeArray) {
        List<String> result = new ArrayList<>();
        if (mergeList.isEmpty()) {
            for (int j = 0; j < mergeArray.length; j++) {
                result.add(mergeArray[j] + "");
            }
        } else {
            for (int i = 0, size = mergeList.size(); i < size; i++) {
                for (int j = 0; j < mergeArray.length; j++) {
                    result.add(mergeList.get(i) + mergeArray[j]);
                }
            }
        }
        mergeList.clear();
        return result;
    }
}

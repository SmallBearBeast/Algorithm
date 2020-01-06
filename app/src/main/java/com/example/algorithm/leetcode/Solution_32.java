package com.example.algorithm.leetcode;
//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
// Example 1:
//
//
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
//
//
// Example 2:
//
//
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
//
// Related Topics String Dynamic Programming

import java.util.Stack;

public class Solution_32 {
    public static void main(String[] args) {
        Solution_32 solution_32 = new Solution_32();
        solution_32.mySolution_2(")()())");
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public int longestValidParentheses_1(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    public int longestValidParentheses_2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public int longestValidParentheses_3(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses_4(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public int longestValidParentheses(String s) {
        char[] letters = s.toCharArray();
        int maxCount = 0;
        int index = 0;
        while (index < letters.length) {
            if (letters[index] == ')') {
                index ++;
                continue;
            }
            int level = 1;
            int secondIndex = index + 1;
            while (secondIndex < letters.length) {
                if (letters[secondIndex] == '(') {
                    level ++;
                } else if (letters[secondIndex] == ')') {
                    level --;
                }
                if (level < 0) {
                    break;
                } else if (level == 0) {
                    maxCount = Math.max(secondIndex - index + 1, maxCount);
                }
                secondIndex ++;
            }
            index = secondIndex == letters.length ? index + 1 : secondIndex - 1;
        }
        return maxCount;
    }

    public int mySolution(String s) {
        char[] letters = s.toCharArray();
        int maxCount = 0;
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == ')') {
                continue;
            }
            int level = 1;
            for (int j = i + 1; j < letters.length; j++) {
                if (letters[j] == '(') {
                    level ++;
                } else if (letters[j] == ')') {
                    level --;
                }
                if (level < 0) {
                    break;
                } else if (level == 0) {
                    maxCount = Math.max(j - i + 1, maxCount);
                }
            }
        }
        return maxCount;
    }

    public int mySolution_2(String s) {
        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
        int maxCount = 0;
        int length = s.length();
        int start = 0;
        int end = 0;
        resultStack.push(0);
        resultStack.push(0);
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                indexStack.push(i);
            } else {
                if (indexStack.isEmpty()) {
                    continue;
                }
                int index = indexStack.pop();
                end = resultStack.pop();
                start = resultStack.pop();
                if ((start == 0 && end == 0) || (start > index)) {
                    start = index;
                    end = i;
                    if (!resultStack.isEmpty() && resultStack.peek() + 1 == start) {
                        resultStack.pop();
                        start = resultStack.pop();
                    }
                } else if (end + 1 == index) {
                    end = i;
                    if (!resultStack.isEmpty() && resultStack.peek() + 1 == start) {
                        resultStack.pop();
                        start = resultStack.pop();
                    }
                } else {
                    resultStack.push(start);
                    resultStack.push(end);
                    start = index;
                    end = i;
                }
                resultStack.push(start);
                resultStack.push(end);
                maxCount = Math.max(maxCount, end - start + 1);
            }
        }
        return maxCount == 1 ? 0 : maxCount;
    }

    public int mySolution_1(String s) {
        char[] letters = s.toCharArray();
        int maxCount = 0;
        int index = 0;
        while (index < letters.length) {
            if (letters[index] == ')') {
                index ++;
                continue;
            }
            int level = 1;
            int secondIndex = index + 1;
            while (secondIndex < letters.length) {
                if (letters[secondIndex] == '(') {
                    level ++;
                } else if (letters[secondIndex] == ')') {
                    level --;
                }
                if (level < 0) {
                    break;
                } else if (level == 0) {
                    maxCount = Math.max(secondIndex - index + 1, maxCount);
                }
                secondIndex ++;
            }
            index = secondIndex == letters.length ? index + 1 : secondIndex - 1;
        }
        return maxCount;
    }


}

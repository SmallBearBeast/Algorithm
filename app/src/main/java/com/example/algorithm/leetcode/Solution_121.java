package com.example.algorithm.leetcode;
//Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
// Note that you cannot sell a stock before you buy one.
//
// Example 1:
//
//
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying price.
//
//
// Example 2:
//
//
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
// Related Topics Array Dynamic Programming

public class Solution_121 {
    public static void main(String[] args) {
        Solution_121 solution = new Solution_121();
        solution.mySolution_1(new int[]{
                7, 6, 4, 3, 1
        });
    }

    public int maxProfit(int[] prices) {
        return 1;
    }

    public int mySolution_1(int[] prices) {
        int result = -1;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (result <= 0) {
                result = prices[i] - prices[i - 1];
            } else {
                result = result + prices[i] - prices[i - 1];
            }
            max = Math.max(max, result);
        }
        return max;
    }

    public int mySolution_2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

}

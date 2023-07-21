package com.example.algorithm.leetcode.first;

//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果：
//
//
// 每个孩子至少分配到 1 个糖果。
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。
//
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？
//
// 示例 1:
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
//
//
// 示例 2:
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
// Related Topics 贪心算法

import java.util.Arrays;

public class Solution_135 {
    public static void main(String[] args) {
        Solution_135 solution = new Solution_135();
        int result = solution.mySolution_2(new int[]{
                29, 51, 87, 89, 72, 12
        });
        System.out.println("result = " + result);
    }

    public int candy(int[] ratings) {
        return 1;
    }

    public int mySolution_1(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        return recursive_1(ratings, new int[ratings.length], 0, ratings.length - 1);
    }

    public int recursive_1(int[] ratings, int[] counts, int start, int end) {
        if (start > end) {
            return 0;
        }
        int minIndex = start;
        int minValue = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (ratings[i] < minValue) {
                minValue = ratings[i];
                minIndex = i;
            }
        }
        if (minIndex > start && minIndex < end) {
            count = 1;
        } else {
            if (minIndex == 0) {
                if (ratings[minIndex] == ratings[minIndex + 1]) {
                    count = 1;
                } else {
                    count = counts[minIndex + 1] + 1;
                }
            } else if (minIndex == counts.length - 1) {
                if (ratings[minIndex] == ratings[minIndex - 1]) {
                    count = 1;
                } else {
                    count = counts[minIndex - 1] + 1;
                }
            } else {
                if (ratings[minIndex - 1] == ratings[minIndex] && ratings[minIndex] <= ratings[minIndex + 1]) {
                    count = 1;
                } else if (ratings[minIndex - 1] < ratings[minIndex] && ratings[minIndex] <= ratings[minIndex + 1]) {
                    count = counts[minIndex - 1] + 1;
                } else if (ratings[minIndex + 1] == ratings[minIndex] && ratings[minIndex] <= ratings[minIndex - 1]) {
                    count = 1;
                } else if (ratings[minIndex + 1] < ratings[minIndex] && ratings[minIndex] <= ratings[minIndex - 1]) {
                    count = counts[minIndex + 1] + 1;
                } else {
                    count = Math.max(counts[minIndex - 1], counts[minIndex + 1]) + 1;
                }
            }
        }
        counts[minIndex] = count;
        return count + recursive_1(ratings, counts, start, minIndex - 1) + recursive_1(ratings, counts, minIndex + 1, end);
    }

    public int mySolution_2(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] counts = new int[ratings.length];
        counts[0] = 1;
        int index = 1;
        while (index < ratings.length) {
            if (ratings[index] > ratings[index - 1]) {
                counts[index] = counts[index - 1] + 1;
            } else if (ratings[index] == ratings[index - 1]) {
                counts[index] = 1;
            } else if (counts[index - 1] > 1) {
                counts[index] = 1;
            } else {
                counts[index] = 1;
                int temp = index;
                while (temp > 0 && counts[temp] >= counts[temp - 1] && ratings[temp - 1] > ratings[temp]) {
                    counts[temp - 1] = counts[temp] + 1;
                    temp--;
                }
            }
            index++;
        }
        int result = 0;
        for (int i = 0; i < counts.length; i++) {
            result = result + counts[i];
        }
        return result;
    }

    public int mySolution_3(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }

    public int mySolution_4(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }

}

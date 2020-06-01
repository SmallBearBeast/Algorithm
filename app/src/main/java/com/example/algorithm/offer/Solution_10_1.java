package com.example.algorithm.offer;

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_10_1 {
    public static void main(String[] args) {
        Solution_10_1 solution = new Solution_10_1();
        solution.mySolution_1(3);
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(2);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        });

        for (int i = 0; i < 10; i++) {
            String s = "hello" + i;
            System.out.println(s);
        }
        list = null;
    }

    public int fib(int n) {
        return 1;
    }

    public int mySolution_1(int n) {
        if (n <= 1) {
            return n;
        }
        long first = 0;
        long second = 1;
        long third = 0;
        for (int i = 0; i < n - 1; i++) {
            third = (first + second) % 1000000007;
            first = second;
            second = third;
        }
        return (int) third;
    }

    public int mySolution_2(int n) {
        return 1;
    }

}

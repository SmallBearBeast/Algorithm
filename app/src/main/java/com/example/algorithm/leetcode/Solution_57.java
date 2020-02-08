package com.example.algorithm.leetcode;

//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
// 示例 1:
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
//
//
// 示例 2:
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
// Related Topics 排序 数组

import java.util.LinkedList;

public class Solution_57 {
    public static void main(String[] args) {
        Solution_57 solution = new Solution_57();
        solution.mySolution_2(new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}

        }, new int[]{
                4, 8
        });
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        return null;
    }

    public int[][] mySolution_1(int[][] intervals, int[] newInterval) {
        int[][] temp = new int[intervals.length + 1][2];
        int i = 0;
        int j = -1;
        while (i < intervals.length) {
            if (j != -1) {
                if (temp[j][1] < intervals[i][0]) {
                    break;
                }
                if (temp[j][1] >= intervals[i][0] && temp[j][1] <= intervals[i][1]) {
                    temp[j][1] = intervals[i][1];
                    i++;
                    break;
                }
                i++;
                continue;
            }
            if (newInterval[1] < intervals[i][0]) {
                temp[i][0] = newInterval[0];
                temp[i][1] = newInterval[1];
                j = i;
                break;
            }
            if (newInterval[0] > intervals[i][1]) {
                temp[i][0] = intervals[i][0];
                temp[i][1] = intervals[i][1];
            } else {
                j = i;
                temp[i][0] = Math.min(intervals[i][0], newInterval[0]);
                temp[i][1] = Math.max(intervals[i][1], newInterval[1]);
            }
            i++;
        }
        if (j == -1) {
            temp[intervals.length][0] = newInterval[0];
            temp[intervals.length][1] = newInterval[1];
            return temp;
        }
        j++;
        while (i < intervals.length) {
            temp[j][0] = intervals[i][0];
            temp[j][1] = intervals[i][1];
            j++;
            i++;
        }
        int[][] res = new int[j][2];
        for (int k = 0; k < j; k++) {
            res[k][0] = temp[k][0];
            res[k][1] = temp[k][1];
        }
        return res;
    }

    public int[][] mySolution_2(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        int index = 0;
        while (index < intervals.length) {
            if (newInterval[1] < intervals[index][0]) {
                list.add(newInterval);
                list.add(intervals[index]);
                break;
            }
            if (newInterval[0] <= intervals[index][1]) {
                list.add(new int[] {
                        Math.min(newInterval[0],intervals[index][0]),
                        Math.max(newInterval[1],intervals[index][1])
                });
                break;
            }
            list.add(intervals[index]);
            index ++;
        }
        if (index == intervals.length) {
            list.add(newInterval);
        } else {
            index ++;
            while (index < intervals.length) {
                int[] datas = list.removeLast();
                if (intervals[index][0] <= datas[1]) {
                    datas[0] = Math.min(datas[0], intervals[index][0]);
                    datas[1] = Math.max(datas[1], intervals[index][1]);
                    list.add(datas);
                } else {
                    list.add(datas);
                    list.add(intervals[index]);
                }
                index++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

}

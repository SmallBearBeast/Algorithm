package com.example.algorithm.offer;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//示例 1：
//输入：m = 2, n = 3, k = 1
//输出：3
//示例 1：
//输入：m = 3, n = 1, k = 0
//输出：1
//提示：
//1 <= n,m <= 100
//0 <= k <= 20

import java.util.LinkedList;
import java.util.Queue;

public class Solution_13 {
    public static void main(String[] args) {
        Solution_13 solution = new Solution_13();
        solution.mySolution_1(2, 3, 1);
    }

    public int movingCount(int m, int n, int k) {
        return 1;
    }

    int m, n, k;
    boolean[][] visited;

    // dfs 考虑解集结构，增量计算
    public int mySolution_1(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs_1(0, 0, 0, 0);
    }

    public int dfs_1(int i, int j, int si, int sj) {
        if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs_1(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs_1(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    // bfs 考虑解集结构，增量计算
    public int mySolution_2(int m, int n, int k) {
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        if (k < 0) {
            return res;
        }
        queue.add(new int[]{0, 0, 0, 0});
        res++;
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            int[] datas = queue.poll();
            int si = (datas[0] + 1) % 10 == 0 ? datas[2] - 8 : datas[2] + 1;
            int sj = (datas[1] + 1) % 10 == 0 ? datas[3] - 8 : datas[3] + 1;
            if (datas[0] < m - 1 && !visit[datas[0] + 1][datas[1]]) {
                visit[datas[0] + 1][datas[1]] = true;
                if (si + datas[3] <= k) {
                    queue.add(new int[] {datas[0] + 1, datas[1], si, datas[3]});
                    res++;
                }
            }
            if (datas[1] < n - 1 && !visit[datas[0]][datas[1] + 1]) {
                visit[datas[0]][datas[1] + 1] = true;
                if (datas[2] + sj <= k) {
                    queue.add(new int[] {datas[0], datas[1] + 1, datas[2], sj});
                    res++;
                }
            }
        }
        return res;
    }
}

package com.example.algorithm.leetcode.first;

//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？ 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution_207 {
    public static void main(String[] args) {
        Solution_207 solution = new Solution_207();
        solution.mySolution_1(3, new int[][]{
                {0, 1, 2}, {0, 2},
        });
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return false;
    }

    // 邻接表 + 拓扑排序
    public boolean mySolution_2(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Set<Integer>[] adjacencys = new Set[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencys[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = prerequisites[i].length - 1; j > 0; j--) {
                adjacencys[prerequisites[i][j]].add(prerequisites[i][j - 1]);
                indegrees[prerequisites[i][j - 1]] ++;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count ++;
            Set<Integer> tempSet = adjacencys[temp];
            for (Integer i : tempSet) {
                indegrees[i] --;
                if (indegrees[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return count == numCourses;
    }

    // 邻接表 + dfs
    public boolean mySolution_1(int numCourses, int[][] prerequisites) {
        Set<Integer>[] adjacencys = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencys[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = prerequisites[i].length - 1; j > 0; j--) {
                adjacencys[prerequisites[i][j]].add(prerequisites[i][j - 1]);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(adjacencys, new boolean[numCourses], i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(Set<Integer>[] adjacencys, boolean[] visits, int key) {
        if (visits[key]) {
            return true;
        }
        visits[key] = true;
        Set<Integer> tempSet = adjacencys[key];
        for (int temp : tempSet) {
            if (dfs(adjacencys, visits, temp)) {
                return true;
            }
        }
        visits[key] = false;
        return false;
    }
}

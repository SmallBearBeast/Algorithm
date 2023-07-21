package com.example.algorithm.leetcode.first;

//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
// 示例 1:
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \
//     3   1
//
//输出: 7
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
//
// 示例 2:
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
//
// Related Topics 树 深度优先搜索

import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_337 {
    public static void main(String[] args) {
        Solution_337 solution = new Solution_337();
        int result = solution.mySolution_1(SolutionUtil.createTree(new Integer[]{
                3, 4, 5, 1, 3, null, 1
        }));
        System.out.println("result = " + result);
    }

    public int rob(TreeNode root) {
        return 0;
    }

    public int mySolution_1(TreeNode root) {
        int[] results = recursive_1(root);
        return results[1];
    }

    public int[] recursive_1(TreeNode root) {
        if (root == null) {
            return new int[]{
                    0, 0, 0
            };
        }
        if (root.left == null && root.right == null) {
            return new int[]{
                    1, root.val, 0
            };
        }
        int[] leftValues = recursive_1(root.left);
        int[] rightValues = recursive_1(root.right);
        if (leftValues[0] == 0 && rightValues[0] == 0) {
            return new int[]{
                    1, leftValues[1] + rightValues[1] + root.val, leftValues[1] + rightValues[1]
            };
        } else if (leftValues[0] == 1 && rightValues[0] == 1) {
            if (leftValues[1] + rightValues[1] >= root.val + leftValues[2] + rightValues[2]) {
                return new int[]{
                        0, leftValues[1] + rightValues[1], leftValues[1] + rightValues[1]
                };
            } else {
                return new int[]{
                        1, root.val + leftValues[2] + rightValues[2], leftValues[1] + rightValues[1]
                };
            }
        } else if (leftValues[0] == 1 && rightValues[0] == 0) {
            if (leftValues[1] + rightValues[1] >= leftValues[2] + rightValues[1] + root.val) {
                return new int[]{
                        0, leftValues[1] + rightValues[1], leftValues[1] + rightValues[1]
                };
            } else {
                return new int[]{
                        1, leftValues[2] + rightValues[1] + root.val, leftValues[1] + rightValues[1]
                };
            }
        } else {
            if (leftValues[1] + rightValues[1] >= leftValues[1] + rightValues[2] + root.val) {
                return new int[]{
                        0, leftValues[1] + rightValues[1], leftValues[1] + rightValues[1]
                };
            } else {
                return new int[]{
                        1, leftValues[1] + rightValues[2] + root.val, leftValues[1] + rightValues[1]
                };
            }
        }
    }

    public int mySolution_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money = money + mySolution_2(root.left.left) + mySolution_2(root.left.right);
        }
        if (root.right != null) {
            money = money + mySolution_2(root.right.left) + mySolution_2(root.right.right);
        }
        return Math.max(money, mySolution_2(root.left) + mySolution_2(root.right));
    }

    public int mySolution_3(TreeNode root) {
        return recursive_3(root, new HashMap<TreeNode, Integer>());
    }

    public int recursive_3(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money = money + recursive_3(root.left.left, map) + recursive_3(root.left.right, map);
        }
        if (root.right != null) {
            money = money + recursive_3(root.right.left, map) + recursive_3(root.right.right, map);
        }
        money = Math.max(money, recursive_3(root.left, map) + recursive_3(root.right, map));
        map.put(root, money);
        return money;
    }

    public int mySolution_4(TreeNode root) {
        int[] results = recursive_4(root);
        return results[1];
    }

    public int[] recursive_4(TreeNode root) {
        if (root == null) {
            return new int[]{
                    0, 0
            };
        }
        if (root.left == null && root.right == null) {
            return new int[]{
                    root.val, 0
            };
        }
        int[] leftValues = recursive_4(root.left);
        int[] rightValues = recursive_4(root.right);
        if (leftValues[0] + rightValues[0] >= root.val + leftValues[1] + rightValues[1]) {
            return new int[]{
                    leftValues[0] + rightValues[0], leftValues[0] + rightValues[0]
            };
        } else {
            return new int[]{
                    root.val + leftValues[1] + rightValues[1], leftValues[0] + rightValues[0]
            };
        }
    }

    public int mySolution_5(TreeNode root) {
        int[] result = recursive_5(root);
        return Math.max(result[0], result[1]);
    }

    public int[] recursive_5(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = recursive_5(root.left);
        int[] right = recursive_5(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}

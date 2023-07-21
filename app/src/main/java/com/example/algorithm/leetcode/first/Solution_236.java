package com.example.algorithm.leetcode.first;

import com.example.algorithm.structure.SolutionUtil;
import com.example.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树


public class Solution_236 {
    public static void main(String[] args) {
        Solution_236 solution = new Solution_236();
        solution.mySolution_3(SolutionUtil.createTree(new Integer[]{
                3,
                5, 1,
                6, 2, 0, 8,
                null, null, 7, 4
        }), new TreeNode(5), new TreeNode(4));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    // 比较公共前缀法
    public TreeNode mySolution_1(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();
        recursive_1(pList, root, p);
        recursive_1(qList, root, q);
        int temp = 0;
        for (int i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i).equals(qList.get(i))) {
                temp = pList.get(i);
            } else {
                break;
            }
        }
        return new TreeNode(temp);
    }

    public TreeNode mySolution_2(TreeNode root, TreeNode p, TreeNode q) {
        recursive_2(root, p, q);
        return result;
    }

    public boolean recursive_1(List<Integer> pathList, TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        pathList.add(root.val);
        if (root.val == node.val) {
            return true;
        }
        boolean search = recursive_1(pathList, root.left, node) || recursive_1(pathList, root.right, node);
        if (!search) {
            pathList.remove(pathList.size() - 1);
        }
        return search;
    }

    // 自底向上法
    public TreeNode result;

    public int recursive_2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int left = recursive_2(root.left, p, q);
        if (left == 2) {
            return 2;
        }
        int right = recursive_2(root.right, p, q);
        if (right == 2) {
            return 2;
        }
        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if (left + right + mid == 2) {
            result = root;
        }
        return left + right + mid;
    }

    public TreeNode mySolution_3(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        stack.push(root);
        map.put(root, null);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == p.val) {
                p = node;
                count++;
            }
            if (node.val == q.val) {
                q = node;
                count++;
            }
            if (count == 2) {
                break;
            }
            if (node.left != null) {
                stack.push(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                stack.push(node.right);
                map.put(node.right, node);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (!set.contains(q)) {
            q = map.get(q);
        }
        return q;
    }

    /*
    我们使用DFS搜索每一个节点的左右子树：
    1、若子树上存在p和q的公共节点，返回此公共节点
    2、若不存在公共节点，但是存在p或q任意一个节点，返回此节点
    3、若不存在公共、p、q节点，则返回null。

    那么，有以下几个结论：
    0、若当前节点为null、p、q之一，直接返回当前节点
    1、若左子树上存在公共节点（返回值非p、q），则函数返回值为左子树返回值，不需再遍历右子树
    2、若左子树返回null，则函数返回值为右子树返回值
    3、若左子树、右子树返回值均为非null，则肯定为一个p，一个q，则公共节点为当前节点
    4、最后一种情况，即左子树返回非null，右子树返回null，则函数返回值为左子树返回值
     */
    public TreeNode mySolution_4(TreeNode root, TreeNode p, TreeNode q) {
        //结论0
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //结论1
        if (left != null && left != q && left != p) {
            return left;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //结论3
        if (left != null && right != null) {
            return root;
        }
        //结论2 4
        else {
            return left == null ? right : left;
        }
    }
}

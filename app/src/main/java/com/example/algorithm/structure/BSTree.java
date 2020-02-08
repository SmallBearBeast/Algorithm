package com.example.algorithm.structure;

import java.util.Stack;

// 该BST各个不允许重复节点
public class BSTree {
    private BSTreeNode mRoot;

    // 是否存在
    public boolean existNode(int val) {
        return existNodeInternal_2(val);
    }

    private boolean existNodeInternal_1(BSTreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val > val) {
            return existNodeInternal_1(root.left, val);
        } else if (root.val < val) {
            return existNodeInternal_1(root.right, val);
        } else {
            return true;
        }
    }

    private boolean existNodeInternal_2(int val) {
        if (mRoot == null) {
            return false;
        }
        BSTreeNode node = mRoot;
        while (node != null) {
            if (val < node.val) {
                node = node.left;
            } else if (val > node.val){
                node = node.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // 最大值
    public int maxVal() {
        BSTreeNode node = mRoot;
        while (node != null && node.right != null) {
            node = node.right;
        }
        return node == null ? Integer.MAX_VALUE : node.val;
    }

    // 最小值
    public int minVal() {
        BSTreeNode node = mRoot;
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node == null ? Integer.MIN_VALUE : node.val;
    }

    // 求后继
    public Integer successor(int val) {
        if (mRoot == null) {
            return null;
        }
        BSTreeNode searchNode = mRoot;
        Stack<BSTreeNode> stack = new Stack<>();
        while (searchNode != null) {
            if (val < searchNode.val) {
                stack.push(searchNode);
                searchNode = searchNode.left;
            } else if (val > searchNode.val){
                stack.push(searchNode);
                searchNode = searchNode.right;
            } else {
                break;
            }
        }
        if (searchNode == null) {
            return null;
        }
        if (searchNode.right != null) {
            searchNode = searchNode.right;
            BSTreeNode preNode = searchNode;
            while (searchNode != null) {
                preNode = searchNode;
                searchNode = searchNode.left;
            }
            return preNode.val;
        }
        while (!stack.isEmpty()) {
            BSTreeNode node = stack.pop();
            if (node.val > searchNode.val) {
                return node.val;
            }
        }
        return null;
    }

    // 求前继
    public Integer predecessor(int val) {
        if (mRoot == null) {
            return null;
        }
        BSTreeNode searchNode = mRoot;
        Stack<BSTreeNode> stack = new Stack<>();
        while (searchNode != null) {
            if (val < searchNode.val) {
                stack.push(searchNode);
                searchNode = searchNode.left;
            } else if (val > searchNode.val){
                stack.push(searchNode);
                searchNode = searchNode.right;
            } else {
                break;
            }
        }
        if (searchNode == null) {
            return null;
        }
        if (searchNode.left != null) {
            searchNode = searchNode.left;
            BSTreeNode preNode = searchNode;
            while (searchNode != null) {
                preNode = searchNode;
                searchNode = searchNode.right;
            }
            return preNode.val;
        }
        while (!stack.isEmpty()) {
            BSTreeNode node = stack.pop();
            if (node.val < searchNode.val) {
                return node.val;
            }
        }
        return null;
    }

    // 插入
    public void insertBST(int val) {
        if (mRoot == null) {
            mRoot = new BSTreeNode(val);
            return;
        }
        BSTreeNode tempNode = mRoot;
        BSTreeNode preNode = mRoot;
        while (tempNode != null) {
            preNode = tempNode;
            if (val < tempNode.val) {
                tempNode = tempNode.left;
            } else if (val > tempNode.val){
                tempNode = tempNode.right;
            } else {
                return;
            }
        }
        if (preNode.left == null && val < preNode.val) {
            preNode.left = new BSTreeNode(val);
        } else if (preNode.right == null && val > preNode.val) {
            preNode.right = new BSTreeNode(val);
        }
    }

    // 删除
    public void deleteBST(int val) {
        if (mRoot == null) {
            return;
        }
        BSTreeNode deleteNode = mRoot;
        BSTreeNode parentNode = mRoot;
        while (deleteNode != null) {
            if (val < deleteNode.val) {
                parentNode = deleteNode;
                deleteNode = deleteNode.left;
            } else if (val > deleteNode.val){
                parentNode = deleteNode;
                deleteNode = deleteNode.right;
            } else {
                break;
            }
        }
        if (deleteNode == null) {
            return;
        }
        if (deleteNode.right == null && parentNode.left == deleteNode) {
            parentNode.left = deleteNode.left;
            deleteNode.left = null;
            return;
        }
        if (deleteNode.left == null && parentNode.right == deleteNode) {
            parentNode.right = deleteNode.right;
            deleteNode.right = null;
            return;
        }

        BSTreeNode preNode = deleteNode.right;
        BSTreeNode successorNode = preNode;
        while (successorNode.left != null) {
            preNode = successorNode;
            successorNode = successorNode.left;
        }
        if (preNode == successorNode) {
            successorNode.left = deleteNode.left;
            if (parentNode.left == deleteNode) {
                parentNode.left = successorNode;
            }
            if (parentNode.right == deleteNode) {
                parentNode.right = successorNode;
            }
            deleteNode.left = null;
            deleteNode.right = null;
            return;
        }
        preNode.left = successorNode.right;
        successorNode.right = null;
        if (parentNode.left == deleteNode) {
            parentNode.left = successorNode;
        }
        if (parentNode.right == deleteNode) {
            parentNode.right = successorNode;
        }
        successorNode.left = deleteNode.left;
        successorNode.right = deleteNode.right;
        deleteNode.left = null;
        deleteNode.right = null;
        if (deleteNode == parentNode) {
            mRoot = successorNode;
        }
    }

    public void print() {
        printInternal(mRoot);
    }

    private void printInternal(BSTreeNode root) {
        if (root != null) {
            printInternal(root.left);
            System.out.println(root.val + " ");
            printInternal(root.right);
        }
    }


    private static class BSTreeNode {
        int val;
        BSTreeNode left;
        BSTreeNode right;

        public BSTreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] nums = new int[] {
                10,
                5, 15,
                2, 7, 13, 17,
                1, 3, 6, 9, 11, 14, 16, 19
        };
        for (int i = 0; i < nums.length; i++) {
            bsTree.insertBST(nums[i]);
        }
        System.out.println("maxVal = " + bsTree.maxVal());
        System.out.println("minVal = " + bsTree.minVal());
        System.out.println("successor = " + bsTree.successor(15));
        System.out.println("predecessor = " + bsTree.predecessor(2));
        System.out.println("existNode = " + bsTree.existNode(2));

        bsTree.deleteBST(10);
        bsTree.deleteBST(15);
        bsTree.print();
    }

}

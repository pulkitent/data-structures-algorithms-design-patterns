package com.pulkit.datastructures_algorithms.todo;

import com.pulkit.datastructures_algorithms.done.trees.TreeNode;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = createIncorrectBST();
        doRecovery(root);
    }

    private static void doRecovery(TreeNode node) {
        WrongPair pair = new WrongPair();
        isValidBST(node, pair);
        System.out.println(pair);
    }

    public static void isValidBST(TreeNode node, WrongPair pair) {
        if (node == null)
            return;

        if (node.leftChild == null && node.rightChild == null)
            return;

        TreeNode minNodeInRightSubtree = findMinNode(node.rightChild);
        TreeNode maxNodeInLeftSubtree = findMaxNode(node.leftChild);

        if (node.data >= minNodeInRightSubtree.data) {
            pair.setFirstWrong(minNodeInRightSubtree);
        }

        if (node.data <= maxNodeInLeftSubtree.data) {
            pair.setSecondWrong(maxNodeInLeftSubtree);
        }

        isValidBST(node.leftChild, pair);
        isValidBST(node.rightChild, pair);
    }

    static TreeNode findMinNode(TreeNode node) {
        if (node == null)
            return new TreeNode(Integer.MAX_VALUE, null, null);

        if (node.leftChild == null && node.rightChild == null)
            return node;

        TreeNode minInLeftSubtree = findMinNode(node.leftChild);
        TreeNode minInRightSubtree = findMinNode(node.rightChild);

        TreeNode minInLeftAndRight = minInLeftSubtree.data < minInRightSubtree.data
                ? minInLeftSubtree
                : minInRightSubtree;

        TreeNode finalMinNode = node.data < minInLeftAndRight.data
                ? node
                : minInLeftAndRight;

        return finalMinNode;
    }

    static TreeNode findMaxNode(TreeNode node) {
        if (node == null)
            return new TreeNode(Integer.MIN_VALUE, null, null);

        if (node.leftChild == null && node.rightChild == null)
            return node;

        TreeNode maxInLeftSubtree = findMaxNode(node.leftChild);
        TreeNode maxInRightSubtree = findMaxNode(node.rightChild);

        TreeNode maxInLeftAndRight = maxInLeftSubtree.data > maxInRightSubtree.data
                ? maxInLeftSubtree
                : maxInRightSubtree;

        TreeNode finalMaxNode = node.data > maxInLeftAndRight.data
                ? node
                : maxInLeftAndRight;

        return finalMaxNode;
    }

    private static TreeNode createBST() {
        TreeNode fourteen = new TreeNode(14, null, null);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode one = new TreeNode(1, null, null);

        TreeNode ten = new TreeNode(10, one, six);
        TreeNode three = new TreeNode(3, null, fourteen);

        TreeNode root = new TreeNode(8, three, ten);

        return root;
    }

    private static TreeNode createIncorrectBST() {
        TreeNode fourteen = new TreeNode(14, null, null);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode one = new TreeNode(1, null, null);

        TreeNode ten = new TreeNode(10, null, fourteen);
        TreeNode three = new TreeNode(3, one, six);

        TreeNode root = new TreeNode(8, ten, three);

        return root;
    }
}

class WrongPair {
    TreeNode firstWrong;
    TreeNode secondWrong;

    public void setFirstWrong(TreeNode firstWrong) {
        this.firstWrong = firstWrong;
    }

    public void setSecondWrong(TreeNode secondWrong) {
        this.secondWrong = secondWrong;
    }

    @Override
    public String toString() {
        if (firstWrong != null && secondWrong != null) {
            return "firstWrong = " + firstWrong.data +
                    ", secondWrong = " + secondWrong.data;
        }

        if (firstWrong != null) {
            return "firstWrong = " + firstWrong.data;
        }

        if (secondWrong != null) {
            return "secondWrong = " + secondWrong.data;
        }

        return "Tree is valid BST";
    }
}
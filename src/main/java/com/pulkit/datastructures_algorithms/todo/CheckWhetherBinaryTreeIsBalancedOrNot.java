package com.pulkit.datastructures_algorithms.todo;


import com.pulkit.datastructures_algorithms.done.trees.TreeNode;

import static java.lang.Math.abs;
import static java.lang.Math.max;

//TODO: Do it in optimized way
public class CheckWhetherBinaryTreeIsBalancedOrNot {
    public static void main(String[] args) {

    }

    static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        Integer leftSubtreeHeight = getHeight(root.leftChild);
        Integer rightSubtreeHeight = getHeight(root.rightChild);

        if (abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
            return false;
        }
        return isBalanced(root.leftChild) && isBalanced(root.rightChild);
    }

    private static Integer getHeight(TreeNode root) {
        if (root == null)
            return 0;

        if (root.leftChild == null && root.rightChild == null) {
            return 1;
        }

        Integer leftSubtreeHeight = getHeight(root.leftChild);
        Integer rightSubtreeHeight = getHeight(root.rightChild);

        int maxHeightFromSubtrees = max(leftSubtreeHeight, rightSubtreeHeight);

        return maxHeightFromSubtrees + 1;
    }
}
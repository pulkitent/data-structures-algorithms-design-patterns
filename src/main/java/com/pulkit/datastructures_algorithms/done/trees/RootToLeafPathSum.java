package com.pulkit.datastructures_algorithms.done.trees;

import java.util.Stack;

/*
Test case
           1
    2             3
 4     5      6      7
8 9  10 11  12 13  14 15

expected output for for 26 : 1->3->7->15
expected output for for 15 : 1->2->4->8
expected output for for 18 : 1->2->5->10
expected output for for 23 : 1->3->6->13

*/

//TODO: Root node is not getting printed
public class RootToLeafPathSum {
    private static Stack<TreeNode> stack = new Stack<>();

    public static void main(String[] args) {
        TreeNode fifteen = new TreeNode(15, null, null);
        TreeNode fourteen = new TreeNode(14, null, null);
        TreeNode thirteen = new TreeNode(13, null, null);
        TreeNode twelve = new TreeNode(12, null, null);
        TreeNode eleven = new TreeNode(11, null, null);
        TreeNode ten = new TreeNode(10, null, null);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode seven = new TreeNode(7, fourteen, fifteen);
        TreeNode six = new TreeNode(6, twelve, thirteen);
        TreeNode five = new TreeNode(5, ten, eleven);
        TreeNode four = new TreeNode(4, eight, nine);
        TreeNode three = new TreeNode(3, six, seven);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode root = new TreeNode(1, two, three);

        //addSumFromRootToLeaf(root, 0, 26);
        //addSumFromRootToLeaf(root, 0, 15);
        //addSumFromRootToLeaf(root, 0, 18);
        addSumFromRootToLeaf(root, 0, 23);

        for (TreeNode node : stack) {
            if (node != null)
                System.out.println(node.data);
        }
    }

    static boolean addSumFromRootToLeaf(TreeNode node, int currentSum, int givenSum) {
        if (currentSum > givenSum)
            return false;

        if (currentSum == givenSum)
            return true;

        if (node == null)
            return false;

        if (addSumFromRootToLeaf(node.leftChild, currentSum + node.data, givenSum)) {
            stack.push(node.leftChild);
            return true;
        }

        if (addSumFromRootToLeaf(node.rightChild, currentSum + node.data, givenSum)) {
            stack.push(node.rightChild);
            return true;
        }

        return false;
    }
}
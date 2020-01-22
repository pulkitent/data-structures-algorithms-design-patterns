package com.pulkit.datastructures_algorithms.done.trees;/*
Test case
           1
       2       5
     3   4  6

expected output - 1->2->3->4->5->6
*/

/*
Test case
           1
    2             3
 4     5      6      7
8 9  10 11  12 13  14 15

expected output - 1->2->4->8->9->10->5->11->3->6->12->13->7->14->15
*/

public class FlattenBinaryTreeToLinkedList {
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

        flatten(root);

        TreeNode ptr = root;

        while (ptr != null) {
            System.out.print(" " + ptr.data);
            ptr = ptr.rightChild;
        }
    }

    static void flatten(TreeNode node) {
        if (node == null)
            return;

        flatten(node.leftChild);
        flatten(node.rightChild);

        TreeNode iterator = node.leftChild;

        while (iterator != null && iterator.rightChild != null) {
            iterator = iterator.rightChild;
        }

        while (iterator != null && iterator.leftChild != null) {
            iterator = iterator.leftChild;
        }

        TreeNode rightTemp = node.rightChild;

        node.rightChild = node.leftChild;
        node.leftChild = null;

        if (iterator != null) {
            iterator.rightChild = rightTemp;
        }
    }
}
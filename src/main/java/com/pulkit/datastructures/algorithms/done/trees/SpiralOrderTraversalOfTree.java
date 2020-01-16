package com.pulkit.datastructures.algorithms.done.trees;

import java.util.LinkedList;


//TODO: To be fixed
public class SpiralOrderTraversalOfTree {
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

        printSpiralOrderTraversal(root);
    }

    static void printSpiralOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        LinkedList<TreeNode> queueForEvenLevel = new LinkedList<>();
        LinkedList<TreeNode> stackForOddLevel = new LinkedList<>();

        queueForEvenLevel.addFirst(node);

        while (!(queueForEvenLevel.isEmpty() && stackForOddLevel.isEmpty())) {
            while (!queueForEvenLevel.isEmpty()) {
                TreeNode peek = queueForEvenLevel.getFirst();
                if (peek != null) {
                    System.out.print(" " + peek.data);
                    stackForOddLevel.push(peek.leftChild);
                    stackForOddLevel.push(peek.rightChild);
                }
                queueForEvenLevel.removeFirst();
            }

            while (!stackForOddLevel.isEmpty()) {
                TreeNode peek = stackForOddLevel.pop();
                if (peek != null) {
                    System.out.print(" " + peek.data);
                    queueForEvenLevel.addLast(peek.rightChild);
                    queueForEvenLevel.addLast(peek.leftChild);
                }
            }
        }
    }
}
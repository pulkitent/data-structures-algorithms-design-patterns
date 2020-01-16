package com.pulkit.datastructures.algorithms.done.trees;

import java.util.LinkedList;

/*
Actual Tree
                   8
              3         10
            1    .    6    14
           5 9  . .  4 7  13 2


Diagonal Representation
                 \8
               \ 3\10
              \1\ 6\14
              5\9\ 7\2
                \4\13\
*/


public class DiagonalTraversalOfTree {
    public static void main(String[] args) {
        TreeNode two = new TreeNode(2, null, null);
        TreeNode thirteen = new TreeNode(13, null, null);

        TreeNode seven = new TreeNode(7, null, null);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode five = new TreeNode(5, null, null);

        TreeNode fourteen = new TreeNode(14, thirteen, two);
        TreeNode six = new TreeNode(6, four, seven);
        TreeNode one = new TreeNode(1, five, nine);

        TreeNode ten = new TreeNode(10, six, fourteen);
        TreeNode three = new TreeNode(3, one, null);

        TreeNode root = new TreeNode(8, three, ten);

        doTraversal(root);
    }

    private static void doTraversal(TreeNode node) {
        if (node == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode ptr = node;

        while (ptr != null) {
            queue.add(ptr);
            ptr = ptr.rightChild;
        }

        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.pop();
            if (currentNode != null) {
                System.out.print(currentNode.data + " ");
            }

            if (currentNode == null) {
                System.out.println();
            }

            if (currentNode != null) {
                if (currentNode.leftChild != null) {
                    queue.add(currentNode.leftChild);
                    if (currentNode.leftChild.rightChild != null) {
                        queue.add(currentNode.leftChild.rightChild);
                    }
                }

                if (queue.peek() == null) {
                    queue.add(null);
                }
            }
        }
    }
}

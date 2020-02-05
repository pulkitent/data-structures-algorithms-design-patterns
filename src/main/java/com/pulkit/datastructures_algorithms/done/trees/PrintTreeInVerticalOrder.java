package com.pulkit.datastructures_algorithms.done.trees;

import java.util.*;

/*

Test case
         1
      2     3
     4 5  6   7
             8 9

expected output
4
2
1 5 6
3 8
7
9
*/

//TODO: Print order needs to be corrected
public class PrintTreeInVerticalOrder {
    private static final Map<Integer, List<TreeNode>> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        printVertically(root, 0);

        int maxDepth = 3;

        for (Integer index = 0; index <= maxDepth; index++) {
            if (map.containsKey(index)) {
                List<TreeNode> nodeList = map.get(index);
                for (TreeNode node : nodeList) {
                    System.out.print(node.data + " ");
                }
                System.out.println(" ");
            }
        }

        for (Integer index = -maxDepth; index < 0; index++) {
            if (map.containsKey(index)) {
                List<TreeNode> nodeList = map.get(index);
                for (TreeNode node : nodeList) {
                    System.out.print(node.data + " ");
                }
                System.out.println(" ");
            }
        }
    }

    static void printVertically(TreeNode root, int level) {
        if (root == null)
            return;

        if (map.containsKey(level)) {
            map.get(level).add(root);
        } else {
            List<TreeNode> tempNode = new LinkedList<>();
            tempNode.add(root);
            map.put(level, tempNode);
        }

        printVertically(root.leftChild, level + 1);
        printVertically(root.rightChild, level - 1);
    }

    private static TreeNode createBinaryTree() {
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode seven = new TreeNode(7, eight, nine);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode five = new TreeNode(5, null, null);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode three = new TreeNode(3, six, seven);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode root = new TreeNode(1, two, three);

        return root;
    }
}
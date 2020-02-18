package com.pulkit.datastructures_algorithms.done.trees;

import java.util.*;

/*
Test case :
           1
    2             3
 4     5      6      7
8 9  10 11  12 13  14 15

*/
public class LeftViewOfBinaryTree {
    public static void main(String[] args) {
        Map<Integer, List<TreeNode>> levelTreeMap = new HashMap<>();
        //Expected Output - 1 2 4 8
        TreeNode root = createBinaryTree();

        //Expected Output - 1 2 5 11
        //TreeNode root = createSpecificBinaryTree();

        computeLeftView(root, levelTreeMap, 0);
        printLeftView(levelTreeMap);
    }

    private static void computeLeftView(TreeNode node, Map<Integer, List<TreeNode>> levelTreeMap, int level) {
        if (node == null)
            return;

        if (levelTreeMap.containsKey(level)) {
            List<TreeNode> nodeList = levelTreeMap.get(level);
            nodeList.add(node);
        } else {
            List<TreeNode> nodeList = new LinkedList<>();
            nodeList.add(node);
            levelTreeMap.put(level, nodeList);
        }

        if (node.leftChild != null) {
            computeLeftView(node.leftChild, levelTreeMap, level + 1);
        }

        if (node.rightChild != null) {
            computeLeftView(node.rightChild, levelTreeMap, level + 1);
        }
    }

    private static TreeNode createBinaryTree() {
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

        return root;
    }

    private static TreeNode createSpecificBinaryTree() {
        TreeNode eleven = new TreeNode(11, null, null);
        TreeNode five = new TreeNode(5, null, eleven);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode two = new TreeNode(2, null, five);
        TreeNode root = new TreeNode(1, two, three);

        return root;
    }

    private static void printLeftView(Map<Integer, List<TreeNode>> levelTreeMap) {
        Set<Integer> keys = levelTreeMap.keySet();

        for (Integer key : keys) {
            List<TreeNode> keySpecificList = levelTreeMap.get(key);
            TreeNode firstTreeNodeInList = keySpecificList.get(0);
            System.out.print(firstTreeNodeInList.data + " ");
        }
    }
}
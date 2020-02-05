package com.pulkit.datastructures_algorithms.done.trees;

import java.util.*;


//TODO: Just Write a simple method to print first node of every Linkedlist in Hashmap
public class PrintLeftViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        HashMap<Integer, List<TreeNode>> map = new HashMap<>();

        generateLeftView(root, map, 0);
        Set<Integer> levelKeys = map.keySet();

        printLevelOrderTraversal(map, levelKeys);
    }

    static void generateLeftView(TreeNode root, Map<Integer, List<TreeNode>> map, int level) {
        if (root == null)
            return;

        if (map.containsKey(level)) {
            map.get(level).add(root);
        } else {
            List<TreeNode> listNode = new LinkedList<>();
            listNode.add(root);
            map.put(level, listNode);
        }

        generateLeftView(root.leftChild, map, level + 1);
        generateLeftView(root.rightChild, map, level + 1);
    }

    private static void printLevelOrderTraversal(HashMap<Integer, List<TreeNode>> map, Set<Integer> levelKeys) {
        System.out.println("Printing Level Order Traversal");

        for (Integer level : levelKeys) {
            List<TreeNode> nodesAtParticularLevel = map.get(level);

            for (TreeNode node : nodesAtParticularLevel) {
                System.out.print(node.data + " ");
            }
            System.out.println(" ");
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
}
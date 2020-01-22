package com.pulkit.datastructures_algorithms.todo;

import com.pulkit.datastructures_algorithms.done.trees.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
Test case :
           1
    2             3
 4     5      6      7
8 9  10 11  12 13  14 15

*/

/*
    Serialized list -
     1 2 4 8 NN NN 9 NN NN 5 10 NN NN 11 NN NN 3 6 12 NN NN 13 NN NN 7 14 NN NN 15 NN NN
*/

public class SerializeAndDeserializeBinaryTree {
    private static final TreeNode NULL_NODE = new TreeNode(Integer.MAX_VALUE, null, null);


    public static void main(String[] args) {
        TreeNode root = createBinaryTree();

        List<TreeNode> serializedTree = serializeBinaryTree(root, new LinkedList<>());

        printSerializedList(serializedTree);

    }

    private static void printSerializedList(List<TreeNode> serializedTree) {
        for (TreeNode treeNode : serializedTree) {
            System.out.print(" " + treeNode.data);
        }
    }

    private static void deSerializeBinaryTree(TreeNode node, List<TreeNode> preOrderList) {
        if (node == null)
            return;

        int i = 1;

        while (!preOrderList.isEmpty()) {
            TreeNode treeNode = preOrderList.get(i);

            if (treeNode.equals(NULL_NODE)) {
                node.rightChild = null;
                node.leftChild = null;
            }

            node.leftChild = treeNode;
            node = node.leftChild;
            preOrderList.remove(i);
            i++;
        }
    }

    private static List<TreeNode> serializeBinaryTree(TreeNode root, List<TreeNode> preOrderList) {
        if (root == null) {
            return preOrderList;
        }

        preOrderList.add(root);

        if (root.leftChild == null) {
            preOrderList.add(NULL_NODE);
        }

        if (root.rightChild == null) {
            preOrderList.add(NULL_NODE);
        }

        serializeBinaryTree(root.leftChild, preOrderList);
        serializeBinaryTree(root.rightChild, preOrderList);

        return preOrderList;
    }

    private static void destroyTree(List<TreeNode> preOrderList) {
        for (TreeNode node : preOrderList) {
            if (node != null) {
                node.leftChild = null;
                node.rightChild = null;
            }
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
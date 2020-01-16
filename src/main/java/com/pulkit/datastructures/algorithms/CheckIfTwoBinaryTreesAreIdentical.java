package com.pulkit.DsAlgo;

public class CheckIfTwoBinaryTreesAreIdentical {
    public static void main(String[] args) {
        firstTestCase();
        secondTestCase();
        thirdTestCase();
    }

    private static void thirdTestCase() {
        TreeNode node3 = createBinaryTree();
        TreeNode node4 = createAnotherDifferentBinaryTree();
        System.out.println(checkIfIdentical(node3, node4));
    }

    private static void secondTestCase() {
        TreeNode node1 = createBinaryTree();
        TreeNode node2 = createBinaryTree();
        System.out.println(checkIfIdentical(node1, node2));
    }

    private static void firstTestCase() {
        TreeNode node = createBinaryTree();
        System.out.println(checkIfIdentical(node, node));
    }

    private static boolean checkIfIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        return node1.data == node2.data
                && checkIfIdentical(node1.leftChild, node2.leftChild)
                && checkIfIdentical(node1.rightChild, node2.rightChild);
    }

    private static TreeNode createAnotherDifferentBinaryTree() {
        TreeNode sixteen = new TreeNode(16, null, null);
        TreeNode fourteen = new TreeNode(14, null, null);
        TreeNode thirteen = new TreeNode(13, null, null);
        TreeNode twelve = new TreeNode(12, null, null);
        TreeNode eleven = new TreeNode(11, null, null);
        TreeNode ten = new TreeNode(10, null, null);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode seven = new TreeNode(7, fourteen, sixteen);
        TreeNode six = new TreeNode(6, twelve, thirteen);
        TreeNode five = new TreeNode(5, ten, eleven);
        TreeNode four = new TreeNode(4, eight, nine);
        TreeNode three = new TreeNode(3, six, seven);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode root = new TreeNode(1, two, three);

        return root;
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
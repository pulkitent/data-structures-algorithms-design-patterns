package com.pulkit.datastructures_algorithms.done.trees;

/*

Test case :
           1
    2             3
 4     5      6      7
8 9  10 11  12 13  14 15

Max sum = 44 (11 + 5 + 2 + 1 + 3 + 7 + 15)
*/

public class MaximumSumPathBetweenAnyTwoNode {
    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        Integer sum = findSum(root);

        System.out.println(sum);
    }

    static Integer findSum(TreeNode node) {
        if (node == null)
            return 0;

        int leftSubtreePath = findMaxSumFromNodeToLeaf(node.leftChild);
        int rightSubtreePath = findMaxSumFromNodeToLeaf(node.rightChild);

        int firstPossibility = node.data + leftSubtreePath + rightSubtreePath;
        int possibleMax = Math.max(findSum(node.rightChild), firstPossibility);

        return Math.max(findSum(node.leftChild), possibleMax);
    }

    private static Integer findMaxSumFromNodeToLeaf(TreeNode node) {
        if (node == null)
            return 0;

        int leftSubtreeSum = findMaxSumFromNodeToLeaf(node.leftChild);
        int rightSubtreeSum = findMaxSumFromNodeToLeaf(node.rightChild);

        return Math.max(leftSubtreeSum + node.data, rightSubtreeSum + node.data);
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
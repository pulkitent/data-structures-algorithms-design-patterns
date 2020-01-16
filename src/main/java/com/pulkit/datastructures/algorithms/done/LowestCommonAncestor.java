package com.pulkit.datastructures.algorithms.done;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        int expectedOutput1 = 1;
        int nodeData1 = 1;
        int anotherNodeData1 = 15;
        testCase(nodeData1, anotherNodeData1, expectedOutput1);

        int expectedOutput2 = 1;
        int nodeData2 = 8;
        int anotherNodeData2 = 15;
        testCase(nodeData2, anotherNodeData2, expectedOutput2);

        int expectedOutput3 = 1;
        int nodeData3 = 11;
        int anotherNodeData3 = 12;
        testCase(nodeData3, anotherNodeData3, expectedOutput3);
    }

    private static TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null)
            return null;

        if (root.data == a || root.data == b)
            return root;

        TreeNode leftSubTreeLCA = findLCA(root.leftChild, a, b);
        TreeNode rightSubTreeLCA = findLCA(root.rightChild, a, b);

        if (leftSubTreeLCA != null && rightSubTreeLCA != null)
            return root;

        return leftSubTreeLCA != null ? leftSubTreeLCA : rightSubTreeLCA;
    }

    private static TreeNode createBST() {
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

    private static void testCase(int nodedata1, int nodeData2, int expectedOutput) {
        TreeNode bstRoot = createBST();
        TreeNode resultNode = findLCA(bstRoot, nodedata1, nodeData2);
        if (resultNode == null) {
            System.out.println("Test failed - Null node");
            return;
        }

        if (resultNode.data != expectedOutput) {
            System.out.println("Test failed and now printing mismatch");
            System.out.println("Resultant node's data " + resultNode.data);
            System.out.println("Expected data " + expectedOutput);
            return;
        }
        System.out.println("Test passed");
    }
}
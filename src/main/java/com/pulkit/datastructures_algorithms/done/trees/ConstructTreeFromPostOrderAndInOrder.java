package com.pulkit.datastructures_algorithms.done.trees;

public class ConstructTreeFromPostOrderAndInOrder {
    public static void main(String[] args) {
        int inOrder[] = {2, 1, 3};
        int postOrder[] = {2, 3, 1};

        TreeNodee root = createTree(postOrder, inOrder);
    }

    static TreeNodee createTree(int postOrder[], int inOrder[]) {
        int inOrderLength = inOrder.length - 1;
        int postOrderLength = postOrder.length - 1;

        return createTreeUtil(postOrder, 0, postOrderLength,
                inOrder, 0, inOrderLength);
    }

    static TreeNodee createTreeUtil(int postOrder[], int postLow, int postHigh,
                                    int inOrder[], int inLow, int inHigh) {
        if (inLow == inHigh)
            return new TreeNodee(inOrder[inLow]);

        if (inLow > inHigh || postLow > postHigh)
            return null;

        int elementInPostOrder = postOrder[postHigh];
        int elementPositionInInOrder = findElementInInOrder(elementInPostOrder, inOrder);

        TreeNodee root = new TreeNodee(elementInPostOrder);

        TreeNodee leftSubTree = createTreeUtil(postOrder, postLow, postHigh - 1,
                inOrder, inLow, elementPositionInInOrder - 1);
        TreeNodee rightSubTree = createTreeUtil(postOrder, postLow, postHigh - 1,
                inOrder, elementPositionInInOrder + 1, inHigh);

        root.leftChild = leftSubTree;
        root.rightChild = rightSubTree;

        return root;
    }

    static int findElementInInOrder(int element, int postOrder[]) {
        for (int index = 0; index < postOrder.length; index++) {
            if (postOrder[index] == element)
                return index;
        }
        return -1;
    }
}

class TreeNodee {
    Integer data;

    TreeNodee leftChild;
    TreeNodee rightChild;

    public TreeNodee(Integer data, TreeNodee leftChild, TreeNodee rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNodee(Integer data) {
        this.data = data;
    }
}
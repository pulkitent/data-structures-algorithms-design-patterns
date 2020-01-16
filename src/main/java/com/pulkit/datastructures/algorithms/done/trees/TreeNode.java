package com.pulkit.datastructures.algorithms.done.trees;

import java.util.Objects;

public class TreeNode {
    public int data;
    int level = 0;
    public TreeNode leftChild;
    public TreeNode rightChild;

    boolean isVisited = false;

    public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return data == treeNode.data &&
                level == treeNode.level &&
                isVisited == treeNode.isVisited &&
                Objects.equals(leftChild, treeNode.leftChild) &&
                Objects.equals(rightChild, treeNode.rightChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, level, leftChild, rightChild, isVisited);
    }
}

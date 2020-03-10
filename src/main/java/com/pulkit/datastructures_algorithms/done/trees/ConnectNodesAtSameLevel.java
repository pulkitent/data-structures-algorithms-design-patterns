package com.pulkit.datastructures_algorithms.done.trees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

//TODO: To be fixed
public class ConnectNodesAtSameLevel {
    private final static TreeNodeWithExtraPointer DELIMITTER = new TreeNodeWithExtraPointer();

    public static void main(String[] args) {
        TreeNodeWithExtraPointer root = createTreeWithExtraPointer();
        Queue<TreeNodeWithExtraPointer> siblingsQueue = connect(root);

        TreeNodeWithExtraPointer anotherRoot = createTreeWithExtraPointer();
        connectV2(anotherRoot);
    }

    static Queue<TreeNodeWithExtraPointer> connect(TreeNodeWithExtraPointer node) {
        Queue<TreeNodeWithExtraPointer> siblingsQueue = new LinkedList<>();

        if (node == null) {
            return siblingsQueue;
        }

        Queue<TreeNodeWithExtraPointer> queue = new LinkedList<>();
        queue.add(node);
        queue.add(DELIMITTER);

        siblingsQueue.add(node);
        siblingsQueue.add(DELIMITTER);

        while (!queue.isEmpty()) {
            TreeNodeWithExtraPointer peek = queue.remove();

            if (peek.leftChild != null) {
                queue.add(peek.leftChild);
                siblingsQueue.add(peek.leftChild);
            }

            if (peek.rightChild != null) {
                queue.add(peek.rightChild);
                siblingsQueue.add(peek.rightChild);
            }
            siblingsQueue.add(DELIMITTER);
        }

        return siblingsQueue;
    }

    static void connectV2(TreeNodeWithExtraPointer node) {
        if (node == null)
            return;

        Queue<TreeNodeWithExtraPointer> queue = new LinkedList<>();
        queue.add(node);
        queue.add(DELIMITTER);

        TreeNodeWithExtraPointer previous = null;
        TreeNodeWithExtraPointer current = null;

        while (!queue.isEmpty()) {
            TreeNodeWithExtraPointer peek = queue.remove();
            current = peek;
            if (!peek.equals(DELIMITTER)) {
                if (previous != null) {
                    previous.sameLevelSibling = current;
                }
                if (peek.leftChild != null) {
                    TreeNodeWithExtraPointer leftChild = peek.leftChild;
                    queue.add(leftChild);
                }
                if (peek.rightChild != null) {
                    TreeNodeWithExtraPointer rightChild = peek.rightChild;
                    queue.add(rightChild);
                }
                previous = current;
            } else {
                if (!queue.isEmpty()) {
                    queue.add(DELIMITTER);
                }
                previous = null;
            }
        }
    }

    private static TreeNodeWithExtraPointer createTreeWithExtraPointer() {
        TreeNodeWithExtraPointer fifteen = new TreeNodeWithExtraPointer(15, null, null);
        TreeNodeWithExtraPointer fourteen = new TreeNodeWithExtraPointer(14, null, null);
        TreeNodeWithExtraPointer thirteen = new TreeNodeWithExtraPointer(13, null, null);
        TreeNodeWithExtraPointer twelve = new TreeNodeWithExtraPointer(12, null, null);
        TreeNodeWithExtraPointer eleven = new TreeNodeWithExtraPointer(11, null, null);
        TreeNodeWithExtraPointer ten = new TreeNodeWithExtraPointer(10, null, null);
        TreeNodeWithExtraPointer nine = new TreeNodeWithExtraPointer(9, null, null);
        TreeNodeWithExtraPointer eight = new TreeNodeWithExtraPointer(8, null, null);

        TreeNodeWithExtraPointer seven = new TreeNodeWithExtraPointer(7, fourteen, fifteen);
        TreeNodeWithExtraPointer six = new TreeNodeWithExtraPointer(6, twelve, thirteen);
        TreeNodeWithExtraPointer five = new TreeNodeWithExtraPointer(5, ten, eleven);
        TreeNodeWithExtraPointer four = new TreeNodeWithExtraPointer(4, eight, nine);

        TreeNodeWithExtraPointer three = new TreeNodeWithExtraPointer(3, six, seven);
        TreeNodeWithExtraPointer two = new TreeNodeWithExtraPointer(2, four, five);

        return new TreeNodeWithExtraPointer(1, two, three);
    }
}

class TreeNodeWithExtraPointer {
    public Integer data;
    public TreeNodeWithExtraPointer leftChild;
    public TreeNodeWithExtraPointer rightChild;
    public TreeNodeWithExtraPointer sameLevelSibling;

    TreeNodeWithExtraPointer(int data, TreeNodeWithExtraPointer leftChild,
                             TreeNodeWithExtraPointer rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    TreeNodeWithExtraPointer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNodeWithExtraPointer that = (TreeNodeWithExtraPointer) o;
        return data == that.data &&
                leftChild.equals(that.leftChild) &&
                rightChild.equals(that.rightChild) &&
                sameLevelSibling.equals(that.sameLevelSibling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, leftChild, rightChild, sameLevelSibling);
    }

    @Override
    public String toString() {
        return "data = " + data;
    }
}
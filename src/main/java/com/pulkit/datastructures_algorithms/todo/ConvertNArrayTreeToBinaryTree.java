package com.pulkit.datastructures_algorithms.todo;

import java.util.ArrayList;
import java.util.List;

public class ConvertNArrayTreeToBinaryTree {
    public static void main(String[] args) {

    }

    private static void convert(NArrayTreeNode node) {
        if (node == null)
            return;

        List<NArrayTreeNode> childNodes = node.childNodes;
        NArrayTreeNode currentNode = node;

        for (NArrayTreeNode childNode : childNodes) {
            if (currentNode != null) {
                currentNode.leftChildNode = childNode;
                currentNode = childNode;
            }
        }
        node.childNodes = null;
    }
}

class NArrayTreeNode {
    int data;
    List<NArrayTreeNode> childNodes = new ArrayList<>();
    NArrayTreeNode leftChildNode;
    NArrayTreeNode rightChildNode;

    public NArrayTreeNode(int data) {
        this.data = data;
    }
}
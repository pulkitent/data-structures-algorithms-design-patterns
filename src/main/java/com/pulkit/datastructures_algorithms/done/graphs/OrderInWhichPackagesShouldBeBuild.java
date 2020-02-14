package com.pulkit.datastructures_algorithms.done.graphs;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import static java.util.Arrays.asList;

public class OrderInWhichPackagesShouldBeBuild {
    public static void main(String[] args) {
        List<GraphNode> graphNodes = createDependencyGraph();
        Stack<GraphNode> dependencyOrder = getDependencyOrder(graphNodes);
    }

    static Stack<GraphNode> getDependencyOrder(List<GraphNode> nodes) {
        HashSet<GraphNode> visited = new HashSet<>();
        Stack<GraphNode> stack = new Stack();

        for (GraphNode node : nodes) {
            if (!visited.contains(node)) {
                doDFS(node, visited, stack);
            }
        }

        return stack;
    }

    private static void doDFS(GraphNode node, HashSet<GraphNode> visited, Stack<GraphNode> stack) {
        if (visited.contains(node))
            return;

        List<GraphNode> connectedNodes = node.connectedNodes;

        if (connectedNodes != null) {
            for (GraphNode connectedNode : connectedNodes) {
                if (!visited.contains(connectedNode)) {
                    doDFS(connectedNode, visited, stack);
                }
            }
        }

        stack.push(node);
        visited.add(node);
    }

    private static List<GraphNode> createDependencyGraph() {
        GraphNode node6 = new GraphNode(99);
        GraphNode node5 = new GraphNode(100);

        GraphNode node4 = new GraphNode(50);
        List<GraphNode> list4 = Collections.singletonList(node4);
        node6.setConnectedNodes(list4);
        node5.setConnectedNodes(list4);

        GraphNode node3 = new GraphNode(30);
        List<GraphNode> list3 = Collections.singletonList(node3);
        node4.setConnectedNodes(list3);

        GraphNode node2 = new GraphNode(20);
        List<GraphNode> list2 = Collections.singletonList(node2);
        node3.setConnectedNodes(list2);

        GraphNode node1 = new GraphNode(19);
        List<GraphNode> list1 = Collections.singletonList(node1);
        node2.setConnectedNodes(list1);

        GraphNode node0 = new GraphNode(0);
        List<GraphNode> list0 = Collections.singletonList(node0);
        node1.setConnectedNodes(list0);

        List<GraphNode> nodes = asList(node0, node2, node1, node3, node4, node5, node6);
        return nodes;
    }
}
package com.pulkit.datastructures.algorithms.done;

import java.util.*;

import static java.util.Arrays.asList;

public class TopologicalSort {
    public static void main(String[] args) {
        List<GraphNode> graphList = createGraphNodes();
        topologicalSortingUtil(graphList);
    }

    private static void topologicalSortingUtil(List<GraphNode> graphNodesList) {
        Set<GraphNode> visitedNodes = new HashSet<>();
        Stack<GraphNode> topologicalSortStack = new Stack<>();

        for (GraphNode node : graphNodesList) {
            if (!visitedNodes.contains(node)) {
                visitedNodes.add(node);
                doTopologicalSorting(node, visitedNodes, topologicalSortStack);
                topologicalSortStack.push(node);
            }
        }
    }

    private static void doTopologicalSorting(GraphNode graph, Set<GraphNode> visitedNodes,
                                             Stack<GraphNode> topologicalSortStack) {
        if (graph == null)
            return;

        List<GraphNode> connectedNodes = graph.connectedNodes;

        if (connectedNodes == null) {
            return;
        }

        for (GraphNode currentGraphNode : connectedNodes) {
            if (!visitedNodes.contains(currentGraphNode)) {
                visitedNodes.add(currentGraphNode);
                doTopologicalSorting(currentGraphNode, visitedNodes, topologicalSortStack);
                topologicalSortStack.push(currentGraphNode);
            }
        }
    }

    private static List<GraphNode> createGraphNodes() {
        GraphNode graphNode0 = new GraphNode(0);
        GraphNode graphNode1 = new GraphNode(1);
        GraphNode graphNode2 = new GraphNode(2);
        GraphNode graphNode3 = new GraphNode(3);
        GraphNode graphNode4 = new GraphNode(4);
        GraphNode graphNode5 = new GraphNode(5);

        List<GraphNode> graphList = asList(graphNode0, graphNode1, graphNode2,
                graphNode3, graphNode4, graphNode5);

        graphNode2.connectedNodes = Collections.singletonList(graphNode3);
        graphNode3.connectedNodes = Collections.singletonList(graphNode1);
        graphNode4.connectedNodes = asList(graphNode0, graphNode1);
        graphNode5.connectedNodes = asList(graphNode0, graphNode2);

        return graphList;
    }
}
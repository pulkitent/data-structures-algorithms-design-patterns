package com.pulkit.datastructures_algorithms.todo;

import com.pulkit.datastructures_algorithms.done.graphs.GraphNode;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class DjikstrasAlgorithm {
    public static void main(String[] args) {

    }

    private static void calculateShortestPath() {

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
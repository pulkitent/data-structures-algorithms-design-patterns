package com.pulkit.datastructures_algorithms.done.graphs;

import java.util.List;
import java.util.Objects;

public class GraphNode {
    int data;
    public List<GraphNode> connectedNodes;

    public GraphNode(int data) {
        this.data = data;
    }

    void setConnectedNodes(List<GraphNode> connectedNodes) {
        this.connectedNodes = connectedNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode node1 = (GraphNode) o;
        return data == node1.data &&
                Objects.equals(connectedNodes, node1.connectedNodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, connectedNodes);
    }
}

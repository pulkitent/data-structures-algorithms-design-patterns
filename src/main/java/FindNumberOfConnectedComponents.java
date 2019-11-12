import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FindNumberOfConnectedComponents {
    public static void main(String[] args) {
        //Another Test case : Expected Output - 3
        //List<GraphNode> allNodesList = createGraphWithThreeConnectedComponents();

        //Another Test case : Expected Output - 1
        List<GraphNode> allNodesList = createGraphWithOneConnectedComponents();
        HashSet<GraphNode> visitedNodes = new HashSet<>();

        int count = 0;

        for (GraphNode node : allNodesList) {
            if (!visitedNodes.contains(node)) {
                doDepthFirstSearch(node, visitedNodes);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void doDepthFirstSearch(GraphNode node, HashSet<GraphNode> visited) {
        if (node == null)
            return;

        if (visited.contains(node))
            return;

        visited.add(node);

        List<GraphNode> connectedNodes = node.connectedNodes;

        for (GraphNode connectedNode : connectedNodes) {
            visited.add(connectedNode);
            doDepthFirstSearch(connectedNode, visited);
        }
    }

    private static List<GraphNode> createGraphWithOneConnectedComponents() {
        GraphNode startingNode = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);
        GraphNode node8 = new GraphNode(8);

        List<GraphNode> allNodesList = new LinkedList<>();
        allNodesList.add(startingNode);
        allNodesList.add(node2);
        allNodesList.add(node3);
        allNodesList.add(node4);
        allNodesList.add(node5);
        allNodesList.add(node6);
        allNodesList.add(node7);
        allNodesList.add(node8);

        List<GraphNode> firstConnectedNodes = new LinkedList<>();
        firstConnectedNodes.add(node2);
        firstConnectedNodes.add(node3);
        firstConnectedNodes.add(node4);
        firstConnectedNodes.add(node5);
        firstConnectedNodes.add(node6);
        firstConnectedNodes.add(node7);
        firstConnectedNodes.add(node8);
        startingNode.setConnectedNodes(firstConnectedNodes);

        return allNodesList;
    }


    private static List<GraphNode> createGraphWithThreeConnectedComponents() {
        GraphNode startingNode = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);
        GraphNode node8 = new GraphNode(8);

        List<GraphNode> allNodesList = new LinkedList<>();
        allNodesList.add(startingNode);
        allNodesList.add(node2);
        allNodesList.add(node3);
        allNodesList.add(node4);
        allNodesList.add(node5);
        allNodesList.add(node6);
        allNodesList.add(node7);
        allNodesList.add(node8);

        List<GraphNode> firstConnectedNodes = new LinkedList<>();
        firstConnectedNodes.add(node2);
        startingNode.setConnectedNodes(firstConnectedNodes);

        List<GraphNode> secondConnectedNodes = new LinkedList<>();
        secondConnectedNodes.add(node4);
        node3.setConnectedNodes(secondConnectedNodes);

        List<GraphNode> thirdConnectedNodes = new LinkedList<>();
        secondConnectedNodes.add(node6);
        secondConnectedNodes.add(node7);
        secondConnectedNodes.add(node8);
        node5.setConnectedNodes(thirdConnectedNodes);

        return allNodesList;
    }
}

class GraphNode {
    int data;
    List<GraphNode> connectedNodes;

    GraphNode(int data) {
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
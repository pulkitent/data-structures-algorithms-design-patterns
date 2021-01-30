package com.mckinsey.engage.risk;

//public class CheapKFlights {
//    public static void main(String[] args) {
//        int n = 3;
//        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
//        int src = 0;
//        int dst = 2;
//        int k = 1;
//
//        Map<Integer, List<NodeWithCost>> graph = convertMatrixToList(edges);
//
//        int cheapestPrice = getCheapestPrice(src, dst, k, graph, new HashSet<>(),
//                0, 0);
//
//        System.out.println(cheapestPrice);
//    }
//
//    static int getCheapestPrice(int src, int dst, int allowedStops, Map<Integer,
//            List<NodeWithCost>> graph, Set<Integer> visited, int currentStops, int cost) {
//
//        if (src == dst) {
//            currentStops--;
//            return cost;
//        }
//
//        if ((currentStops > allowedStops) || visited.contains(src))
//            return Integer.MAX_VALUE;
//
//        visited.add(src);
//
//        List<NodeWithCost> neighboursWithCost = graph.get(src);
//        int cheapestPrice = Integer.MAX_VALUE;
//
//        for (NodeWithCost neighbourWithCost : neighboursWithCost) {
//            cheapestPrice = Math.min(cheapestPrice, getCheapestPrice(neighbourWithCost.getNode(),
//                    dst, allowedStops, graph, visited, currentStops + 1,
//                    cost + neighbourWithCost.getCost()));
//        }
//
//        return cheapestPrice;
//    }
//
//
//    static Map<Integer, List<NodeWithCost>> convertMatrixToList(int[][] edges) {
//        Map<Integer, List<NodeWithCost>> graph = new HashMap<>();
//
//        for (int[] edge : edges) {
//            if (graph.containsKey(edge[0])) {
//                graph.get(edge[0]).add(new NodeWithCost(edge[1], edge[2]));
//            } else {
//                LinkedList<NodeWithCost> neighboursWithCost = new LinkedList<>();
//                neighboursWithCost.add(new NodeWithCost(edge[1], edge[2]));
//                graph.put(edge[0], neighboursWithCost);
//            }
//        }
//
//        return graph;
//    }
//}
//
//class NodeWithCost {
//    Integer node;
//    Integer Cost;
//
//    public NodeWithCost(Integer node, Integer cost) {
//        this.node = node;
//        Cost = cost;
//    }
//
//    public Integer getNode() {
//        return node;
//    }
//
//    public Integer getCost() {
//        return Cost;
//    }
//}




/*

 0-->3
 |   |
 V   V
 4-->1-->2
 A   |
 |   |
  ---V


 */


import java.util.*;

class CheapKFlights {
    public static void main(String s[]) {
        int n = 5;
        int[][] flights = {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};
        int src = 2;
        int dst = 1;
        int K = 1;

        Map<Integer, List<NodeWithCost>> graph = convertMatrixToList(flights);

        int cheapestPrice = getCheapestPrice(src, dst, K, graph, new HashSet<>(), 0, 0);

        System.out.println(cheapestPrice);
    }

    static int getCheapestPrice(int src, int dst, int allowedStops, Map<Integer,
            List<NodeWithCost>> graph, Set<Integer> visited, int currentStops, int cost) {

        if ((currentStops > allowedStops) || visited.contains(src))
            return Integer.MAX_VALUE;

        if (src == dst) {
            currentStops--;
            return cost;
        }

        visited.add(src);

        List<NodeWithCost> neighboursWithCost = graph.get(src);
        int cheapestPrice = Integer.MAX_VALUE;

        if (neighboursWithCost != null) {
            for (NodeWithCost neighbourWithCost : neighboursWithCost) {
                cheapestPrice = Math.min(cheapestPrice, getCheapestPrice(neighbourWithCost.getNode(),
                        dst, allowedStops, graph, visited, currentStops + 1,
                        cost + neighbourWithCost.getCost()));
            }
            visited.remove(src);
        } else {
            return 0;
        }

        return cheapestPrice;
    }

    static Map<Integer, List<NodeWithCost>> convertMatrixToList(int[][] edges) {
        Map<Integer, List<NodeWithCost>> graph = new HashMap<>();

        for (int[] edge : edges) {
            if (graph.containsKey(edge[0])) {
                graph.get(edge[0]).add(new NodeWithCost(edge[1], edge[2]));
            } else {
                List<NodeWithCost> neighboursWithCost = new LinkedList<>();
                neighboursWithCost.add(new NodeWithCost(edge[1], edge[2]));
                graph.put(edge[0], neighboursWithCost);
            }
        }

        return graph;
    }

    private static class NodeWithCost {
        Integer node;
        Integer cost;

        public NodeWithCost(Integer node, Integer cost) {
            this.node = node;
            this.cost = cost;
        }

        public Integer getNode() {
            return node;
        }

        public Integer getCost() {
            return cost;
        }
    }
}

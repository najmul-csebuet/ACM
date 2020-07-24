package Algorithm.Graph;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class ShortestPathUsingBFS {

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i)) {
                allPassed = false;
                out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        out.println(allPassed ? "All Test Cases Passed!" : "");
    }

    public static void main(String[] args) throws IOException {

        ShortestPathUsingBFS s = new ShortestPathUsingBFS();
        ArrayList<Boolean> l = new ArrayList<>();

        int[][] edges = { {1, 2}, {1, 3}, {2, 3}, {3, 4}, {4, 5}};

        l.add(s.solution(edges, 5, 1, 5) == 3);
        l.add(s.solution(edges, 5, 1, 3) == 1);
        l.add(s.solution(edges, 5, 4, 1) == 2);

        checkTestCases(l);
    }

    public int solution(int[][] edges, int nodeCount, int source, int dest) {
        Graph graph = new Graph(edges, nodeCount);
        return graph.getShortestPathLength(source, dest);
    }

    static class Node {

        int label = 0;
        int dist = Integer.MAX_VALUE;
        boolean visited = false;

        Node(int label) {
            this.label = label;
        }
    }

    static class Graph  {

        Map<Integer, Node> nodeMap = new HashMap<>();

        //Adj List
        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

        Graph(int[][] edges, int nodeCount) {

            for (int i = 0; i <= nodeCount; i++) {
                adjList.add(new ArrayList<>());
            }

            for(int[] edge: edges) {
                adjList.get(edge[0]).add(getNode(edge[1]));
                adjList.get(edge[1]).add(getNode(edge[0]));
            }
        }

        private Node getNode(int nodeLabel) {

            if (nodeMap.containsKey(nodeLabel)) {
                return nodeMap.get(nodeLabel);
            }

            Node node = new Node(nodeLabel);
            nodeMap.put(nodeLabel, node);

            return node;
        }

        public int getShortestPathLength(int source, int dest) {
            Node sourceNode = getNode(source);
            Node destNode = getNode(dest);
            return 0;
        }
    }
}
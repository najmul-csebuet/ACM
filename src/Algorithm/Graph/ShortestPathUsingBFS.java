package Algorithm.Graph;

import java.io.IOException;
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

        int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {4, 5}};

        l.add(s.solution(edges, 1, 5).size() - 1 == 3);
        l.add(s.solution(edges, 1, 3).size() - 1 == 1);
        l.add(s.solution(edges, 4, 1).size() - 1 == 2);

        checkTestCases(l);
    }

    public List<Integer> solution(int[][] edges, int source, int dest) {
        Graph graph = new Graph(edges);
        return graph.getShortestPathLength(source, dest);
    }

    static class Node {

        int parent = -1;
        int label = 0;
        int dist = Integer.MAX_VALUE;
        String state = "White";

        Node(int label) {
            this.label = label;
        }
    }

    static class Graph {

        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, ArrayList<Node>> adjList = new HashMap<>();

        Graph(int[][] edges) {

            //Initialize
            for (int[] edge : edges) {
                for (int a : edge) {
                    if (!adjList.containsKey(a)) {
                        adjList.put(a, new ArrayList<>());
                    }
                    if (!nodeMap.containsKey(a)) {
                        nodeMap.put(a, new Node(a));
                    }
                }
            }

            for (int[] edge : edges) {
                adjList.get(edge[0]).add(getNode(edge[1]));
                adjList.get(edge[1]).add(getNode(edge[0]));
            }
        }

        private Node getNode(int nodeLabel) {
            return nodeMap.get(nodeLabel);
        }

        public List<Integer> getShortestPathLength(int source, int dest) {

            Node sourceNode = getNode(source);
            sourceNode.state = "Grey";
            sourceNode.dist = 0;

            Queue<Node> queue = new ArrayDeque<>();
            queue.add(sourceNode);

            while (!queue.isEmpty()) {

                Node currentNode = queue.poll();
                currentNode.state = "Black";

                ArrayList<Node> childNodes = adjList.get(currentNode.label);
                for (int i = 0; i < childNodes.size(); i++) {
                    Node childNode = childNodes.get(i);
                    if (childNode.state.equals("White")) {
                        childNode.dist = currentNode.dist + 1;
                        childNode.parent = currentNode.label;
                        childNode.state = "Grey";
                        queue.add(childNode);
                    }
                }
            }

            Node destNode = getNode(dest);
            List<Integer> list = new ArrayList<>();

            list.add(destNode.label);
            while (destNode.parent != -1) {
                list.add(destNode.parent);
                destNode = getNode(destNode.parent);
            }

            Collections.reverse(list);

            return list;
        }

    }
}
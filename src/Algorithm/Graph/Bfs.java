package Algorithm.Graph;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Bfs {

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

        Bfs s = new Bfs();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution(new int[]{1,2,3}, new int[]{2,3,4}) == 0);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    public int solution(int[] A, int[] B) {

        Graph graph = new Graph(A, B);
        ArrayList<Integer> path = graph.getShortestPath(1, 5);

        return 0;
    }

    class Graph {

        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

        Graph(int[] A, int[] B) {

            for (int i = 0; i < A.length; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < A.length; i++) {
                adjList.get(A[i]).add(new Node(B[i]));
            }
        }

        public ArrayList<Integer> getShortestPath(int s, int d) {

            Queue<Node> nodeQueue = new LinkedList<>();
            Node source = new Node(s);
            Node destination = new Node(d);
            return null;
        }
    }

    class Node{

        public boolean visited;
        public int label;
        //other fields

        public Node(int data){
            this.visited = false;
            this.label = data;
        }
    }
}
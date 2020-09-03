package Algorithm.Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Graph {

    //We are assuming 0,1,2,3,4 named vertices
    private final ArrayList<ArrayList<Integer>> adjList;

    Graph(ArrayList<ArrayList<Integer>> adjList) {
        this.adjList = adjList;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        var N = sc.nextInt();
        var M = sc.nextInt();

        var adjList = new ArrayList<ArrayList<Integer>>(N);
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        while (M-- > 0) {
            var a = sc.nextInt() - 1;
            var b = sc.nextInt() - 1;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        var graph = new Graph(adjList);

        boolean connected = graph.isConnected();
        System.out.println("Is graph connected: " + connected);

        var count = graph.countComponent();
        System.out.println("Connected Component: " + count);
    }

    public boolean isConnected() {
        var visited = new boolean[adjList.size()];
        //visit as many vertices as possible using dfs
        dfs(visited, 0);
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }

    public int countComponent() {

        int count = 0;
        var visited = new boolean[adjList.size()];

        for (int i = 0; i < visited.length; i++) {
            //visit as many vertices as possible using dfs
            if (!visited[i]) {
                dfs(visited, i);
                ++count;
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int node) {

        var stack = new Stack<Integer>();
        stack.push(node);

        while (!stack.isEmpty()) {

            int currentNode = stack.pop();
            visited[currentNode] = true;

            for (int childNode : adjList.get(currentNode)) {
                if (visited[childNode]) continue;
                stack.push(childNode);
            }
        }
    }
}

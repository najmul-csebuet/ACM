package Codility.Interview.SecondStage;

import java.io.*;
import java.util.*;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class B1 {

    public static void main(String[] args) throws IOException {

        String computed, expected;

        computed = new B1().solution(new String[]{"P>E", "E>R", "R>U"});
        expected = "PERU";
        out.println(computed.equals(expected));

        computed = new B1().solution(new String[]{"I>N", "A>I", "P>A", "S>P"});
        expected = "SPAIN";
        out.println(computed.equals(expected));

        computed = new B1().solution(new String[]{"I>N", "R>A", "A>I"});
        expected = "RAIN";
        out.println(computed.equals(expected));

        //out.println(Arrays.equals(computed, expected));
    }

    public String solution(String[] A) {

        MyGraph myGraph = new MyGraph(A);
        out.println("");

        return "";
    }

    private class MyNode {
        char label;
        int order, dist;
        char parent;

        public MyNode(char charAt) {
            label = charAt;
        }
    }

    private class MyGraph {

        Map<Character, MyNode> map = new HashMap<>();
        Map<Character, ArrayList<MyNode>> adjMap = new HashMap<>();

        public MyGraph(String[] edges) {

            //Creating Nodes and adj lists first
            for(String edge : edges) {
                if (!map.containsKey(edge.charAt(0))) {
                    map.put(edge.charAt(0), new MyNode(edge.charAt(0)));
                }

                if (!map.containsKey(edge.charAt(1))) {
                    map.put(edge.charAt(1), new MyNode(edge.charAt(1)));
                }

                if (!adjMap.containsKey(edge.charAt(0))) {
                    adjMap.put(edge.charAt(0), new ArrayList<>());
                }

                if (!adjMap.containsKey(edge.charAt(1))) {
                    adjMap.put(edge.charAt(1), new ArrayList<>());
                }
            }

            //Edges are directed
            for(String edge : edges) {
                ArrayList<MyNode> myNodes = adjMap.get(edge.charAt(0));
                myNodes.add(map.get(edge.charAt(2)));
            }
        }

        public String getWord() {
            Stack<Character> stack = new Stack<>();
        }
    }
}
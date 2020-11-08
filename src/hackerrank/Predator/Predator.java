package hackerrank.Predator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Predator {

    public static Scanner sc;
    public static PrintWriter out;

    private HashMap<Integer, List<Integer>> levelMap;
    private HashMap<Integer, List<Integer>> childMap;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !Predator.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Predator.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int[] N = new int[sc.nextInt()];
            for (int i = 0; i < N.length; ++i) N[i] = sc.nextInt();

            new Predator().solution(N);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(Predator.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(int[] n) {

        levelMap = new HashMap<>();
        childMap = new HashMap<>();

        for (int i = 0; i < n.length; i++) {
            updateMap(childMap, n[i], i);
        }

        List<Integer> rootlist = childMap.get(-1);
        for (int i = 0; i < n.length; i++) {
            if (n[i] == -1) {
                searchTree(n, i, 0);
            }
        }

        for (int i = 0; i < levelMap.keySet().size(); i++) {
            List<Integer> integers = levelMap.get(i);
            for (int j = 0; j < integers.size() - 1; j++) {
                out.print(integers.get(j) + " ");
            }
            out.println(integers.get(integers.size() - 1));
        }
    }

    private void updateMap(HashMap<Integer, List<Integer>> map, int key, int value) {
        List<Integer> orDefault = map.getOrDefault(key, new ArrayList<>());
        orDefault.add(value);
        map.put(key, orDefault);
    }

    private void searchTree(int[] n, int parent, int depthOfParent) {

        updateMap(levelMap, depthOfParent, parent);

        /*List<Integer> orDefault = levelMap.getOrDefault(depthOfParent, new ArrayList<>());
        orDefault.add(parent);
        levelMap.put(depthOfParent, orDefault);*/

        for (int i = 0; i < n.length; i++) {
            if (n[i] == parent) {
                searchTree(n, i, depthOfParent + 1);
            }
        }
    }
}

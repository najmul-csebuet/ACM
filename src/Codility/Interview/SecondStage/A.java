package Codility.Interview.SecondStage;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class A {

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

        A s = new A();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(Arrays.equals(getChange(5, 0.99), new int[] {1,0,0,0,0,4}));
        l.add(Arrays.equals(getChange(3.14, 1.99), new int[] {0,1,1,0,0,1}));
        l.add(Arrays.equals(getChange(4, 3.14), new int[] {1,0,1,1,1,0}));
        l.add(Arrays.equals(getChange(0.45, 0.34), new int[] {1,0,1,0,0,0}));

        checkTestCases(l);
    }

    public static int[] getChange(double M, double P) {

        int[] coins = { 1, 5, 10, 25, 50, 100};
        int amount = (int) ((M - P) * 100);

        int[] ans = new int[coins.length];

        for (int i = 5; i >= 0; i--) {
            ans[i] = amount / coins[i];
            amount %= coins[i];
        }

        return ans;
    }

    public int solution(int[] A) {

        return 0;
    }
}
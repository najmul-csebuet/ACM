package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

public class P278 {

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i)) {
                allPassed = false;
                System.out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        System.out.println(allPassed ? "All Test Cases Passed!" : "");
    }

    public static void main(String[] args) throws IOException {

        P278 s = new P278();
        ArrayList<Boolean> l = new ArrayList<>();

        //l.add(s.firstBadVersion() == 0);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    public int firstBadVersion(int n) {

        int firstBadVersion = 0;

        int low = 1, high = n;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isBadVersion(mid) != true) {
                firstBadVersion = Math.min(firstBadVersion, mid);
            }
            high = mid - 1;
        }

        return firstBadVersion;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
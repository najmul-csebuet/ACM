package Codility.Interview.Easy;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Solution s = new Solution();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution("ABDCA", new int[]{2,-1,-4,-3,3}, new int[]{2,-2,4,1,-3}) == 0);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

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

    public int solution(String S, int[] X, int[] Y) {
        // write your code in Java SE 8
    }
}
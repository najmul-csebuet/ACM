package Codility.Interview.Hard;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Solution s = new Solution();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution("babaa") == 2);
        l.add(s.solution("ababa") == 4);
        l.add(s.solution("aba") == 0);
        l.add(s.solution("bbbbb") == 6);
        l.add(s.solution("a") == 0);
        l.add(s.solution("aa") == 0);

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

    int[] getPrefixArray(char[] A) {

        int[] prefixSum = new int[A.length];
        if (A[0] == 'a')
            prefixSum[0] = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] == 'a') {
                prefixSum[i] = prefixSum[i - 1] + 1;
            }
            else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }

        return prefixSum;
    }

    public int solution(String S) {

        if (S.length() < 3)return 0;

        char[] charArray = S.toCharArray();
        int[] prefixArray = getPrefixArray(charArray);

        int totalA = prefixArray[S.length() - 1];
        if (totalA % 3 != 0) {
            return 0;
        }

        int aIn1Part = totalA / 3;

        return 0;
    }
}
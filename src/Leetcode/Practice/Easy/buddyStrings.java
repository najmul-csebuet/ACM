package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class buddyStrings {

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

        buddyStrings s = new buddyStrings();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.buddyStrings("ab", "ba"));
        l.add(s.buddyStrings("aa", "aa"));
        l.add(s.buddyStrings("abab", "abab"));
        l.add(s.buddyStrings("aaaaaaabc", "aaaaaaacb"));

        l.add(!s.buddyStrings("ab", "ab"));
        l.add(!s.buddyStrings("", "aa"));
        l.add(!s.buddyStrings("", ""));
        l.add(!s.buddyStrings("aa", ""));
        l.add(!s.buddyStrings("abcd", "badc"));

        checkTestCases(l);
    }

    public boolean buddyStrings(String A, String B) {

        /*char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        Arrays.sort(charsA);
        Arrays.sort(charsB);*/

        StringBuilder sbA = new StringBuilder(A);
        StringBuilder sbB = new StringBuilder(B);

        if (A.length() != B.length()) return false;
        if (A.length() == 0) return false;

        int i = 0;
        for (; i < A.length() - 2; i++) {
            if (A.charAt(i) != B.charAt(i)) break;
        }

        if (A.charAt(i) != B.charAt(i + 1)) return false;
        if (A.charAt(i + 1) != B.charAt(i)) return false;

        sbA.setCharAt(i, A.charAt(i + 1));
        sbA.setCharAt(i + 1, A.charAt(i));
        //sbB.setCharAt(i, A.charAt(i+1));

        return sbA.toString().equals(sbB.toString());
    }
}
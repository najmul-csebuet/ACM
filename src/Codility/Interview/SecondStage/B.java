package Codility.Interview.SecondStage;

import java.io.*;
import java.util.*;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class B {

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

        B s = new B();
        ArrayList<Boolean> l = new ArrayList<>();

        //l.add(s.findWord(new String[]{"P>E","E>R","R>U"}), "PERU");

        String ans = findWord(new String[]{"P>E","E>R","R>U"});
        String ans1 = findWord(new String[]{"I>N","A>I","P>A","S>P"});

        checkTestCases(l);
    }

    private static String getTop(ArrayList<String> array) {

        String top = "";
        for (int i = 0; i < array.size(); i++) {
            boolean flag = true;
            String first = array.get(i);
            for (int j = i + 1; j < array.size(); j++) {
                String second = array.get(j);
                if (first.charAt(0) == second.charAt(2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                top = first;
                break;
            }
        }
        return top;
    }

    public static String findWord(String[] array) {

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }

        String ans = "";

        while (true) {
            if (arrayList.size() == 0)  break;
            String tempTop = getTop(arrayList);
            arrayList.remove(tempTop);
            if (ans == "") {
                ans = tempTop;
            }
            else {
                ans += tempTop.charAt(2);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '>')continue;
            if (set.contains(ans.charAt(i)))continue;
            stringBuilder.append(ans.charAt(i));
            set.add(ans.charAt(i));
        }

        String x = stringBuilder.toString();
        out.println(x);
        return x;
    }
}
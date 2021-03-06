package Codeforces.Div3.Round_479.B_Two_gram;

import java.io.*;
import java.util.*;

public class B_Two_gram {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = B_Two_gram.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? B_Two_gram.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int l = sc.nextInt();
            String s = sc.next();
            new Solution().solution(s);
        }

        if (fileInOut) {

            verify(B_Two_gram.class.getResource("ans.txt").getFile());
        }
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            if (line1 == null || line2 == null) {

                areEqual = false;
                break;
            } else if (!line1.equals(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {

            System.out.println("All Test Cases Passed !");
        } else {

            System.out.println("Output differ at line " + lineNum);
            System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
        }

        reader1.close();
        reader2.close();
    }
}

class Solution {

    public static PrintWriter out;

    public void solution(String s) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i+2);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        int max = -1;
        String maxSt = "";

        for (String st : map.keySet()) {
            if (map.get(st) > max) {
                max = map.get(st);
                maxSt = st;
            }
        }

        out.println(maxSt);
    }
}

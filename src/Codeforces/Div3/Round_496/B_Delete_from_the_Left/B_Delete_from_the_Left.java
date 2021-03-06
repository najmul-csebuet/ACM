package Codeforces.Div3.Round_496.B_Delete_from_the_Left;

import java.io.*;
import java.util.*;

public class B_Delete_from_the_Left {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = B_Delete_from_the_Left.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? B_Delete_from_the_Left.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            String s = sc.next();
            String t = sc.next();
            new B_Delete_from_the_Left().solution(s, t);
        }

        if (fileInOut) {
            verify(B_Delete_from_the_Left.class.getResource("ans.txt").getFile());
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

    public void solution(String s, String t) {

        int minLen = Math.min(s.length(), t.length());
        int count = s.length() + t.length();

        for (int i = 1; i <= minLen; i++) {
            if (s.charAt(s.length() - i) == t.charAt(t.length() - i)) {
                count -= 2;
            } else
                break;
        }

        out.println(count);
    }
}

package Codility.L3.TapeEquilibrium;

import java.io.*;
import java.util.*;

public class TapeEquilibrium {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = TapeEquilibrium.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? TapeEquilibrium.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int aLength = sc.nextInt();
            int[] a = new int[aLength];

            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            new Solution().solution(a);
        }

        if (fileInOut) {

            verify(TapeEquilibrium.class.getResource("ans.txt").getFile());
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

    public int solution(int[] A) {

        long[] forwardSum = new long[A.length];
        long[] backwardSum = new long[A.length];

        if (A.length > 0) {
            forwardSum[0] = A[0];
            backwardSum[A.length - 1] = A[A.length - 1];
        }

        for (int i = 1; i < A.length; i++) {
            forwardSum[i] = forwardSum[i-1] + A[i];
        }

        for (int i = A.length - 2; i >= 0; i--) {
            backwardSum[i] = backwardSum[i+1] + A[i];
        }

        long diff = Long.MAX_VALUE;
        for (int i = 0; i < A.length-1; i++) {

            long localDiff = Math.abs(forwardSum[i] - backwardSum[i+1]);
            diff = Math.min(localDiff, diff);
        }

        out.println(diff);

        return (int) diff;
    }
}

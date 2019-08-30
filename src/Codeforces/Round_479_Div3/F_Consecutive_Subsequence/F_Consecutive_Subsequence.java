package Codeforces.Round_479_Div3.F_Consecutive_Subsequence;

import java.io.*;
import java.util.*;

public class F_Consecutive_Subsequence {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = F_Consecutive_Subsequence.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? F_Consecutive_Subsequence.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int aLength = sc.nextInt();
            int[] A = new int[aLength];

            for (int aIndex = 0; aIndex < A.length; aIndex++) {
                A[aIndex] = sc.nextInt();
            }

            new Solution().solve(A);
        }

        if (fileInOut) {

            verify(F_Consecutive_Subsequence.class.getResource("ans.txt").getFile());
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

    public void solve(int[] A) {

        int max = 1;
        int maxIndex = 0;

        int[] Score = new int[A.length];
        int[] PreviousItem = new int[A.length];

        for (int i = 1; i < A.length; i++) {

            int localMax = -1;
            int localMaxIndex = -1;

            for (int j = 0; j < i; j++) {

                if (A[j] + 1 == A[i]) {

                    if (Score[j] > localMax) {
                        localMax = Score[j];
                        localMaxIndex = j;
                    }
                }
            }

            if (localMax != -1) {
                Score[i] = localMax + 1;
                PreviousItem[i] = localMaxIndex;
            }

            if (max < localMax) {
                max = localMax;
                maxIndex = localMaxIndex;
            }
        }

        out.println(max);

        int i = maxIndex;
        //while (true) {

        //}
    }
}

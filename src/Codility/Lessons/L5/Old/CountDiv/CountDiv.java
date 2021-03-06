package Codility.Lessons.L5.Old.CountDiv;

import java.io.*;
import java.util.*;

public class CountDiv {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = CountDiv.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? CountDiv.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new MyPrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();

            new Solution().solution(a,b,k);
        }

        if (fileInOut) {

            verify(CountDiv.class.getResource("ans.txt").getFile());
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

class MyPrintWriter extends PrintWriter {

    public MyPrintWriter(BufferedOutputStream bufferedOutputStream, boolean autoFlash) {
        super(bufferedOutputStream, autoFlash);
    }

    public void print(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            print(A[i] + ' ');
        }
        if (A.length > 0) {
            println(A[A.length - 1]);
        }
    }
}

class Solution {

    public static MyPrintWriter out;

    public int solution(int A, int B, int K) {

        if (A == 0) {
            int ans = (B / K) + 1;
            out.println(ans);
            return ans;
        }

        int ans = B/K - (A - 1) / K;
        out.println(ans);
        return ans;
    }
}

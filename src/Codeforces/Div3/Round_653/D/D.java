package Codeforces.Div3.Round_653.D;

import java.io.*;
import java.util.*;

public class D {

    public void solve(Integer[] n, Integer k) {
        Arrays.sort(n, Collections.reverseOrder());

        int count = 0;
        int x = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] == 0)break;
            if (x == 0) {
                ++count;
                ++x;
                continue;
            }
            count += k - n[i];
            x += (k - n[i] + 1);
        }
        out.println(count);
    }

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = D.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? D.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int NLength = sc.nextInt();
            int K = sc.nextInt();

            Integer[] N = new Integer[NLength];

            for (int NIndex = 0; NIndex < N.length; NIndex++) {
                N[NIndex] = sc.nextInt() % K;
            }


            new D().solve(N, K);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(D.class.getResource("ans.txt").getFile()));
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
}

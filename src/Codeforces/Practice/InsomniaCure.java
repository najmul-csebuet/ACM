package Codeforces.Practice;

import java.io.*;
import java.util.*;

public class InsomniaCure {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = InsomniaCure.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? InsomniaCure.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int[] divArray = new int[4];
            for (int i = 0; i < 4; i++) {
                divArray[i] = sc.nextInt();
            }
            int d = sc.nextInt();
            new InsomniaCure().solve(divArray, d);
        }

        if (fileInOut) {
            verify(InsomniaCure.class.getResource("ans.txt").getFile());
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

    int getGcd(int m, int n) {
        for (int gcd = Math.min(m,n); gcd > 0; gcd--) {
            if (m%gcd == 0 && n%gcd == 0)return gcd;
        }
        return 1;
    }

    int getLcm(int m, int n) {
        return m*n / getGcd(m,n);
    }

    public void solve(int[] divArray, int d) {

        int sum = 0;
        for (int i = 0; i < divArray.length; i++) {

            for (int j = 0; j < i; j++) {
                int lcm = getLcm(divArray[j], divArray[i]);
                sum -= (d / lcm);
            }

            sum += (d/divArray[i]);
        }

        out.println(sum);
    }
}

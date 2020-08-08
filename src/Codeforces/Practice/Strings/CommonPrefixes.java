package Codeforces.Practice.Strings;

import Common.OutputVerifier;

import java.io.*;
import java.util.*;

public class CommonPrefixes {

    public void solution(int[] n) {

        out.flush();
    }

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !CommonPrefixes.class.getPackage().getName().isEmpty();
        int totalTC = !CommonPrefixes.class.getPackage().getName().isEmpty() ? sc.nextInt() : sc.nextInt();

        for (int tc = 1; tc <= totalTC; tc++) {

            int[] N = new int[sc.nextInt()];
            for (int i = 0; i < N.length; ++i) N[i] = sc.nextInt();

            new CommonPrefixes().solution(N);
        }

        if (fileInOut) OutputVerifier.verify(CommonPrefixes.class.getResource("ans.txt").getFile());
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = !CommonPrefixes.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? CommonPrefixes.class.getResourceAsStream("in.txt") : System.in)));
        try {
            out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private class MyPrintWriter extends PrintWriter {

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
}

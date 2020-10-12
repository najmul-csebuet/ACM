package Codementor;

import java.io.*;
import java.util.Scanner;

public class Decoder {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !Decoder.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Decoder.class.getResourceAsStream("in1.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {

            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] encryptedText = new int[N];
            for (int i = 0; i < encryptedText.length; ++i)encryptedText[i] = sc.nextInt();

            int[] plainText = new int[M];
            for (int i = 0; i < plainText.length; ++i)plainText[i] = sc.nextInt();

            new Decoder().solution(N, M, encryptedText, plainText);
        }
    }

    private int[] getRs(int A, int B, int M, int r0, int n) {
        var rs = new int[n+1];
        rs[0] = r0;
        for (int i = 1; i <= n; i++) {
            rs[i] = (A*rs[i-1] + B) % M;
        }
        return rs;
    }

    public void solution(int n, int m, int[] encryptedText, int[] plainText) {
        for (int M = 0; M < 1000; M++) {
            for (int B = 0; B < M; B++) {
                for (int r0 = 0; r0 < M; r0++) {
                    for (int A = 0; A < M; A++) {
                        //We have A, B, M, r0
                        int[] rs = getRs(A, B, M, r0, n);
                        int[] candidatePlainText = new int[n];
                        for (int i = 0; i < n; i++) {
                            candidatePlainText[i] = encryptedText[i] ^ rs[i + 1];
                        }

                        boolean flag = true;

                        for (int i = 0; i < m; i++) {
                            if (plainText[i] == candidatePlainText[i])continue;
                            flag = false;
                            break;
                        }

                        if (flag) {
                            System.out.println((A%M) + " " + (B%M) + " " + M + " " + (r0%M));
                            for (int i = 0; i < n - 1; i++) {
                                System.out.print(candidatePlainText[i] + " ");
                            }

                            if (n > 0) {
                                System.out.println(candidatePlainText[n - 1]);
                            }
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("Sorry no solution found.");
    }
}

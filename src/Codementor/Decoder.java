package Codementor;

import java.io.*;
import java.util.Scanner;

public class Decoder {

    public static Scanner sc;
    public static PrintWriter out;

    private int[] rs;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !Decoder.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Decoder.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int N = Integer.parseInt(sc.nextLine());//sc.nextInt();
        int M = Integer.parseInt(sc.nextLine());//sc.nextInt();

        int[] encryptedText = new int[N];
        for (int i = 0; i < encryptedText.length; ++i)
            encryptedText[i] = Integer.parseInt(sc.nextLine());//sc.nextInt();

        int[] plainText = new int[M];
        for (int i = 0; i < plainText.length; ++i) plainText[i] = Integer.parseInt(sc.nextLine());//sc.nextInt();

        new Decoder().solution(N, M, encryptedText, plainText);
    }

    private int[] getRs(int A, int B, int M, int n, int m) {
        for (int i = 1; i <= n; i++) {
            rs[i] = (A * rs[i - 1] + B) % M;
        }
        return rs;
    }

    public void solution(int n, int m, int[] encryptedText, int[] plainText) {

        rs = new int[n + 1];
        for (int i = 0; i < m; i++) {
            rs[i + 1] = encryptedText[i] ^ plainText[i];
        }

        for (int M = 1; M <= 1000; M++) {
            for (int B = 0; B < M; B++) {

                int A;
                for (A = 1; A < 1000; A++) {
                    int t = (A * rs[1] + B) % M;
                    if (t == rs[2]) {
                        if (isRelPrime(A, M)) {
                            break;
                        }
                    }
                }

                if (A == 1000) {
                    continue;
                }

                int r0;
                for (r0 = 0; r0 < 1000; r0++) {
                    //r1 = (A * r0 + B) % M
                    int t = (A * r0 + B) % M;
                    if (t == rs[1]) {
                        break;
                    }
                }
                if (r0 == 1000) {
                    continue;
                }

                rs[0] = r0;

                //We have A, B, M, r0
                getRs(A, B, M, n, m);
                int[] candidatePlainText = new int[n];
                for (int i = 0; i < n; i++) {
                    candidatePlainText[i] = encryptedText[i] ^ rs[i + 1];
                }

                /*System.out.print((A % M) + " " + (B % M) + " " + M + " " + (r0 % M));
                for (int i = 0; i < n; i++) {
                    System.out.print(" " + candidatePlainText[i]);
                }
                return;*/

                boolean flag = true;

                for (int i = 0; i < m; i++) {
                    if (plainText[i] == candidatePlainText[i]) continue;
                    flag = false;
                    break;
                }

                if (flag) {
                    System.out.print((A % M) + " " + (B % M) + " " + M + " " + (r0 % M));
                    for (int i = 0; i < n; i++) {
                        System.out.print(" " + candidatePlainText[i]);
                    }
                    return;
                }
            }
        }
    }

    private int gcd(int a, int b) {
        int t;
        while (b != 0) {
            t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    private boolean isRelPrime(int a, int b) {
        return gcd(a, b) == 1;
    }
}

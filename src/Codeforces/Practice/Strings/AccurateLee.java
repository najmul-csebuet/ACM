package Codeforces.Practice.Strings;

import Common.OutputVerifier;

import java.io.*;
import java.util.*;

public class AccurateLee {

    public static void main(String[] args) throws IOException {
        boolean fileInOut = !AccurateLee.class.getPackage().getName().isEmpty();
        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();

        for (int tc = 1; tc <= totalTC; tc++) {
            int lenS = sc.nextInt();
            String S = sc.next();
            new AccurateLee().solution(S);
        }

        if (fileInOut) OutputVerifier.verify(AccurateLee.class.getResource("ans.txt").getFile());
    }

    public void solution(String s) {
        int first1 = -1;
        int last0 = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                first1 = i;
                break;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                last0 = i;
                break;
            }
        }

        if (first1 == -1 || last0 == -1 || first1 > last0) {
            out.println(s);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < first1; i++) {
            sb.append(0);
        }

        sb.append(0);

        for (int i = 0; i < s.length() - last0 - 1; i++) {
            sb.append(1);
        }

        out.println(sb.toString());
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = !AccurateLee.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? AccurateLee.class.getResourceAsStream("in.txt") : System.in)));
        try {
            out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

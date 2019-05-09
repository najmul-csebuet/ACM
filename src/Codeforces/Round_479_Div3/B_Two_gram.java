package Codeforces.Round_479_Div3;

import java.io.*;
import java.util.*;

public class B_Two_gram {

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);

        int n = sc.nextInt();
        String line = sc.nextLine();

        int max = 0;
        String maxString = "";
        int current = 0;

        for (int i = 0; i <= n - 2; i++) {

            current = 1;

            for (int j = i + 1; j <= n - 2; j++) {

                if(line.charAt(i) == line.charAt(j) && line.charAt(i+1) == line.charAt(j+1)) {
                    ++current;
                }
            }

            if(max < current) {
                max = current;
                maxString = "" + line.charAt(i) + line.charAt(i+1);
            }
        }

        out.println(maxString);
        out.close();
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {

        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    //--------------------------------------------------------
}
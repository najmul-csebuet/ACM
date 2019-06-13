package Codeforces.Round_479_Div3;

import java.io.*;
import java.util.*;

public class C_Less_or_Equal {

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] list = new Integer[n];

        for(int i = 0; i < n; ++i) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);

        if(k == 0) {
            int t = list[0] - 1;
            out.println(t < 1 ? -1 : t);
        }
        else if(k == n || list[k - 1] < list[k]) {
            out.println(list[k - 1]);
        }
        else {
            out.println(-1);
        }

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
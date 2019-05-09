package Codeforces.Round_481_Div3;

import java.io.*;
import java.util.*;

public class A_Remove_Duplicates {

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);


        int n = sc.nextInt();

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        for (int i = n - 1; i >= 0 ; i--) {
            int number = a.get(i);
            if(map.containsKey(number)) {
                continue;
            }
            map.put(number, true);
            ans.add(number);
        }

        out.println(ans.size());

        for (int i = ans.size() - 1; i > 0 ; i--) {
            out.print(ans.get(i));
            out.print(" ");
        }

        if(ans.size() > 0) {
            out.println(ans.get(0));
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
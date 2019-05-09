package Codeforces.Round_481_Div3;//package Round_481_Div3.C;

import java.io.*;
import java.util.*;

public class C_Letters {

    static int binarySearch(long arr[], int l, int r, long x)
    {
        if (r>=l) {

            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid-1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid+1, r, x);
        }

        // We reach here when element is not present
        //  in array
        return l;
    }

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);


        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] a = new long [n + 1];
        long[] aBinarySearch = new long [n + 1];
        aBinarySearch[0] = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
            aBinarySearch[i] = aBinarySearch[i - 1] + a[i];
        }

        for (int i = 0; i < m; i++) {
            long b = sc.nextLong();
            int index = binarySearch(aBinarySearch, 1, n, b);

            int dormitoryNumber = index;
            out.println(dormitoryNumber + " " + (b - aBinarySearch[dormitoryNumber - 1]));
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
package Codeforces.Round_479_Div3;

import java.io.*;
import java.util.*;

class Number {
    long number;
    int degree;

}

class SortByBase implements Comparator<Number> {

    public int compare(Number a, Number b)
    {
        if(a.degree != b.degree) {
            return a.degree - b.degree;
        }

        return a.number <= b.number ? -1 : 1;
    }
}

public class DivideByThreeMultiplyByTwo {

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);

        int n = sc.nextInt();

        Number[] allNumbers = new Number[n];

        for (int i = 0; i < n; i++) {

            allNumbers[i] = new Number();
            allNumbers[i].number = sc.nextLong();
            allNumbers[i].degree = (int)(Math.log(allNumbers[i].number) / Math.log(3)) ;
        }

        Arrays.sort(allNumbers, new SortByBase());

        out.print(allNumbers);
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
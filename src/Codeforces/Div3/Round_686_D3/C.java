package Codeforces.Div3.Round_686_D3;

import java.io.*;
import java.util.*;

public class C {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean testLocally = !C.class.getPackage().getName().isEmpty();
        out = new PrintWriter(new BufferedOutputStream(testLocally ? new FileOutputStream("out.txt") : System.out), true);

        if (testLocally) {
            List<Boolean> l = new ArrayList<>();
            C s = new C();

            l.add(s.solution() == 0);
            //l.add(Arrays.equals(s.solution(), new int[]{));

            if (!l.contains(false)) System.out.println("All Test Cases Passed.");
            else for (int i = 0; i < l.size(); i++) if (!l.get(i)) System.out.println("Case " + (i + 1) + ": Failed");
        } else {
            sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int totalTC = sc.nextInt();
            for (int t = 1; t <= totalTC; t++) {
                new C().solution();
            }
        }
    }

    public int solution() {
        out.println(0);
        return 0;
    }
}

package Algorithm.CFEdu.SuffixArray;

import java.util.*;

public class Step1 {

    class Pair implements Comparable<Pair> {

        public char ch;
        public int index;

        public Pair(char charAt, int index) {
            this.ch = charAt;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return ch - o.ch;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        new Step1().solve(s);
    }

    private void solve(String s) {

        s += '$';
        int n = s.length();

        List<Pair> a = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i) a.add(new Pair(s.charAt(i), i));
        Collections.sort(a);
        //Collections.sort(a, (o1, o2) -> o1.ch - o2.ch);
        //Collections.sort(a, Comparator.comparingInt(o -> o.ch));

        ArrayList<Integer> p = new ArrayList<>(n);
        ArrayList<Integer> c = new ArrayList<>(n);

        for(Pair pair : a) {
            p.add(pair.index);
            c.add(0);
        }

        c.set(p.get(0), 0);

        for(int i = 1; i < n; ++i) {
            if(a.get(i).compareTo(a.get(i - 1)) == 0) {
                c.set(p.get(i), c.get(p.get(i - 1)));
            }
            else {
                c.set(p.get(i), c.get(p.get(i - 1)) + 1);
            }
        }

        // Now transition from k to k + 1
        int k = 0;
        while((1 << k) < n) {
            // This loop will run log(n) times

            List<List<Integer>> aList = new ArrayList<>();

            for(int i = 0; i < n; ++i) {
                List<Integer> l = new ArrayList<>();
                l.add(c.get(i));
                l.add(c.get((i + (1 << k)) % n));
                l.add(i);
                aList.add(l);
            }

            aList.sort((a1, a2) -> {
                if (a1.get(0) < a2.get(0)) return -1;
                if ((a1.get(0).equals(a2.get(0))) && (a1.get(1) < a2.get(1))) return -1;
                return 1;
            });

            p.clear();
            c.clear();

            for(List<Integer> pair : aList) {
                p.add(pair.get(2));
                c.add(0);
            }
            c.set(p.get(0), 0);

            for(int i = 1; i < n; ++i) {
                if(aList.get(i).get(0).equals(aList.get(i - 1).get(0)) && aList.get(i).get(1).equals(aList.get(i - 1).get(1))) {
                    c.set(p.get(i), c.get(p.get(i - 1)));
                }
                else {
                    c.set(p.get(i), c.get(p.get(i - 1)) + 1);
                }
            }
            ++k;
        }

        for(int i = 0; i < p.size() - 1; ++i) {
            System.out.print(p.get(i) + " ");
        }

        System.out.println(p.get(p.size() - 1));
    }
}

package Codility.Lesson_4_CountingElements;

import java.util.HashSet;

class PermCheck {

    public static void main(String[] args) {

        PermCheckSolution solver = new PermCheckSolution();

        System.out.println(solver.solution(new int[] {4,1,3,2}) == 1);
        System.out.println(solver.solution(new int[] {4,1,2}) == 0);
        System.out.println(solver.solution(new int[] {4,1,4,1}) == 1);
    }
}

class PermCheckSolution {

    public int solution(int[] A) {
        // write your code in Java SE 8

        HashSet<Integer> hashSet = new HashSet<>();

        int max = 0;
        for (int i = 0; i < A.length; i++) {

            if (hashSet.contains(A[i])) {
                return 0;
            }
            hashSet.add(A[i]);

            if (max < A[i]) {
                max = A[i];
            }
        }

        return max == A.length ? 1 : 0;
    }
}
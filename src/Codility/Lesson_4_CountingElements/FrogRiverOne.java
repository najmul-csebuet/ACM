package Codility.Lesson_4_CountingElements;

import java.util.HashSet;

class FrogRiverOne {

    public static void main(String[] args) {

        FrogRiverOneSolution solution = new FrogRiverOneSolution();
        System.out.println(solution.solution(5, new int[] {1,3,1,4,2,3,5,4}) == 6);
    }
}

class FrogRiverOneSolution {

    public int solution(int X, int[] A) {
        // write your code in Java SE 8

        HashSet<Integer> hashSet = new HashSet<>();

        long targetSum = X * (X + 1L) / 2L;

        for (int i = 0; i < A.length; i++) {

            if (hashSet.contains(A[i])) {
                continue;
            }
            hashSet.add(A[i]);
            targetSum -= A[i];

            if (targetSum == 0) {
                return i;
            }
        }

        return -1;
    }
}
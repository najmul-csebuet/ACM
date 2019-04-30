package Codility;

class PermMissingElem {
    public static void main(String[] args) {

        int[] A = {2, 3, 1, 5};
        PermMissingElemSolution solution = new PermMissingElemSolution();
        System.out.println(solution.solution(A) == 4);
    }
}

class PermMissingElemSolution {

    public int solution(int[] A) {
        // write your code in Java SE 8

        long N = A.length + 1;

        long targetTotal = N * ( N + 1 ) / 2;

        long presentTotal = 0;
        for (int i = 0; i < A.length; i++) {
            presentTotal += A[i];
        }

        return (int) (targetTotal - presentTotal);
    }
}
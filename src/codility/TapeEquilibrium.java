package codility;

class TapeEquilibrium {
    public static void main(String[] args) {

        TapeEquilibriumSolution solution = new TapeEquilibriumSolution();
        System.out.println(solution.solution(new int[]{3, 1, 2, 4, 3}) == 1);
    }
}

class TapeEquilibriumSolution {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int N = A.length;

        long[] forwardIncrementalSum = new long[N];
        long[] backwardIncrementalSum = new long[N];

        forwardIncrementalSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            forwardIncrementalSum[i] = forwardIncrementalSum[i - 1] + A[i];
        }

        backwardIncrementalSum[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            backwardIncrementalSum[i] = A[i] + backwardIncrementalSum[i + 1];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {

            int abs = (int) Math.abs(forwardIncrementalSum[i] - backwardIncrementalSum[i + 1]);
            if(abs < ans) {
                ans = abs;
            }
        }

        return ans;
    }
}
package Codility;

class CyclicRotation {
    public static void main(String[] args) {

        //A = [3, 8, 9, 7, 6]
    }
}

class CyclicRotationSolution {

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        if (A.length == 0) return A;
        K = K % A.length;

        int[] result = new int[A.length];

        //A = [3, 8, 9, 7, 6]
        int newIndex = -1;
        for (int i = A.length - K; i < A.length; i++) {

            result[++newIndex] = A[i];
        }

        for (int i = 0; i < A.length - K; i++) {
            result[++newIndex] = A[i];
        }

        return result;
    }
}

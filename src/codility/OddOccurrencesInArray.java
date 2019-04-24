package codility;

class OddOccurrencesInArray {

    public static void main(String[] args) {

    }
}

class OddOccurrencesInArraySolution {

    public int solution(int[] A) {
        // write your code in Java SE 8

        int ans = 0;
        for (int i = 0; i < A.length; i++) {

            ans = ans ^ A[i];
        }

        return ans;
    }
}

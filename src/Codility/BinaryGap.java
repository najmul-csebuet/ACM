package Codility;

class BinaryGap {

    public static void main(String[] args) {

        BinaryGapSolution solution = new BinaryGapSolution();
        System.out.println(solution.solution(529) == 4);
        System.out.println(solution.solution(9) == 2);
        System.out.println(solution.solution(20) == 1);
        System.out.println(solution.solution(15) == 0);
        System.out.println(solution.solution(32) == 0);
        System.out.println(solution.solution(1041) == 5);
    }
}

class BinaryGapSolution {

    public int solution(int N) {

        String s = Integer.toBinaryString(N);
        char[] ss = s.toCharArray();

        int maxGap = 0;
        int currentGap = 0;

        int start = 0;
        int end = ss.length - 1;

        while (ss[start] == '0') {
            ++start;
        }

        while (ss[end] == '0') {
            --end;
        }

        //1000100000001001
        //1001
        for (int i = start; i <= end; i++) {


            if (ss[i] == '1') {

                if (currentGap > maxGap) {
                    maxGap = currentGap;
                }

                currentGap = 0;
            } else {
                ++currentGap;
            }
        }

        return maxGap;
    }
}
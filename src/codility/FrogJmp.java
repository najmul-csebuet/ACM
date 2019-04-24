package codility;

class FrogJmp {

    public static void main(String[] args) {

        FrogJmpSolution s = new FrogJmpSolution();
        System.out.println(s.solution(10, 85, 30) == 3);
    }
}

class FrogJmpSolution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8

        double d = (Y - X) / (double) D;
        return (int) Math.ceil(d);
    }
}
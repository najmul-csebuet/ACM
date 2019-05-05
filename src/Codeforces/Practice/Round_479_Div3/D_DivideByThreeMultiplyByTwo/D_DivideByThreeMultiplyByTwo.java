package Codeforces.Practice.Round_479_Div3.D_DivideByThreeMultiplyByTwo;

import java.io.*;
import java.util.*;

public class D_DivideByThreeMultiplyByTwo {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = D_DivideByThreeMultiplyByTwo.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? D_DivideByThreeMultiplyByTwo.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            
            int arrayLength = sc.nextInt();
            Long[] array = new Long[arrayLength];
            
            for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
                array[arrayIndex] = sc.nextLong();
            }
            
            new Solution().solve(array);
        }

        if (fileInOut) {

            verify(D_DivideByThreeMultiplyByTwo.class.getResource("ans.txt").getFile());
        }
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            if (line1 == null || line2 == null) {

                areEqual = false;
                break;
            } else if (!line1.equals(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {

            System.out.println("All Test Cases Passed !");
        } else {

            System.out.println("Output differ at line " + lineNum);
            System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
        }

        reader1.close();
        reader2.close();
    }
}

class Solution {

    public static PrintWriter out;

    private int getPowerOf3(Long n) {

        int count = 0;
        while (n % 3 == 0) {
            n /= 3;
            ++count;
        }

        return count;
    }

    public void solve(Long[] array) {

        Arrays.sort(array, (o1, o2) -> {

            int a = getPowerOf3(o1);
            int b = getPowerOf3(o2);

            if (a > b) return -1;
            if (a < b) return 1;

            return o1 - o2 < 0 ? -1 : 1;
        });

        for (int i = 0; i < array.length; i++) {

            if (i < array.length - 1) {
                out.print(array[i] + " ");
            }
            else {
                out.println(array[i]);
            }
        }
    }
}

package Algorithm.EditDistance;

import java.io.*;
import java.util.*;

public class EditDistance {

    public int solve(String source, String target) {

        if (source.isEmpty())return target.length();
        if (target.isEmpty())return source.length();

        int insertCase = solve(source, target.substring(1)) + 1;
        int deleteCase = solve(source.substring(1), target) + 1;
        int subCost = source.charAt(0) == target.charAt(0) ? 0 : 1;
        int substitutionCase = solve(source.substring(1), target.substring(1)) + subCost;

        int min = Math.min(Math.min(insertCase, deleteCase), substitutionCase);

        //System.out.println(source + ", " + target + " = " + min);
        return min;
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = EditDistance.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? EditDistance.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            String source = sc.next();
            String target = sc.next();
            int solve = new EditDistance().solve(source, target);
            out.println(solve);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(EditDistance.class.getResource("ans.txt").getFile()));
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
}

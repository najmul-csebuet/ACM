package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OutputVerifier {

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            if(line1 == null || line2 == null) {

                areEqual = false;
                break;
            }
            else if(! line1.equalsIgnoreCase(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if(areEqual) {

            System.out.println("All Test Cases Passed !");
        }
        else {

            System.out.println("Output differ at line "+lineNum);
            System.out.println("ans.txt has " + line1 + " and output.txt has " + line2 + " at line " +lineNum);
        }

        reader1.close();
        reader2.close();
    }
}
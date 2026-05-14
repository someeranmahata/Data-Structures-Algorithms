import java.util.*;
import java.io.*;

public class Test {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("input.txt"));
        int tc = 1;

        while (sc.hasNextLine()) {

            StringBuilder inputBlock = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) break;
                inputBlock.append(line).append("\n");
            }

            if (inputBlock.length() == 0) break;

            String ans = Main.solve(new Scanner(inputBlock.toString()));

            Scanner ansSc = new Scanner(ans);

            boolean passed = true;
            int lineNum = 1;

            while (sc.hasNextLine()) {
                String expLine = sc.nextLine();

                if (expLine.trim().isEmpty()) break;

                String ansLine = ansSc.hasNextLine() ? ansSc.nextLine() : "";

                if (!ansLine.trim().equals(expLine.trim())) {
                    System.out.println("Test Case " + tc + " FAILED at line " + lineNum);
                    System.out.println("Got: " + ansLine);
                    System.out.println("Expected: " + expLine);
                    passed = false;
                    break;
                }
                lineNum++;
            }

            while (passed && ansSc.hasNextLine()) {
                if (!ansSc.nextLine().trim().isEmpty()) {
                    System.out.println("Test Case " + tc + " FAILED (extra output)");
                    passed = false;
                    break;
                }
            }

            if (passed) {
                System.out.println("Test Case " + tc + " PASSED");
            }

            System.out.println();
            tc++;
        }

        sc.close();
    }
}

import java.util.*;
import java.io.*;

public class Test{
    
    public static void main(String[] args) throws Exception{
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        long tc = 1;

        while (sc.hasNextLine()) {

            StringBuilder inputBlock = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) break;
                inputBlock.append(line).append("\n");
            }

            if (inputBlock.length() == 0) break;

            String ans = Main.solve(new Scanner(inputBlock.toString()));

            StringBuilder output = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) break;
                output.append(line).append("\n");
            }

            if (ans.trim().equals(output.toString().trim()))
                System.out.println("Test Case " + tc++ + " Passed");
            else {
                System.out.println("Test Case " + tc++ + " Failed");
                System.out.println("Got : " + "\n" + ans.trim());

                System.out.println("Expected : " + "\n" + output.toString().trim());
            }
            System.out.println();
        }    

    }

}

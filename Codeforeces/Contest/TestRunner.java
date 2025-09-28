import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class TestCase {
    String input;
    String expectedOutput;

    public TestCase(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }
}

public class TestRunner {

    public static List<TestCase> readTestCases(String filename) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        String[] parts = content.split("\\n\\s*\\n");  // split at blank lines
        List<TestCase> testCases = new ArrayList<>();

        for (int i = 0; i < parts.length - 1; i += 2) {
            String input = parts[i].trim();
            String expectedOutput = parts[i + 1].trim();
            testCases.add(new TestCase(input, expectedOutput));
        }

        return testCases;
    }

    public static void main(String[] args) throws Exception {
        List<TestCase> testCases = readTestCases("testcases.txt");

        // Compile the Solution.java file
        ProcessBuilder compileBuilder = new ProcessBuilder("javac", "Solution.java");
        Process compile = compileBuilder.start();
        compile.waitFor();

        int testNum = 1;
        for (TestCase test : testCases) {
            // Run the compiled Solution.class
            ProcessBuilder runBuilder = new ProcessBuilder("java", "Solution");
            runBuilder.redirectErrorStream(true);
            Process process = runBuilder.start();

            // Send input
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write(test.input);
            writer.newLine();
            writer.flush();
            writer.close();

            // Read output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder outputBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                outputBuilder.append(line.trim()).append("\n");
            }
            reader.close();

            String actualOutput = outputBuilder.toString().trim();
            String expectedOutput = test.expectedOutput.trim();

            if (normalize(actualOutput).equals(normalize(expectedOutput))) {
                System.out.println("Test Case " + testNum + " Passed");
                System.out.println();
            } else {
                System.out.println("Test Case " + testNum + " Failed");
                System.out.println("Expected:\n" + expectedOutput);
                System.out.println("Got:\n" + actualOutput);
                System.out.println();
            }

            testNum++;
        }
    }
    private static String normalize(String s) {
        return s.strip().replaceAll("\\s+", " ").trim();
    }

}

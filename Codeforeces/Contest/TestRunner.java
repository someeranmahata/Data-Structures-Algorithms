import java.io.*;
import java.nio.file.*;
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

    // --- Read test cases from file ---
    public static List<TestCase> readTestCases(String filename) throws IOException {
        String content = Files.readString(Paths.get(filename));
        content = content.replace("\r\n", "\n"); // normalize newlines

        String[] parts = content.split("(?m)(\\n){2,}");
        List<TestCase> testCases = new ArrayList<>();

        if (parts.length % 2 != 0) {
            System.err.println("Warning: Uneven number of sections in testcases.txt");
        }

        for (int i = 0; i < parts.length - 1; i += 2) {
            String input = parts[i].trim();
            String expectedOutput = parts[i + 1].trim();
            testCases.add(new TestCase(input, expectedOutput));
        }

        return testCases;
    }

    // --- Main ---
    public static void main(String[] args) {
        try {
            List<TestCase> testCases = readTestCases("testcases.txt");
            if (testCases.isEmpty()) {
                System.out.println("No test cases found in testcases.txt");
                return;
            }

            // --- Compile Solution.java ---
            ProcessBuilder compileBuilder = new ProcessBuilder("javac", "Solution.java");
            Process compile = compileBuilder.start();
            compile.waitFor();

            if (compile.exitValue() != 0) {
                System.err.println("Compilation failed. Check your Solution.java.\n");
                printProcessErrors(compile);
                return;
            }

            // --- Run each test case ---
            int testNum = 1;
            for (TestCase test : testCases) {
                ProcessBuilder runBuilder = new ProcessBuilder("java", "Solution");
                runBuilder.redirectErrorStream(true);
                Process process = runBuilder.start();

                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                    writer.write(test.input);
                    writer.newLine();
                    writer.flush();
                }

                String actualOutput;
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    StringBuilder outputBuilder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        outputBuilder.append(line).append("\n");
                    }
                    actualOutput = outputBuilder.toString().trim();
                }

                process.waitFor();

                if (compareOutputs(test.expectedOutput, actualOutput)) {
                    System.out.println("Test Case " + testNum + " Passed\n");
                } else {
                    // print only what you requested
                    System.out.println("Test Case " + testNum + " Failed");
                    System.out.println("Expected Output:\n" + test.expectedOutput);
                    System.out.println("Your Output:\n" + actualOutput + "\n");
                }

                testNum++;
            }

        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Process interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e);
            e.printStackTrace();
        }
    }

    // --- Compare outputs line by line ---
    private static boolean compareOutputs(String expected, String actual) {
        String[] expLines = expected.strip().split("\\r?\\n");
        String[] actLines = actual.strip().split("\\r?\\n");

        if (expLines.length != actLines.length)
            return false;

        for (int i = 0; i < expLines.length; i++) {
            if (!expLines[i].stripTrailing().equals(actLines[i].stripTrailing()))
                return false;
        }

        return true;
    }

    // --- Print compile errors ---
    private static void printProcessErrors(Process process) throws IOException {
        try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }
        }
    }
}

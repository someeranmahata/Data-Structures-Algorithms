import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println(solve(sc));
    }

    public static String solve(Scanner sc) {

        StringBuilder st = new StringBuilder();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (i > 0) st.append(" ");
            st.append(num % 2 == 0 ? "yes" : "no");
        }

        return st.toString();
    }
}

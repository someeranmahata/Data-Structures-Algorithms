import java.util.*;
public class E{

    public static void main(String[] args){
        int t = 600;   // number of test cases (valid since 1 ≤ t ≤ 1000)
        StringBuilder output = new StringBuilder();
        output.append(t).append("\n");

        for (int i = 0; i < t; i++) {

            int n = (int)(Math.random() * 1000) + 1;  // 1 ≤ n ≤ 1000
            output.append(n).append("\n");

            String s = generatePalindrome(n);
            output.append(s).append("\n");
        }

        System.out.println(output);
    }

    static String generatePalindrome(int n) {

        StringBuilder half = new StringBuilder();
        boolean hasZero = false;

        for (int i = 0; i < n / 2; i++) {
            int bit = (int)(Math.random() * 2);
            if (bit == 0) hasZero = true;
            half.append(bit);
        }

        StringBuilder result = new StringBuilder();
        result.append(half);

        if (n % 2 == 1) {
            int mid = (int)(Math.random() * 2);
            if (mid == 0) hasZero = true;
            result.append(mid);
        }
        result.append(new StringBuilder(half).reverse());

        if (!hasZero) {
            result.setCharAt(0, '0');
            result.setCharAt(n - 1, '0');
        }

        return result.toString();
    }
}
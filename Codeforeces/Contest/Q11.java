import java.util.*;

class Q11 {
    static int calculate(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int sum = calculate(a, b);
        System.out.println(sum);
    }

}
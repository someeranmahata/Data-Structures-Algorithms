import java.util.*;
import java.io.*;

public class Main {

    public static String solve(Scanner sc) {
        
        StringBuilder st = new StringBuilder();
        

        /*
         * */

        int n = sc.nextInt();
        int sum = sc.nextInt();

        int[][] ar = new int[n][2];
        for(int i = 0; i < n; i++)
            ar[i][0] = sc.nextInt();

        for(int i = 0; i < n; i++)
            ar[i][1] = sc.nextInt();

        int[] dp = new int[sum + 1];
        for(int i = 0; i < n; i++) {

            int cost = ar[i][0];
            int page = ar[i][1];

            for(int j = sum; j >= cost; j--) {

                dp[j] = Math.max(
                    dp[j],
                    dp[j - cost] + page
                );
            }
        }
        st.append(dp[sum]);


        return st.toString();

    }
    static int solve(int n, int[] dp){
        if(dp[n] != 0)
            return dp[n];
        int num = n;
        int min = Integer.MAX_VALUE;
        
        while(num > 0){
            int digit = num%10;
            if(digit != 0){
                if(dp[n - digit] == 0)
                    dp[n - digit] = solve(n - digit, dp);
                min = Math.min(min, dp[n - digit] + 1);
            }
            num /= 10;
        }

        return dp[n] = min;

    }
    
    //METHODS
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long MEX(List<Long> list){
        long min = 0;
        HashSet<Long> set = new HashSet<>(list); // O(1) lookup
        while(true){
            if(set.contains(min)) min++;
            else return min;
        }
    }


    static boolean prime(long x){
        if(x == 1)
            return false;
        else if(x < 3)
            return true;
        for(long i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println(solve(sc));
    }
}

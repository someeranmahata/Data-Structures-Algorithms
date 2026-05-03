import java.util.*;
import java.io.*;

public class Main {
    static long[] dp = new long[2_00_000];

    public static String solve(Scanner sc) {
        
        StringBuilder st = new StringBuilder();

        int test = sc.nextInt();
        for(int tt = 1; tt <= test; tt++){
            
            int n = sc.nextInt();
            long[][] ar = new long[n][2];
            
            for(int i = 0; i < n; i++){
                ar[i][0] = sc.nextLong();
                ar[i][1] = (long)(i + 1);
            }
            for(int i = 0; i < n; i++)
                ar[i][0] -= sc.nextLong();

            Arrays.sort(ar, (a, b)->Long.compare(b[0], a[0]));

            int count = 0;
            StringBuilder vertex = new StringBuilder();
            int i = 0;
            while(i < n && ar[0][0] == ar[i][0]){
                count++;
                vertex.append(ar[i][1] + " ");
                i++;
            }
            st.append(count + "\n");
            st.append(vertex + "\n");

        }


        return st.toString();
    }
    
    static long fact(int n){
        if(n <= 1)
            return 1;
        if(dp[n] != 0)
            return dp[n];
        return dp[n] = (n*fact(n - 1))%998244353;
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

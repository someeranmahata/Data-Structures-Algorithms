
import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution{

    static int mod = 1_000_000_007;
  
    public static void main(String[] args) throws java.lang.Exception{
        StringBuilder st = new StringBuilder();
    	Scanner sc = new Scanner(System.in);
        /*
         * Solution with O(n)?
         */

        int test = sc.nextInt();
        for(int tt = 1; tt<= test; tt++){

            int n = sc.nextInt();
            long[] ar = new long[n];
            for(int i = 0; i < n; i++)
                ar[i] = sc.nextLong();
            
            Set<Long> set = new HashSet<>();
            set.add(0l);
            long sum = 0;
            boolean flag = false;
            for(int i = 0; i < n && !flag; i++){
                sum = (i % 2 == 0)? sum - ar[i] : sum + ar[i];
                if(set.contains(sum))
                    flag = true;
                set.add(sum);
            }
            st.append(flag? "YES\n" : "NO\n");

        }


        System.out.println(st);


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

    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) throw new EOFException("No more tokens available");
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}

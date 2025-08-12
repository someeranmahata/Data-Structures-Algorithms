import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution{
    static final int m = (int)1e9 + 7;
    static int numberOfWays(int n, int x) {
            long[] dp = new long[n+1];
            dp[0] = 1;
            for (int i = 1; Math.pow(i,x) <= n; i++) {
                int num = (int)Math.pow(i,x);
                for (int s = n; s >= num; s--) {
                    dp[s] += dp[s - num];
                }
            }
            return (int) (dp[n] % m);
        }

    public static void main(String[] args) throws java.lang.Exception
    {   
        FastScanner sc = new FastScanner(System.in);
        
        StringBuilder st = new StringBuilder();
        System.out.println(numberOfWays(4, 1));

        
    }
    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;
 
        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
 
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
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

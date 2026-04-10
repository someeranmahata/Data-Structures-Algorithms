
import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution{

    static int mod = 1_000_000_007;

    // GRAY CODE = i ^ (i >> 1)

    public static void main(String[] args) throws java.lang.Exception{
        StringBuilder st = new StringBuilder();
    	Scanner sc = new Scanner(System.in);
        /*
         x,y,z
         Ax = Ay - Az
         output format
            number of op
             then indices x y z
         resultant array shhould be in increasing  order

         */

        int test = sc.nextInt();
        for(int tt = 1; tt<= test; tt++){



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

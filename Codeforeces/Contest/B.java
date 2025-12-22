
import com.sun.source.tree.UsesTree;

import java.util.*;
import java.lang.*;
import java.io.*;

public class B {

    static int mod = 1_000_000_007;
    // GRAY CODE = i ^ (i >> 1)
    // way to find whether a number is power of 2 (n & (n - 1)) == 0

    public static void main(String[] args) throws java.lang.Exception{
        FastScanner sc = new FastScanner(System.in);
        StringBuilder st = new StringBuilder();

        /**/

        int test = sc.nextInt();
        while(test-- > 0){

            int n = sc.nextInt();
            int k = sc.nextInt();

            if ((k & 1) == 1) {
                for (int i = 0; i < k; i++) {
                    st.append(n).append(" ");
                }
            } else {
                for (int i = 0; i < k - 2; i++) {
                    st.append(n).append(" ");
                }
                st.append(0).append(" ");
                st.append(n).append(" ");
            }

            st.append("\n");

        }


        System.out.println(st);


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
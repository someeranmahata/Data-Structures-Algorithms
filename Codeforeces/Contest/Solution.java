import java.awt.datatransfer.StringSelection;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Solution{


    static int mod = 1_000_000_007;
    // GRAY CODE = i ^ (i >> 1)
    // way to find whether a number is power of 2 (n & (n - 1)) == 0
    static HashMap<Integer, String> map = new HashMap<>();
    
    public static void main(String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();

        /*

         */

        int test = sc.nextInt();
        for(int tt = 1; tt <= test; tt++) {

            int n = sc.nextInt();
            HashMap<Long, List<Integer>> map = new HashMap<>();

            long ans = 0;
            for(int i = 1; i <= n; i++){
                long num  = sc.nextLong();
                if(!map.containsKey(num)){
                    List<Integer> list = map.get(num);
                    list.add(i);
                    map.put(num, list);
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(num, list);
                }
                for(int j = 1; j < i; i++){
                    if(num - j < 1)
                        break;
                    if(map.containsKey(num - j)){
                        if(map.get(num - j).contains(i - j))
                            ans++;
                    }
                }
            }

            st.append(ans).append("\n");


        }

        System.out.println(st);

    }

    
    


    //METHODS
    static long areaOfTriangle(
            long x1, long y1,
            long x2, long y2,
            long x3, long y3) {

        long determinant = x1 * (y2 - y3)
                + x2 * (y3 - y1)
                + x3 * (y1 - y2);

        return (long)(Math.abs(determinant));
    }

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
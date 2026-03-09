
import java.awt.datatransfer.StringSelection;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Solution{


    static int mod = 1_000_000_007;
    // GRAY CODE = i ^ (i >> 1)
    // way to find whether a number is power of 2 (n & (n - 1)) == 0

    public static void main(String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();

        /*
         * add all those tile which can reach the drain by moving left, right, and down
         * find left and round next maximum height dirt to a column
         * */

        int mod = 1_000_000_007;

        int test = sc.nextInt();
        while(test-- > 0){

            int n = sc.nextInt();
            long h = sc.nextLong();

            long[] ar = new long[n];

            for(int i = 0; i < n; i++){
                ar[i] = sc.nextLong();
            }
            long[] leftsum = new long[n];
            long[] rightsum = new long[n];


            //adding left part
            for(int i = 0; i < n; i++){
                int j = i;
                long max = ar[i];
                long cap = 0;

                while(j >= 0 && ar[j] >= max){

                    cap +=(h - ar[j]);
                    max = Math.max(max, ar[j]);
                    j--;
                }
                while(j != -1){
                    if(ar[j] > max){
                        cap += (h - ar[j]);
                    }
                    else{
                        cap += (h - max);
                    }
                    j--;
                }
                leftsum[i] = cap;
            }
            //adding right part
            for(int i = 0; i < n; i++){
                int j = i;
                long max = ar[i];
                long cap = 0;

                while(j < n && ar[j] >= max){

                    cap +=(h - ar[j]);
                    max = Math.max(max, ar[j]);
                    j++;
                }
                while(j != n){
                    if(ar[j] > max){
                        cap += (h - ar[j]);
                    }
                    else{
                        cap += (h - max);
                    }

                    j++;
                }
                rightsum[i] = cap;
            }
            for(int i = n - 2; i >= 0; i--){
                rightsum[i] = Math.max(rightsum[i], rightsum[i + 1]);
            }

            long ans = 0;

            for(int i = 0; i < n; i++){
                long left = leftsum[i];
                int j = i + 1;
                long max = ar[i];
                while(j < n && ar[j] >= max){
                    left += (h - ar[j]);
                    max = Math.max(ar[j], max);
                    j++;
                }
                if(j != n){
                    left += rightsum[j];
                }
                ans = Math.max(left, ans);
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
    static long gcdList(long[] ar){
        if(ar.length == 1)
            return ar[0];

        Arrays.sort(ar);
        long cur = ar[ar.length - 1];
        for(int i = ar.length - 2; i >= 1 && cur != 1; i--){
            cur = gcd(ar[i], cur);
        }
        return cur;
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

    static int binarySearch(int[] ar, int target){
        if(ar[target] != 0)
            return target;
        int left = 0, right = ar.length - 1;
        int ind = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (ar[mid] < target){
                left = mid + 1;
                if(ar[mid] != 0)
                    ind = Math.max(ind, mid);
            }
            else
                right = mid - 1;

        }
        return ind;
    }
    static StringBuilder testcaseGenerator(int n, long bound){
        StringBuilder st = new StringBuilder();
        Random rand = new Random();

        for(int i = 0; i < n; i++){
            if(i == n - 1){
                st.append(rand.nextLong(bound));
                continue;
            }
            st.append(rand.nextLong(bound) + ", ");
        }
        return st;
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
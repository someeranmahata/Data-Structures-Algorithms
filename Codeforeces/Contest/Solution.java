import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {

    static int mod = 1_000_000_007;
    // GRAY CODE = i ^ (i >> 1)
    // way to find whether a number is power of 2 (n & (n - 1)) == 0

    public static void main(String[] args) throws java.lang.Exception{
        FastScanner sc = new FastScanner(System.in);
        StringBuilder st = new StringBuilder();

        /*
        * div 1 all rated
        * div 2 rated for those with rating strictly less than X
        * we can change the rating between the range of [r - d, r + d]
        * */

        int test = sc.nextInt();
        while(test-- > 0){

            

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

    static void swap(int[] a, int[] b, int i, int j){
        a[i] = a[i] + b[j];
        b[j] = a[i] - b[j];
        a[i] = a[i] - b[j];
    }

    static void swap(int[] a, int i, int j){
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
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

    static int binarySearch(long[] ar, long target){
        int left = 0, right = ar.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (ar[mid] == target)
                return mid;
            else if (ar[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;

        }
        return -1;
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
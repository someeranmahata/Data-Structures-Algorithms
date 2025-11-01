import java.util.*;
import java.lang.*;
import java.io.*;

/*
    to compare codes sc codeforces
    https://codeforces.com/contest/2104/submission/335103189?compareWith=335102843
*/
public class C{

    static int mod = 1_000_000_007;
    // GRAY CODE = i ^ (i >> 1)
    // way to find whether a number is power of 2 (n & (n - 1)) == 0

    public static void main(String[] args) throws java.lang.Exception{
        FastScanner sc = new FastScanner(System.in);
        StringBuilder st = new StringBuilder();

        /*
        * bonus point = price of ith item if our loyalty level increases from the last one
        * we have to purchase in such a order so that bonus increases
        * */

        int t = sc.nextInt();
        for(int tt = 0; tt < t; tt++) {

            int n = sc.nextInt();
            long x = sc.nextLong();

            long[] ar = new long[n];
            long sum = 0;

            for (int i = 0; i < n; i++){
                ar[i] = sc.nextLong();
                sum += ar[i];
            }
            if(sum < x){
                st.append(0).append("\n");
                for(long i : ar)
                    st.append(i).append(" ");
                st.append("\n");
                continue;
            }

            Arrays.sort(ar);

            sum = 0;
            long loy = 0;

            long bonus = 0;

            int i = 0;
            int j = n - 1;
            StringBuilder order = new StringBuilder();
            while(i <= j){
                if((ar[j] + sum)/x > loy){
                    sum += ar[j];
                    order.append(ar[j]).append(" ");
                    loy = (sum)/x;
                    bonus += ar[j];
                    j--;
                }
                else{
                    sum += ar[i];
                    order.append(ar[i]).append(" ");
                    if(sum/x > loy){
                        loy = sum/x;
                        bonus += ar[i];
                    }
                    i++;
                }
            }
            st.append(bonus).append("\n");
            st.append(order).append("\n");

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
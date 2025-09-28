import java.sql.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

/*
    to compare codes sc codeforces
    https://codeforces.com/contest/2104/submission/335103189?compareWith=335102843
*/
public class Solution{

    static int mod = 1_000_000_007;
    // GRAY CODE = i ^ (i >> 1)
    // way to find whether a number is (n & (n - 1)) == 0

    public static void main(String[] args) throws java.lang.Exception{
        FastScanner sc = new FastScanner(System.in);
        StringBuilder st = new StringBuilder();



        int t = sc.nextInt();
        for(int z = 0; z < t; z++){



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

    static int ternarySearch(int[] ar, int num){
        int st = 0;
        int end = ar.length - 1;
        int mid_left = 0;
        int mid_right = ar.length - 1;
        while(st <= end){

            if(end - st + 1 < 3){
                if(ar[st] == num)
                    return st;
                else if(ar[end] == num)
                    return end;
                else
                    return -1;
            }
            mid_left = (st + end)/3;
            mid_right = (mid_left + end)/2;
            if(ar[mid_left] == num)
                return mid_left;
            if(ar[mid_right] == num)
                return mid_right;
            if(num < ar[mid_left]){
                end = mid_left - 1;
            }
            else if(num > ar[mid_right]){
                st = mid_right + 1;
            }
            else if(num > ar[mid_left]){
                st = mid_left + 1;
                if(num < ar[mid_right]){
                    end = mid_right - 1;
                }
            }


        }
        return -1;
    }

    static long MEX(List<Long> list){
        long min = 0;
        while(true){
            if(list.contains(min)) min++;
            else
                return min;
        }
    }
    static void swap(int[] a, int[] b, int i, int j){
        a[i] = a[i] + b[j];
        b[j] = a[i] - b[j];
        a[i] = a[i] - b[j];
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
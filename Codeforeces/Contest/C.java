import java.util.*;
import java.lang.*;
import java.io.*;
 
/*
    to compare codes sc codeforces
    https://codeforces.com/contest/2104/submission/335103189?compareWith=335102843
*/
public class C{
    
    static int mod = 1_000_000_000 + 7;
    static int ans = 0;

    public static void main(String[] args) throws java.lang.Exception{
        FastScanner sc = new FastScanner(System.in);
        StringBuilder st = new StringBuilder();
 
        int t = sc.nextInt();
        while(t-- > 0){
            /*
                iterate from array
                1. Block if the element sc subsequence are continegous and occuring n times
                2. Finding the longest subsequence by iteterating through all the elements
            */
            int n = sc.nextInt();
            int[] ar = new int[n];

            for(int i = 0; i < n; i++){
                ar[i] = sc.nextInt();
            }

            st.append(find(ar, n) + "\n");
            ans = 0;

        }
        System.out.println(st);
    }
    static int find(int[] ar, int n){
        int[] dp = new int[n];
    	
        for(int i = 0; i < n; i++){
        	int count = 1;
        	int temp = ar[i];
            int j = i - 1;
            if(temp != count){

                for(j = i - 1; j >= 0; j--){
                    if(count == temp)
                        break;
                    if(ar[j] == temp){
                        count++;
                        if(count == temp)
                            break;
                    }

                }
            }

            if(i == 0)
                dp[i] = count == temp? 1 : 0;
            else
                dp[i] = Math.max((j == -1? dp[i] : dp[j])  + (count == temp? temp : 0), dp[i - 1]);

        }
        return dp[n - 1];


    }

    
 
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
 
    static boolean sortCheck(int[] ar){
        int[] temp = ar.clone();
        return Arrays.equals(ar, temp);
    }
    
 
    static boolean boundedSumDp(List<Integer> list, int temp){
        boolean[] dp = new boolean[temp + 1];
        dp[0] = true;
        for(int i : list){
            if(dp[temp])
                return true;
            for(int j = temp; j >= i; j--){
                dp[j] = dp[j] || dp[j - i];
            }
        }
        return dp[temp]; 
    }
    static int binarySearch(long[] arr, long target){
        int left = 0, right = arr.length - 1;
 
        while (left <= right) {
            int mid = left + (right - left) / 2;  
 
            if (arr[mid] == target)
                return mid;  
            else if (arr[mid] < target)
                left = mid + 1;  
            else 
                right = mid - 1; 
            
        }
        return -1;
    }
 
    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;
 
        FastScanner(InputStream sc) {
            br = new BufferedReader(new InputStreamReader(sc));
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
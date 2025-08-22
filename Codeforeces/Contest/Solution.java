import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution{


    public static void main(String[] args) throws java.lang.Exception{
        FastScanner sc = new FastScanner(System.in);
        StringBuilder ans = new StringBuilder();

        int t = sc.nextInt();
        while(t-->0){
 
            int n=sc.nextInt();
            int[] A=new int[n];
 
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int score=0;
            for(int i=0;i<n;i++){
                if(A[i]!=0 ){
                   score+=A[i];
                }
                else if(A[i]==0){
                    score++;
                }
            }
            ans.append(score + "\n");
        }
        System.out.println(ans);
    }

     /*
    * public static void main(String[] args) throws java.lang.Exception
    {
        FastScanner sc = new FastScanner(System.in);
        StringBuilder ans = new StringBuilder();
        HashMap<Long,Long> map = new HashMap<>();


        int t = sc.nextInt();
        while(t-- > 0){
            long k = sc.nextLong();
            String s = "";

            long sum = 0;

            long i = 1;
            long prevlen = 0;
            while(true){
                if(map.containsKey(k)){
                    ans.append(map.get(k) + "\n");
                    break;
                }
                s += i;

                if(s.length() >= k){

                    for(long j = prevlen; j < k; j++){
                        sum += (Integer.parseInt("" + s.charAt((int)j)));
                    }
                    break;
                }
                else{
                    long temp = i;
                    while(temp > 0){
                        sum += temp%10;
                        temp /= 10;
                    }
                }
                prevlen = s.length();
                map.put(prevlen, sum);
                i++;

            }
            ans.append(sum + "\n");

        }
        System.out.println(ans);


    }
    */


    /*
    Solution-B
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        for (int testcase = 0; testcase < t; testcase++) {
            long n = sc.nextLong();
            ArrayList<Long> res = new ArrayList<>();

            for (int k = 1; k <= 18; k++) {
                long d = 1;
                for (int i = 0; i < k; i++) d *= 10;
                d += 1;

                if (n % d == 0) {
                    long x = n / d;
                    if (x > 0) res.add(x);
                }
            }

            if (res.isEmpty()) {
                ans.append("0\n");
            } else {
                Collections.sort(res);
                ans.append(res.size());
                for (long x : res) ans.append(" ").append(x);
                ans.append("\n");
            }
        }

        System.out.print(ans);
    }*/

    /*
    public static void main(String[] args) throws java.lang.Exception
     {
         FastScanner sc = new FastScanner(System.in);
         StringBuilder ans = new StringBuilder();

         int t = sc.nextInt();

         while(t-- > 0){
             int n = sc.nextInt();
             int m = sc.nextInt();
             int q = sc.nextInt();

             long[] a = new long[n];
             long[] b = new long[m];

             for(int i = 0; i < n; i++){
                 a[i] = sc.nextLong();
             }
             for(int i = 0; i < m; i++){
                 b[i] = sc.nextLong();
             }
             Arrays.sort(a);
             Arrays.sort(b);
             //taking rounds input
             for(int i = 0; i < q; i++){

                 int x = sc.nextInt();
                 int y = sc.nextInt();
                 int z = sc.nextInt();

                 long sum = 0;
                 int idxA = n - 1;
 int idxB = m - 1;
 int xLeft = x, yLeft = y;

 for (int s = 1; s <= z; s++) {
     if (xLeft > 0 && yLeft > 0) {
         if (a[idxA] > b[idxB]) {
             sum += a[idxA--];
             xLeft--;
         } else {
             sum += b[idxB--];
             yLeft--;
         }
     } else if (xLeft <= 0) {
         sum += b[idxB--];
         yLeft--;
     } else {
         sum += a[idxA--];
         xLeft--;
     }
 }

                 ans.append(sum +"\n");

             }
         }
         System.out.println(ans);

     }
     */

    /*
    public static int minimumArea(int[][] grid) {
        int top = Integer.MAX_VALUE;
        int st = Integer.MAX_VALUE;
        int down = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    top = Math.min(top, i + 1);
                    st = Math.min(st, j + 1);

                    down = Math.max(down, i + 1);
                    end = Math.max(end, j + 1);
                }
            }
        }
        System.out.println(top + " " + st + " " + down + " " + end);
        return (down - top + 1) * (end - st + 1);
    }
    */

//     public static void rotate(int[][] matrix) {
//         int n = matrix.length;
//         int m = n;
//         int[][] dp = new int[n][n];
//         n--;
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < m; j++){
//                 dp[i][j] = matrix[n - j][i];
//             }
//         }
//         for(int i = 0; i < m; i++){
//             System.out.println(Arrays.toString(dp[i]));
//         }
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < m; j++){
//                 matrix[i][j] = dp[i][j];
//             }
//         }
//     }
//     public static int numberOfSubmatrices(char[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int[] xfreq = new int[m];
//         int[] yfreq = new int[m];
//         int cnt = 0;
//         for(int i = 0; i < grid.length; i++) {
//             int x = 0;
//             int y = 0;
//             for(int j = 0; j < grid[i].length; j++) {
//                 if(grid[i][j] == 'X') x++;
//                 if(grid[i][j] == 'Y') y++;
//                 xfreq[j] += x;
//                 yfreq[j] += y;
//                 if(xfreq[j] >= 1 && xfreq[j] == yfreq[j]) cnt++;
//             }
//         }
//         return cnt;
//     }
//     public static int numSubmat(int[][] mat) {

//         int n = mat.length , m = mat[0].length;
//         int[][] width = new int[n][m];
//         int res = 0;

//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < m; j++){
//                 if (mat[i][j] == 1)
//                     width[i][j] = (j == 0 ? 0 : width[i][j - 1]) + 1;
//             }
//         }
// //        for(int i = 0; i < n; i++){
// //            System.out.println(Arrays.toString(width[i]));
// //        }
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {

//                 int minWidth = width[i][j];
//                 for (int k = i; k >= 0 && minWidth > 0; k--) {
//                     minWidth = Math.min(minWidth , width[k][j]);
//                     res += minWidth;
//                 }
//             }
//         }
//         return res;

//     }
//     public static long maximumSubarraySum(int[] nums, int k) {
//         long ans = Integer.MIN_VALUE;

//         long sum = 0;
//         int n = nums.length;
//         for(int i = 0; i < n; i++){
//             int j;
//             for(j = i; j < n; j++){
//                 sum += nums[j];
//                 if(Math.abs(nums[i] - nums[j]) == k){
//                     ans = Math.max(sum, ans);
//                 }
//             }

//             sum = 0;
//         }
//         return ans == Integer.MIN_VALUE? 0 : ans;
//     }
//     public static int maxTurbulenceSize(int[] arr) {
//         int ans = 0;
//         int even = 1;
//         int odd = 1;
//         int n = arr.length;
//         if(n == 1)
//             return n;

//         for(int i = 0; i < n - 1; i++){
//             //for i odd and ar[odd] > ar[odd + 1]
//             if(i%2 != 0){
//                 if(arr[i] > arr[i + 1]){
//                     odd++;
//                     even = 1;
//                 }
//                 else if(arr[i] < arr[i + 1]){
//                     odd = 1;
//                     even++;
//                 }
//                 else if(arr[i] == arr[i + 1]){
//                     odd = 1;
//                     even = 1;
//                 }
//             }
//             else{
//                 if(arr[i] > arr[i + 1]){
//                     even++;
//                     odd = 1;
//                 }
//                 else if(arr[i] < arr[i + 1]){
//                     even = 1;
//                     odd++;
//                 }
//                 else if(arr[i] == arr[i + 1]){
//                     odd = 1;
//                     even = 1;
//                 }
//             }
// //            if(even == 9 || odd == 9)
// //                System.out.println("index = " + (i - 9));
//             ans = Math.max(ans,Math.max(odd, even));
//         }
//         return ans;
//     }
//     public static int maxAbsoluteSum(int[] nums) {
//         int n = nums.length;
//         if(n == 1)
//             return Math.abs(nums[0]);

//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, Integer.MIN_VALUE);

//         int temp = 0;
//         for(int i = 0; i < n; i++){
//             temp = nums[i];
//             dp[i + 1] = Math.max(dp[i], Math.abs(temp));

//             for(int j = i + 1; j < n; j++){
//                 dp[i + 1] = Math.max(dp[i + 1], Math.abs(temp));
//                 temp += nums[j];
//             }
//             dp[i + 1] = Math.max(dp[i + 1], Math.abs(temp));
//         }
//         return dp[n];
//     }
//     public static long[] sumOfThree(long num) {

//         for(long i = num/3 + 1; i > 1 && 3*(i - 1) >= num; i--){
//             if(3*(i - 1) == num){
//                 long[] ans = new long[3];

//                 ans[0] = i - 2;
//                 ans[1] = i - 1;
//                 ans[2] = i;
//                 return ans;
//             }

//         }
//         return new long[0];
//     }
//     public static long perfectPairs(int[] nums) {
//         List<List<Integer>> dp = new ArrayList<>();
//         long ans = 0;
//         int n = nums.length;
//         for(int i = 0; i < n; i++){
//             for(int j = i + 1; j < n; j++){

//                 int a = nums[i];
//                 int b = nums[j];
//                 List<Integer> temp = new ArrayList<>();
//                 temp.add(b);
//                 temp.add(a);
//                 Collections.sort(temp);

//                 if(dp.contains(temp)){
//                     ans++;
//                     break;
//                 }

//                 dp.add(temp);

//                 int first = Math.abs(a - b);
//                 int sec = Math.abs(a + b);

//                 a = a < 0? a*(-1) : a;
//                 b = b < 0? b*(-1) : b;
//                 if(Math.max(first, sec) >= Math.max(a, b) && Math.min(first, sec) <= Math.min(a, b))
//                     ans++;
//             }
//         }
//         return ans;
//     }
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

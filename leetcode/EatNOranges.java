package leetcode;
import java.util.*;
public class EatNOranges {
    static int ans = Integer.MAX_VALUE;

    public static int minDays(int n) {
        int[] ar = new int[n + 1];
        Arrays.fill(ar, Integer.MAX_VALUE);
        solve(n, 0, ar);
        return ar[n];
    }
    public static int solve(int n, int days, int[] dp){
        if(n == 0)
            return days;
        if(dp[n] != Integer.MAX_VALUE) return dp[n];
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;
        if(n % 2 == 0){
            two = solve(n - (n/2), days + 1, dp);
        }
        if(n % 3 == 0){
            three = solve(n - (2 * (n/3)),days + 1, dp);
        }
        one = solve(n - 1, days + 1, dp);
        return dp[n] = Math.min(dp[n], Math.min(one, Math.min(two, three)));
    }

    public static void main(String[] args) {
        System.out.println(minDays(10));
    }
}

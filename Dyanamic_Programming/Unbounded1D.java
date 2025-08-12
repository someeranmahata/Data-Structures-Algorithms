import java.util.*;
class Unbounded1D{
	/*
	Given an integer n, return the least number of perfect square numbers that sum to n. A perfect square is an integer that is the square of an integer; 
	in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
	*/
	public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        dp[0] = 0;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= Math.sqrt(i); j++){
                int num = (int)Math.pow(j, 2);
                if(dp[i - num] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1 + dp[i - num]);
                }
            }
        }
        return dp[n];
    }
    /*
	Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers. Return the 
	maximum product you can get.
    */
    public int integerBreak(int n) {
       int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n]; 
    }
}
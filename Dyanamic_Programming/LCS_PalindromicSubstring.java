package Dyanamic_Programming;
import java.util.*;
public class LCS_PalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {

        int n = s.length(), start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];

        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                dp[i][i + len] = s.charAt(i) == s.charAt(i + len) && (len < 2 || dp[i + 1][i + len - 1]);
                if (dp[i][i + len] && len > end - start) {
                    start = i;
                    end = i + len;
                }
            }
        }

        return s.substring(start, end + 1);
    }
    //Not working for the test case  - s = "aacabdkacaa" :(
    public static String longestPalindrome2(String s) {

        int n = s.length();
        if(n == 1) return s;

        int[][] dp = new int[n + 1][n + 1];

        String rev =  "";
        for(int i = n - 1; i >= 0; i--){
            rev += s.charAt(i);
        }
        int maxlen = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == rev.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                }
            }
        }
        if(maxlen == 1) return ("" + s.charAt(0));
        for(int i = 0; i <= n - maxlen; i++){
            for(int j = 0; j <= n - maxlen; j++){
                if(s.charAt(i) == rev.charAt(j) && s.substring(i,maxlen + i).equals(rev.substring(j, maxlen + j)))
                    return s.substring(i, maxlen + i);
            }
        }
        return "";
    }
}

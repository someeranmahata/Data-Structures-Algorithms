package Dyanamic_Programming;
import java.util.*;
public class LCS {
    //Method to count the maximum length of the string with common letter from two string
    public static int lcsMaxPossible(String word1, String word2, int n, int m){
//        System.out.println(word1.charAt(n) + " " + word2.charAt(m));
        if(n < 0 || m < 0)
            return 0;
        if(("" + word1.charAt(n)).equals("" + word2.charAt(m)))
            return 1 + lcsMaxPossible(word1, word2, n - 1, m - 1);

        return Math.max(lcsMaxPossible(word1, word2, n - 1, m), lcsMaxPossible(word1, word2, n, m - 1));
    }

    //Using dynamic programming
    public static int lcsMaxPossible(String st1, String st2){
        int n = st1.length();
        int m = st2.length();

         int[][] dp = new int[n + 1][m + 1];

         for(int i = 0; i <= n; i++){
             for(int j = 0; j <= m; j++){
                 if(i == 0 || j == 0)
                     dp[i][j] = 0;
             }
         }

         for(int i = 1; i <= n; i++){
             for(int j = 1; j <= m; j++){
                 if(("" + st1.charAt(i - 1)).equals("" + st2.charAt(j - 1)))
                     dp[i][j] = 1 + dp[i - 1][j - 1];
                 else
                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
             }
         }
         for(int i = 0; i < dp.length; i++){
             for(int j = 0; j < dp[0].length; j++)
                 System.out.print(dp[i][j] + " ");
             System.out.println();
         }
        return  dp[n][m];
    }
    // Returning the longest subsequence
    public static String LCS(String st1, String st2){
        int n = st1.length();
        int m = st2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(("" + st1.charAt(i - 1)).equals("" + st2.charAt(j - 1)))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        // Now going through the array from end
        String ans = "";
        int i = n;
        int j = m;
        while(i > 0 && j > 0){
            if(("" + st1.charAt(i - 1)).equals("" + st2.charAt(j - 1))){

                ans = ans.concat("" + st1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i][j - 1] > dp[i - 1][j])
                j--;
            else
                i--;
        }

        return ans;
    }
    public static void main(String[] args){
        String st1 = "bgxty";
        String st2 = "abfgtxty";
        System.out.println(lcsMaxPossible(st1, st2, st1.length() - 1, st2.length() - 1));
        System.out.println(lcsMaxPossible(st1, st2));
        System.out.println(LCS(st1, st2));

    }

}

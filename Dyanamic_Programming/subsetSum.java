package Dyanamic_Programming;
import java.util.*;
public class subsetSum {

    public static boolean Possible(int[] arr, int sum){
        int n = arr.length;
        boolean[][] result = new boolean[n+1][sum+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0)
                    result[i][j] = false;
                if(j == 0)
                    result[i][j] = true;
            }
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(arr[i - 1] <= j)
                    result[i][j] = result[i][j - arr[i - 1]] || result[i - 1][j];
                else
                    result[i][j] = result[i - 1][j];
            }
        }
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                System.out.print(result[i][j] + "|");
            }
            System.out.println();
        }
        return result[n][sum];
    }
    boolean dp[][];
    // To check if the subset of sum is present or not , solution below is of eqal subset ans contains the soltion of boolean target sum

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        dp = new boolean[nums.length][sum + 1];

        for (int i = 0; i < nums.length; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i < nums.length; i++) {

            for (int j = 1; j <= sum; j++) {

                if (nums[i] <= j) {

                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];

                } else
                    dp[i][j] = dp[i - 1][j];

            }
        }

        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 5};
        System.out.println(Possible(arr, 5));
    }

}


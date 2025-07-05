package Dyanamic_Programming;
import java.util.*;
public class UniquePathObstacle {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1)
                dp[i][0] = 1;
        }
        for(int j = 1; j < n; j++){
            if(obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1)
                dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0,maxLen = 0;
        for(int i=0;i<nums.length;i++){
            while(nums[i] - nums[left] > 1){
                left++;
            }
            if(nums[i] - nums[left]==1){
                maxLen = Math.max(maxLen,i - left +1);
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        int[]ar = {1,3,2,2,5,2,3,7};
        int[][] ar2 = {{0,0,0,1},{0,0,1,0},{1,0,0,0},{0,0,1,0}};
        System.out.println(uniquePathsWithObstacles(ar2));
        System.out.println(findLHS(ar));
    }
}
